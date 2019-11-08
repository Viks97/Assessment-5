package web.assess5;

import java.util.List;
import java.util.Scanner;

import web.assess5.HibernateOGMUtil;
import web.assess5.Product;
import web.assess5.ProductDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int option=0;
        ProductDao pDao=new ProductDao();
		 
		  do{
	            System.out.println("\\~~~~Menu~~~~//");
	            System.out.println("\\\\~~~~Stock Section~~~~////");
	            System.out.println("1> Add Product to stock");
	            System.out.println("2> Update Product in Stock");
	            System.out.println("3> Delete Product in stock");
	            System.out.println("4> Print all the Product in stock");
	            System.out.println("Option:");
	            option=s.nextInt();
	            switch (option){
             case 1:
                  pDao.add(); 
                 break;
             case 2:
             	System.out.println("Enter name of Product to update:");
             	String name=s.next();
             	pDao.update(name);
                 break;
             case 3:
             	System.out.println("Enter name of Product to delete:");
             	String newName=s.next();
             	pDao.delete(newName);
             	break;
             	
             case 4:
                 List<Product> plist=pDao.print();
                 for(Product i:plist)
                 {
                 	System.out.println(i);
                 }

             default:
             	option=8;
             	break;
         }
     }while ( option !=8);	

	}

	}


