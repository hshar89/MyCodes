package com.Hibernate.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Hibernate.entity.Employee;

public class CreateEmployeeDemo {
   
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				   					.configure("hibernate.cfg.xml")
				   					.addAnnotatedClass(Employee.class)
				   					.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			System.out.println("Creating a new student object");
			
			Employee emp1 = new Employee("Mega","Mind","Deloitte");
			Employee emp2 = new Employee("Damn","Man","Accenture");
			Employee emp3 = new Employee("Loud","Wolf","Motilal");
			session.beginTransaction();
			
			System.out.println("Saving the student...");
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
		   factory.close();
		}
	}
}
