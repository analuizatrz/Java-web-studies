package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorByDetail {
	public static void main(String[] args) {
		System.out.println("começando");
		SessionFactory sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			int id = 2;
			System.out.println("Deleting instructor");
			session.beginTransaction();
			
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			System.out.println("Found instructor: "+instructorDetail.getInstructor());
			

			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			session.getTransaction().commit();
			sessionFactory.close();
			
		}
	}
}
