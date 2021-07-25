package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class BreakingTheApplication {
	public static void main(String[] args) {
		System.out.println("começando");
		SessionFactory sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		try {
			System.out.println("--- Creating instructor");
			int id = 1;
			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("--- " + instructor);

			session.getTransaction().commit();
			sessionFactory.close();
			
			// its called after the session is closed. With lazy load it fails
			System.out.println("--- " + instructor.getCourses());

			System.out.println(" --- Done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
