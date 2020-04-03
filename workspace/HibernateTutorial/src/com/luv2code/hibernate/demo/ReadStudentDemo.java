package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {
  
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Student.class)
				                  .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			//create the student object
			System.out.println("Creating a new student object");
			String dob1 = "13/06/1989";
			Date ddob1 = DateUtils.parseDate(dob1);
			Student st = new Student("Forgo","Newman","xyz@test420.com",ddob1);
			
			//start a transaction
            session.beginTransaction();
            
			//save the student object
            System.out.println("Saving the student...");
			session.save(st);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done Commiting..");
			
			System.out.println("Generate student id..."+st.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student theStudent = session.get(Student.class, st.getId());
			System.out.println(theStudent);
			session.getTransaction().commit();
			 
			System.out.println("Done retrieving...");
		}finally {
			factory.close();
		}
	}
}
