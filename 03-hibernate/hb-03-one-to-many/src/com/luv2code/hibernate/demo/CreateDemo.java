package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {
	public static void main(String[] args) {
		System.out.println("começando");
		SessionFactory sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			System.out.println("Creating instructor");
			
			Instructor instructor = new Instructor("Chad", "Darby", "darby@email.com");
			InstructorDetail detail = new InstructorDetail("luv2code", "Luv 2 code !!");
			
			instructor.setDetail(detail);
			
			
			session.beginTransaction();

			session.save(instructor);

			session.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
