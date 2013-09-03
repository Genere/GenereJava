package ru.genere.persistence;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;

import ru.genere.model.*;


public class GenereDatabaseTest {
	
	public static void main (String args[]) {
    		   GenereDatabase db = GenereDatabase.getSingleton();
	           Connection c = db.initialize();//Соединение с БД
               Catalog catalog = new Catalog(c);
   			   ArrayList<Category> rootCategoryList = catalog.getRootCategoryList();
   			   Category category = rootCategoryList.get(6);
   			   ArrayList<Category> subcategoryList = category.getSubCategoryList();
   			   Category cat = subcategoryList.get(1);
   			   ArrayList<Product> prodList = cat.getProductList();

               System.out.println(cat.title);
               
               if (prodList != null) {
	               
	               Iterator<Product> i = prodList.iterator();
	               
	               while (i.hasNext()) {
					   Product pr = i.next();
					   System.out.println(pr.getTitle());
					   System.out.println(pr.getJsp());
				   }
		       } else {
				   System.out.println("can't get products");
			   }
               
               //Обязательно необходимо закрыть соединение
		db.shutDown();
	}
}

