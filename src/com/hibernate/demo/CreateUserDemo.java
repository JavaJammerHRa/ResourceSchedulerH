package com.hibernate.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ReourceEntity.Reservation;
import com.ReourceEntity.Resource;
import com.ReourceEntity.User;


public class CreateUserDemo {
	
public static void main(String[] args) {
	

	//create session factory
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Reservation.class)
			.addAnnotatedClass(Resource.class)
			.addAnnotatedClass(User.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
//    //Get the current date
//    LocalDate today = LocalDate.now();
//    System.out.println("Current date: " + today);
//    Date d = new SimpleDateFormat("YYYY-MM-dd").parse(today.toString());
//    System.out.println(d);
    try{
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(today.toString());
        System.out.println(d);
		//create a user object
		System.out.println("Creating new resource object...");
		Reservation tempRes = new Reservation(1,d,22);
		
		//start transaction
		session.beginTransaction();
		
		//save the user
		System.out.println("savng the resource object");
		session.save(tempRes);
		
		//commit the transaction 
		session.getTransaction().commit();
    }catch (ParseException e){
    	e.printStackTrace();
    	}
	 finally{
			System.out.println("Done!");
		factory.close();
	}
}

//public SessionFactory sessionFact(c){
//	//create session factory
//	SessionFactory factory = new Configuration()
//			.configure("hibernate.cfg.xml")
//			.addAnnotatedClass(c.class)
//			.buildSessionFactory();
//	
//	Session session = factory.getCurrentSession();
//}

}
