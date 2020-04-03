package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
  
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Student.class)
				                  .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Updating the student with id: "+studentId);
			Student theStudent = session.get(Student.class, studentId);
			theStudent.setFirstname("Popeye");
			System.out.println(theStudent);
			session.getTransaction().commit();
			 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update email of student");
			
			session.createQuery("update Student set email='Bruto@bully.com' where Id = '1'")
			.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done Updating...");
		}finally {
			factory.close();
		}
	}
}
