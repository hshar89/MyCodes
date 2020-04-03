package com.Hibernate.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Hibernate.entity.Employee;

public class UpdateEmployeeDemo {
   
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				   					.configure("hibernate.cfg.xml")
				   					.addAnnotatedClass(Employee.class)
				   					.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			System.out.println("Creating a new student object");
			session.beginTransaction();
			int empid = 1;
			Employee emp = session.get(Employee.class, empid);
			emp.setFirstName("Grammer");
			
			System.out.println("Saving the student...");
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Employee set company='Striker' where id=2").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
		   factory.close();
		}
	}
}
