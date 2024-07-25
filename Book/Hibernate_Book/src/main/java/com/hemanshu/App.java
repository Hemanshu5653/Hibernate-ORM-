package com.hemanshu;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static SessionFactory factory;

	public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	
    	Configuration config = new Configuration ();
    	
    	config.configure("hibernate.cfg.xml");
    	
    	factory = config.buildSessionFactory();
    	
    	int ch;
    	
    	BookDAO bd = new BookDAO(factory);
    	
    	do {
    		System.out.println("Menu");
    		System.out.println("1.Add Book");
    		System.out.println("2.Delete Book");
    		System.out.println("3.Update Book");
    		System.out.println("4.Exit");
    		System.out.println("Enter Your Choice :");
    		ch = sc.nextInt();
    		
    		switch(ch) {
    		 
	    		case 1:{
	    			System.out.println("Enter Book Id: ");
	    			int id= sc.nextInt();	
	    			System.out.println("Enter Book Name ");
	    			String name= sc.next();
	    			sc.nextLine();
	    			System.out.println("Enter Book Rating: ");
	    			int rating= sc.nextInt();
	    			
	    			Book b = new Book(id,name,rating);
	    			
	    			bd.addBook(b);
	    			break;
	   
	  
	    		}
	    	  
	    		case 2:{
	    			System.out.println("Enter Book Id : ");
	    			int id = sc.nextInt();
	    			bd.deleteBook(id);
	    			break;
	    		}
	    		case 3:{
	    			System.out.println("Enter Book Id: ");
	    			int id = sc.nextInt();
	    			bd.updateBook(id);
	    			break;
	    		}
	    		default : {
	    			System.out.println("Envalid choice !");
	    			break;
	    		}
	    		
	    		
    		}
    		
    		
    		
    		
    	}
    	while(ch!=4);
    	
    	
    }
}
