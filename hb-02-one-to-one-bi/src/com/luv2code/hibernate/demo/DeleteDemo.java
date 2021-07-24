package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {
	public static void main(String[] args) {
		System.out.println("começando");
		SessionFactory sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		try {
			int id = 1;
			Session session = sessionFactory.getCurrentSession();
			System.out.println("Deleting instructor");
			session.beginTransaction();
			
			
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Found instructor: "+instructor);
			if(instructor != null) {
				session.delete(instructor);
			}

			session.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
