package ru.genere.persistence;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import javax.servlet.ServletConfig;


public class GenereDatabase {

	protected static GenereDatabase singleton;
	private String user;//Логин пользователя
	private String password;//Пароль пользователя
	private String url;//URL адрес
	private String driver;//Имя драйвера
    Connection c = null;//Соединение с БД
	
	public static GenereDatabase getSingleton() {
		if (singleton == null)
			singleton = new GenereDatabase();
		return singleton;
	}
	
	public Connection initialize() {
		
          try {
               Class.forName(driver);//Регистрируем драйвер
          } catch (ClassNotFoundException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
          }

          try {
               c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  
		  return c;
			
	}
	
	public void setInitParameters(ServletConfig config) {
		
		user = config.getInitParameter("dbUser");//Логин пользователя
		password = config.getInitParameter("dbPassword");//Пароль пользователя
		url = config.getInitParameter("dbUrl");//URL адрес
		driver = config.getInitParameter("dbDriver");//Имя драйвера
	}
	
	public void shutDown() {
		try {
				if(c != null)
				c.close();
		   } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		   }
	}
	
}
