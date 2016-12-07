package com.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ReourceEntity.User;

public class TestJdbc {
	
public static void main(String[] args) {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(User.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	try {
		//create a user object
		User tempUser = new User(22,"dave","jones","dave@gmail.com","01-01-99","074151241");
		
		//start transaction
		session.beginTransaction();
		
		//save the user
		session.save(tempUser);
		
		//commit the transaction 
		session.getTransaction().commit();
		
	} finally{
		factory.close();
	}
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/resourceschedular?useSSL=false";
	String user = "conceptuser";
	String pass = "conceptuser";
	
	try {
		System.out.println("Connecting to database" + jdbcUrl);
		Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
		System.out.println("Connection Successful");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

}
