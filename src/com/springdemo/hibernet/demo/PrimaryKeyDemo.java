package com.springdemo.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernet.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();

			Student tempStudent1 = new Student("Salam", "Saharior", "asif@gmail.com");
			Student tempStudent2 = new Student("Jamal", "Saharior", "asif@gmail.com");
			Student tempStudent3 = new Student("Kudddus", "Saharior", "asif@gmail.com");

			session.beginTransaction();
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
