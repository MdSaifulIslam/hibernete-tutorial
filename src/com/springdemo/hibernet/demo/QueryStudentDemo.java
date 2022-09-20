package com.springdemo.hibernet.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernet.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();

			session.beginTransaction();
			
			List<Student> theStudents= session.createQuery("from Student").getResultList();
			
			//All rows
			System.out.println("\n\nAll Students: ");
			displayStudents(theStudents);

			theStudents= session.createQuery("from Student s where s.firstName like '%test'").getResultList();
			
			//Conditioned rows
			System.out.println("\n\nStudent List with condition [firstName include - {* test}]");
			displayStudents(theStudents);
			
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}

}
