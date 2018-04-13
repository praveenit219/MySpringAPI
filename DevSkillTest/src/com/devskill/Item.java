package com.devskill;

public class Item {
	
	private long findById;
	private String name;
	
	
	

	public long getFindById() {
		return findById;
	}

	public void setFindById(long findById) {
		this.findById = findById;
	}

	public Item(long findById, String name) {
		super();
		this.findById = findById;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Item [findById=" + findById + ", name=" + name + "]";
	}
	
	
	
	

}
