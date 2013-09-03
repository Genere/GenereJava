package ru.genere.model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;


public class CatalogTest {
	
	public static void main (String args[]) {
		  String user = "genere_user";//Логин пользователя
          String password = "";//Пароль пользователя
          String url = "jdbc:mysql://91.219.194.19:3306/genere_base";//URL адрес
          String driver = "com.mysql.jdbc.Driver";//Имя драйвера
          try {
               Class.forName(driver);//Регистрируем драйвер
          } catch (ClassNotFoundException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
          }

          Connection c = null;//Соединение с БД
          try {
               c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
               Catalog catalog = new Catalog(c);
               Category cat = catalog.getRootCategoryByLink("mezhkomnatnye-dveri");
               Category sCat = catalog.getSubCetegoryByLink("mezhkomnatnye-dveri", "klassika");
               Product pr = catalog.getProductByLink("mezhkomnatnye-dveri", "klassika", "101.html");
               System.out.println(cat.getTitle());
   			   System.out.println(sCat.getTitle());
			   System.out.println(pr.getTitle());


/*               
   			   HashMap<String, Category> rootCategoryMap = catalog.getRootCategoryMap();
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
*/               
          } catch(Exception e){
               e.printStackTrace();
          }
          finally {
               //Обязательно необходимо закрыть соединение
               try {
                    if(c != null)
                    c.close();
               } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
               }
          }

	}
}

