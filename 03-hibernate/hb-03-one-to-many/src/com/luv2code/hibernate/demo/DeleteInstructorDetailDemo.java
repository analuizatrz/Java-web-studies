package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
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
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		try {
			int id = 10;
			Session session = sessionFactory.getCurrentSession();
			
			System.out.println("Deleting course");
			session.beginTransaction();
			
			Course course = session.get(Course.class, id);
			System.out.println("Found course: "+course);
			if(course != null) {
				session.delete(course);
			}

			session.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
