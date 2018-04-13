package com.devskill;

import java.util.HashMap;

public class DataSource {
	
	private HashMap<String,Item> items = new HashMap<>();
	
	public void save(String uuid, Item i) {
		items.put(uuid,i); 
	}
	
	public Item getItem(String uuid) {
		return items.get(uuid);
	}
	
	public int getTotalCount() {
		return items.size();
	}
	
	
	

}
