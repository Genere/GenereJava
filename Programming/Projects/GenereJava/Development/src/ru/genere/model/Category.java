package ru.genere.model;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;



public class Category {
	
//	public ArrayList<Category> subcatList = new ArrayList<Category>();//лист подкатегорий категории каталога
	public HashMap<String, Category> subcatMap = new HashMap<String, Category>();
//	public ArrayList<Product> productList;//лист товаров категории каталога
	public HashMap<String, Product> productMap;//лист товаров категории каталога
	public Category parent;

	
	//Данные из базы
	public int id;
	public String lang;
	public int parentID;		
	public String title;
	public String link;
	public String html;	
	public int itemPos;
	public int seoID;	
	public boolean isVisible;
	public boolean isEnd;
	public int level;
	public String icon;
	public String description;
	public int updTime;
	private String jsp = "/category.jsp";
	//конец данных из базы
	
	private Connection con; //соединение с базой


	
	public Category() {	
	}
	
	public Category(Connection c) {
		con = c;
	}
	
	public void setSubCategoryList(ArrayList<Category> catalogList) { //создаем дерево каталога из одного массива
	
		Iterator<Category> i = catalogList.iterator();
		
	    while(i.hasNext()) {
			Category cat = i.next();
			if (cat.parentID == id) {  
//			    subcatList.add(cat);				
			    cat.parent = this; //устанавливаем родительскую категорию
			    subcatMap.put(cat.link, cat);
			}
						
		}
	
	}
/*	
	public ArrayList<Category> getSubCategoryList() {		
		return subcatList;	
	}
*/	
	public HashMap<String, Category> getSubCategoryMap() {		
		return subcatMap;	
	}
	
	private void setProductList() {
		
//		productList = new ArrayList<Product>();
		productMap = new HashMap<String, Product>();
		
		try {
	    PreparedStatement st = con.prepareStatement("select * from showroom where cat_id = ?");//Готовим запрос
	    st.setInt(1, id);
	    ResultSet rs = st.executeQuery();//Выполняем запрос к БД, результат в переменной rs
	    
	    ProductFactory productFactory = new ProductFactory();
	    
	    while(rs.next()) {
			
			try {				
			    Product product = productFactory.create(this.parent.link); //создаем товар класса в зависимости от категории, в которой находится товар	

				product.setId(rs.getInt("id"));
				
				product.setTitle(rs.getString("title"));
				
				product.setItemPos(rs.getInt("item_pos"));
				
				product.setCatID(rs.getInt("cat_id"));
				
				product.setIsVisible(rs.getBoolean("visible"));
				
				product.setHtml(rs.getString("html"));
				
				product.setPrice(rs.getInt("price"));
				
				product.setWPrice(rs.getInt("price_w"));
				
				product.setOakPrice(rs.getInt("price_dub"));
				
				product.setAlderPrice(rs.getInt("price_olha"));
				
				product.setLink(rs.getString("link"));
				
				product.setMaterial(rs.getString("material"));
				
				product.setSize(rs.getString("size"));
				
				product.setSeoID(rs.getInt("seo_id"));
				
				product.setUpdateTime(rs.getInt("time_update"));
											   
//			    productList.add(product);	
				setProductMap(product.getLink(), product);
		    	
		    } catch(Exception e) {
				e.printStackTrace();
			}
		}			
	    } catch(Exception e) {
            e.printStackTrace();
	    }	
	}
		

/*	
	public ArrayList<Product> getProductList() {
		
		if (productList == null) 
			setProductList();
		
		return productList;	
	
	}
*/	
	public HashMap<String, Product> getProductMap() {
		
		if (productMap == null) 
			setProductList();
		
		return productMap;	
	
	}
	
	public void setProductMap(String key, Product product) {
		productMap.put(key, product);
	}
	
	public Category getSubCategoryByLink(String catLink) {
		return subcatMap.get(catLink);
	}
	
	public Product getProductByLink(String productLink) {
		if (productMap == null) 
			setProductList();
		return productMap.get(productLink);
	}
	
	//geters	
	public int getId() {
		return id;
	}
	
	public String getLang() {
		return lang;
	}
	
	public int getParentID() {
		return parentID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getLink() {
		return link;
	}
	
	public String getHtml() {
		return html;
	}	
	
	public int getItemPos() {
		return itemPos;
	}
	
	public int getSeoID() {
		return seoID;
	}
		
	public boolean getIsVisible() {
		return isVisible;
	}
	
	public boolean getIsEnd() {
		return isEnd;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getIcon() {
		return icon;
	}	
	
	public String getDescription() {
		return description;
	}
		
	public int getUpdTime() {
		return updTime;
	}
	
	public String getJsp() {
		return jsp;
	}

//seters
	public void setId(int id) {
		this.id = id;
	}
	
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public void setHtml(String html) {
		this.html = html;
	}	
	
	public void setItemPos(int itemPos) {
		this.itemPos = itemPos;
	}
	
	public void setSeoID(int seoID) {
		this.seoID = seoID;
	}
		
	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public void setIsEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}	
	
	public void setDescription(String description) {
		this.description = description;
	}
		
	public void setUpdTime(int updTime) {
		this.updTime = updTime;
	}
	
	public void setJsp(String jsp) {
		this.jsp = jsp;
	}
		
}

