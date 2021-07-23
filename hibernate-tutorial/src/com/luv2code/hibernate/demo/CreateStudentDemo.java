package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	public static void main(String[] args) {
		System.out.println("começando");
		var sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		System.out.println("criada a factory");
		var session = sessionFactory.getCurrentSession();
		try {
			System.out.println("Creating new student");
			var student = new Student("Hermione", "Granger", "hermione@email.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
