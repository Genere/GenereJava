package ru.genere.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class Catalog {
	
	private Connection con;
	
	ArrayList<Category> catalogList = new ArrayList<Category>();	
//	ArrayList<Category> rootCategoryList = new ArrayList<Category>();
	HashMap<String, Category> rootCategoryMap = new HashMap<String, Category>();
	
	public Catalog(Connection c) {		
		con = c;	
		setCatalog();
		setCategoryList();
	}
	
	public void setCategoryList() {       //составление дерева каталога
		
		Iterator<Category> i = catalogList.iterator();
		
	    while(i.hasNext()) {
			Category cat = i.next();
			cat.setSubCategoryList(catalogList); //cоставляем список подкатегорий для каждой категории
			if (cat.parentID == 0) { 
//		    rootCategoryList.add(cat);//составляем список корневых категорий каталога
		    rootCategoryMap.put(cat.link, cat);
		    }
		}
	
	}
	
	public void setCatalog() {        //загрузка информации о категориях каталога
	
		  try {
			   Statement st = con.createStatement();//Готовим запрос
			   ResultSet rs = st.executeQuery("select * from catalogs");//Выполняем запрос к БД, результат в переменной rs
			   while(rs.next()) {
				   Category cat = new Category(con);
				   
				   cat.id = rs.getInt("id");
				   cat.lang = rs.getString("lang");
				   cat.parentID = rs.getInt("parent_id");
				   cat.title = rs.getString("title");
				   cat.link = rs.getString("link");
				   cat.html = rs.getString("html_code");
				   cat.itemPos = rs.getInt("item_pos");
				   cat.seoID = rs.getInt("seo_id");		   
				   cat.isVisible = rs.getBoolean("visible");
				   cat.isEnd = rs.getBoolean("end");
				   cat.level = rs.getInt("level");
				   cat.icon = rs.getString("icon");
				   cat.description = rs.getString("short_desc");
				   cat.updTime = rs.getInt("time_update");
				   				   
				   
				   catalogList.add(cat);
			   }
		  } catch(Exception e) {
			   e.printStackTrace();
		  }	

}
	
	public ArrayList<Category> getCatalogList() {		
		return catalogList;	
	}
/*	
	public ArrayList<Category> getRootCategoryList() {		
		return rootCategoryList;	
	}
*/
	
	public HashMap<String, Category> getRootCategoryMap() {		
		return rootCategoryMap;	
	}
	
	public Category getRootCategoryByLink(String categoryLink) {
		Category rootCategory = rootCategoryMap.get(categoryLink);
		return rootCategory;
	}
	
	public Category getSubCetegoryByLink(String parentLink, String categoryLink) {
		Category parentCategory = getRootCategoryByLink(parentLink);
		Category subCategory = parentCategory.getSubCategoryByLink(categoryLink);
		return subCategory;
	}
	
	public Product getProductByLink(String parentLink, String categoryLink, String productLink) {
		Category cat = getSubCetegoryByLink(parentLink, categoryLink);
		Product product = cat.getProductByLink(productLink);
		return product;
	}
		
}

