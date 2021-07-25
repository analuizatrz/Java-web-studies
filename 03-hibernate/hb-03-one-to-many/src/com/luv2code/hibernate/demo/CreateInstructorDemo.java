package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {
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
			System.out.println("Creating instructor");
			
			Instructor instructor = new Instructor("Lucy", "Darby", "darby@email.com");
			InstructorDetail detail = new InstructorDetail("luv2code", "Video games");
			
			instructor.setDetail(detail);			
			
			session.beginTransaction();

			session.save(instructor);

			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.getTransaction().commit();
			sessionFactory.close();
			
		}
	}
}
