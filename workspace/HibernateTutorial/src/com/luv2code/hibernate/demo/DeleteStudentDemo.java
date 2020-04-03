package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
  
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
			System.out.println("Deleting the student with id: "+studentId);
			Student theStudent = session.get(Student.class, studentId);
			System.out.println(theStudent);
			session.delete(theStudent);
			session.getTransaction().commit();
			 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Delete student with id 2");
			
			session.createQuery("delete Student where Id = '2'")
			.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done Deleting...");
		}finally {
			factory.close();
		}
	}
}
