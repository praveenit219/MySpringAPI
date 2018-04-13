package com.devskill;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ENv {

	public static void main(String[] args) {
		Set<DataSource> datasources = new HashSet<>();
		createDataSources(datasources);
		createItems(datasources);
		
		//datasources.stream().forEach(ds->ds.getItem("12").getFindById());
		datasources.stream().map(ds->ds.getItem("34")).forEach(System.out::println);
		//Optional<Item> listItems = datasources.stream().map(ds->ds.getItem("12")).sorted().findFirst();
		Optional<Item> listItems = datasources.stream().map(ds->ds.getItem("34")).sorted((e1,e2)->Long.compare(e1.getFindById(), e2.getFindById())).findFirst();
		System.out.println("--"+listItems.orElse(null));
	
		
		
	}

	private static void createDataSources(Set<DataSource> datasources) {
		DataSource obj1 = new DataSource();
		datasources.add(obj1);
		DataSource obj2 = new DataSource();
		datasources.add(obj2);
		DataSource obj3 = new DataSource();
		datasources.add(obj3);
		DataSource obj4 = new DataSource();
		datasources.add(obj4);
		
	}

	private static void createItems(Set<DataSource> ds) {
		
		//Item item1 = new Item();
		//item1.setFindById(new Date().getTime());
		//item1.setName("123");
		ds.forEach(d->d.save("12",new Item(System.nanoTime() ,"123")));
		//Item item2 = new Item();
		//item2.setFindById(new Date().getTime());
		//item2.setName("abc");
		ds.forEach(d->d.save("34",new Item(System.nanoTime(),"abc")));
		//Item item3 = new Item();
		//item3.setFindById(new Date().getTime());
		//item3.setName("XYZ");
		ds.forEach(d->d.save("56",new Item(System.nanoTime(),"XYZ")));
		//Item item4 = new Item();
		//item4.setFindById(new Date().getTime());
		//item4.setName("xyz");
		ds.forEach(d->d.save("78",new Item(System.nanoTime(),"xyz")));
		//Item item5 = new Item();
		//item5.setFindById(new Date().getTime());
		//item5.setName("edf");
		ds.forEach(d->d.save("90",new Item(System.nanoTime(),"edf")));
		
		
		
	}
}
