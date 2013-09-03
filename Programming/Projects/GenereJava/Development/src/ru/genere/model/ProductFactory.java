package ru.genere.model;

import java.util.HashMap;
import java.util.Map;



public class ProductFactory {
	protected Map map = defaultMap();
	
	public Product create(String productType) {
		Class klass = (Class) map.get(productType);
		if (klass == null)
			throw new RuntimeException(getClass() + " was unable to find an product named '" + productType + "'.");
		
		Product productInstance = null;
		try {
			productInstance = (Product) klass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return productInstance;
	}
	protected Map defaultMap() {
		Map map = new HashMap();

		map.put("mezhkomnatnye-dveri", Door.class);


		return map;
	}
}
