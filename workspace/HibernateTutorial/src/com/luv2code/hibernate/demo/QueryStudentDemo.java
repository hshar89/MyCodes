package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {
  
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Student.class)
				                  .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
            session.beginTransaction();
           
            //query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();
            
            System.out.println("Query 1 results...");
            
            displayStudents(theStudents);
            //display students
            
            theStudents = session.createQuery("from Student s where "
            		+ "s.firstname = 'John' OR s.lastname='Wall'").getResultList();
            
            System.out.println("Query 2 results....");
            displayStudents(theStudents);
            
            theStudents = session.createQuery("from Student s where "
            		+ "s.email LIKE '%test2%'").getResultList();
            System.out.println("Query 3 results..");
            displayStudents(theStudents);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student temp: theStudents) {
			System.out.println(temp);
		}
	}
}
