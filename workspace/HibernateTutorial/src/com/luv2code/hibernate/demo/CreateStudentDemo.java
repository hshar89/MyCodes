package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {
  
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Student.class)
				                  .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			//create the student object
			System.out.println("Creating a new student object");
			String dob = "12/02/1996";
			Date theDob = DateUtils.parseDate(dob);
			Student st = new Student("Paul","Wall","xyz@test.com",theDob);
			
			//start a transaction
            session.beginTransaction();
            
			//save the student object
            System.out.println("Saving the student...");
			session.save(st);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}
}
