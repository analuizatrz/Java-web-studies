package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {
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
			int id = 1;
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, id);
			Course softwareEngineering = new Course("Software Engineering");
			Course machineLearning = new Course("Machine Learning");
			
			instructor.add(softwareEngineering);
			instructor.add(machineLearning);
			
			session.save(softwareEngineering);
			session.save(machineLearning);
			

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
