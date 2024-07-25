package com.hemanshu;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.sql.ordering.antlr.Factory;

public class BookDAO {

	private SessionFactory factory;

	public BookDAO(SessionFactory factory) {
		this.factory = factory;
	}

	public void addBook(Book b) {

		Transaction tx = null;

		try {
			Session session = factory.openSession();

			tx = session.beginTransaction();

			session.save(b);
			tx.commit();
			System.out.println("Book Added Successfully!");
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

	public void deleteBook(int id) {
		Transaction tx = null;

		try {
			Session session = factory.openSession();

			tx = session.beginTransaction();

			Book b = session.get(Book.class, id);

			if (b != null) {
				session.delete(b);
				tx.commit();
				System.out.println("Book Deleted Successfully!");
			} else {

				System.out.println("Book Not Found!");
			}
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

	public void updateBook(int id) {
		Transaction tx = null;

		Book b = null;
		try {
			Session session = factory.openSession();

			tx = session.beginTransaction();

			 b = session.get(Book.class, id);

			b.setRating(6);

			System.out.println("Book Rating Updated Successfully!");

			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}
}
