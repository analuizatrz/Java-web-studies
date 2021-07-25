package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteCourse {
	public static void main(String[] args) {
		System.out.println("começando");
		SessionFactory sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		try {
			int id = 13;
			session.beginTransaction();
			
			Course course = session.get(Course.class, id);
			
			System.out.println("Loaded course :"+course);
			
			session.delete(course);

			session.getTransaction().commit();
			
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sessionFactory.close();
			
		}
	}
}
