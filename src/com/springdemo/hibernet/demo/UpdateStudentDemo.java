package com.springdemo.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernet.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {

			int studentId = 1;

			Session session = factory.getCurrentSession();
			session.beginTransaction();

			Student theStudent = session.get(Student.class, studentId);

			theStudent.setFirstName("Updated Name");

			session.getTransaction().commit();
			// Update all...
			session = factory.getCurrentSession();
			session.beginTransaction();

			session.createQuery("update Student set email = 'updated-email@update.com'").executeUpdate();

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
