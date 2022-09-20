package com.springdemo.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernet.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();

			Student tempStudent = new Student("Read test", "Saharior", "asif@gmail.com");

			session.beginTransaction();
			
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			//Reading the information from the database
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student theStudent =  session.get(Student.class, tempStudent.getId());
			
			session.getTransaction().commit();
			
			System.out.println(theStudent);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
