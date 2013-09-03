package ru.genere.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTest {
     public static void main(String []args){
          String user = "genere_user";//Логин пользователя
          String password = ";+VFl5U4~!Bn";//Пароль пользователя
          String url = "jdbc:mysql://91.219.194.19:3306/genere_base";//URL адрес
          String driver = "com.mysql.jdbc.Driver";//Имя драйвера
          try {
               Class.forName(driver);//Регистрируем драйвер
          } catch (ClassNotFoundException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
          }

          Connection c = null;//Соединение с БД
          try{
               c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
               Statement st = c.createStatement();//Готовим запрос
               ResultSet rs = st.executeQuery("select * from showroom");//Выполняем запрос к БД, результат в переменной rs
               while(rs.next()){
                    System.out.println(rs.getString("title"));//Последовательно для каждой строки выводим значение из колонки ColumnName
               }
          } catch(Exception e){
               e.printStackTrace();
          }
          finally{
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
