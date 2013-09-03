package ru.genere.model;

public abstract class Product {
	
	//данные из базы
	private int id;
	private String title;
	private int itemPos;
	private int catID;
	private boolean isVisible;
	private String html;
	private int price;
	private int wPrice;
	private int oakPrice;
	private int alderPrice;
	private String link;
	private String material;
	private String size;
	private int seoID;
	private int updateTime;
    //конец данных из базы
    
	public String jsp;
	public String productType;
	public Category parent;	
	

//geters	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getItemPos() {
		return itemPos;
	}
	public int getCatID() {
		return catID;
	}
	
	public boolean getIsVisible() {
		return isVisible;
	}
	
	public String getHtml() {
		return html;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getWPrice() {
		return wPrice;
	}
	
	public int getOakPrice() {
		return oakPrice;
	}
	
	public int getAlderPrice() {
		return alderPrice;
	}
	
	public String getLink() {
		return link;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public String getSize() {
		return size;
	}
	
	public int getSeoID() {
		return seoID;
	}
	
	public int getUpdateTime() {
		return updateTime;
	}
	
	public String getJsp() {
		return jsp;
	}

//seters
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setItemPos(int itemPos) {
		this.itemPos = itemPos;
	}
	public void setCatID(int catID) {
		this.catID = catID;
	}
	
	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public void setHtml(String html) {
		this.html = html;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setWPrice(int wPrice) {
		this.wPrice = wPrice;
	}
	
	public void setOakPrice(int oakPrice) {
		this.oakPrice = oakPrice;
	}
	
	public void setAlderPrice(int alderPrice) {
		this.alderPrice = alderPrice;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setSeoID(int seoID) {
		this.seoID = seoID;
	}
	
	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}
	
	public abstract void setJsp();

}

