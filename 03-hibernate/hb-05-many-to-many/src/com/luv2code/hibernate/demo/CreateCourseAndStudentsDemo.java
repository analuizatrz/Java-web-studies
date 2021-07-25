package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {
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
			System.out.println("Creating instructor");
			int id = 1;
			session.beginTransaction();
			Course softwareEngineering = new Course("Software Engineering");
			System.out.println("saving course");
			
			session.save(softwareEngineering);
			System.out.println("course saved");
			
			Student harry = new Student("Harry", "Potter", "harry@email.com");
			Student hermione = new Student("Hermione", "Granger", "hermione@email.com");
			
			softwareEngineering.add(harry);
			softwareEngineering.add(hermione);
			
			System.out.println("\nSaving students ...");
			
			session.save(harry);
			session.save(hermione);
			
			System.out.println("Saved students: " + softwareEngineering.getStudents());
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sessionFactory.close();
			
		}
	}
}
