package com.springdemo.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernet.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {

			int studentId = 1;

			Session session = factory.getCurrentSession();
			session.beginTransaction();

			Student theStudent = session.get(Student.class, studentId);
			//delete student
			System.out.println("Delete ID =1");
			session.delete(theStudent);

			session.getTransaction().commit();
			// delete where id =2
			session = factory.getCurrentSession();
			session.beginTransaction();

			session.createQuery("delete Student where id = 2").executeUpdate();

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
