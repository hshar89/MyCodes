package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

//create the student object
			System.out.println("Creating a new student object");
			String dob1 = "13/04/1999";
			String dob2 = "19/09/1898";
			String dob3 = "21/04/2002";
			Date ddob1 = DateUtils.parseDate(dob1);
			Date ddob2 = DateUtils.parseDate(dob2);
			Date ddob3 = DateUtils.parseDate(dob3);
			Student st1 = new Student("Test7", "Dragon", "xyz@test7.com",ddob1);
			Student st2 = new Student("Test8", "Monk", "xyz@test8.com",ddob2);
			Student st3 = new Student("Test9", "Train", "xyz@test9.com",ddob3);
			session.beginTransaction();

			System.out.println("Saving the student...");
			session.save(st1);
			session.save(st2);
			session.save(st3);
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
          factory.close();
		}

	}

}
