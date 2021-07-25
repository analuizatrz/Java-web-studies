package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {
	public static void main(String[] args) {
		System.out.println("começando");
		SessionFactory sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		try {
			int id = 2;
			Session session = sessionFactory.getCurrentSession();
			
			System.out.println("Deleting instructor");
			session.beginTransaction();
			
			InstructorDetail detail = session.get(InstructorDetail.class, id);
			System.out.println("Found instructor: "+detail);
			if(detail != null) {
				session.delete(detail);
			}

			session.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
