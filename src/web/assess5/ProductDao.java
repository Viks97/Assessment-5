package web.assess5;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import web.assess5.HibernateOGMUtil;
import web.assess5.Product;


public class ProductDao {
private static EntityManagerFactory entityManagerFactory;
	
	public void add() {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Name:");
		String name=s.next();
		System.out.println("Description:");
		String desp=s.next();
		System.out.println("Price:");
		int price=s.nextInt();
		System.out.println("Quantity:");
		int quantity=s.nextInt();
		
		Product p=new Product(name,desp,price,quantity);
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void update(String name) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		Product product=em.createQuery("select s from Product s where name= :name",Product.class).setParameter("name",name).getResultList().get(0);
		Scanner s=new Scanner(System.in);
		System.out.println("Enter new Name:");
		String newName=s.next();
		System.out.println("Enter new Description:");
		String newDesp=s.next();
		System.out.println("Enter new Price:");
		int newPrice=s.nextInt();
		System.out.println("Enter new Quantity:");
		int newQuantity=s.nextInt();
		product.setName(newName);
		product.setDesp(newDesp);
		product.setPrice(newPrice);
		product.setQuantity(newQuantity);
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
	}
	
	public List<Product> print(){
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("select s from Product s",Product.class).getResultList();
	
	}
	
	public void delete(String name)
	{
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		Product product=em.createQuery("select s from Product s where name= :name",Product.class).setParameter("name",name).getResultList().get(0);
	
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
		
	
	}
}
