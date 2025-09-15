package com.jdk18.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
	private String name;
	private int qty;
	
	@Override
	public String toString() {
		return getName() + " "+ getQty();
	}

	public Product(String name, int qty) {
		super();
		this.setName(name);
		this.setQty(qty);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}

class Product2 {
	private String name;
	private int qty;
	
	@Override
	public String toString() {
		return getName() + " "+ getQty();
	}

	public Product2(String name, int qty) {
		super();
		this.setName(name);
		this.setQty(qty);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}

public class ProductTest {

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(
				new Product("MotherBoard", 5),
				new Product("Speaker", 20));
		
		System.out.println("get list of products where name is not null");
		List<Product> collect = products.
				stream().
				filter(name -> name != null).
				collect(Collectors.toList());
		
		collect.forEach(p -> System.out.println(p));
		
		
		System.out.println("Convert List<Products> object to List<Names>");
		List<String> nameList = products.
				stream().
				map(Product::getName).
				collect(Collectors.toList());
		nameList.forEach(name -> System.out.println(name));
		
		System.out.println("get quantity list where quantity > 10");
		List<Integer> qtyList = products.
				stream().
				filter(prd -> prd.getQty() > 10).
				map(Product::getQty).
				collect(Collectors.toList());
		qtyList.forEach(qty -> System.out.println(qty));
		
		System.out.println("write a expression to convert pojo list to map");
		Map<String, Integer> map = products.
				stream().
				collect(Collectors.toMap(Product::getName, Product::getQty));
		System.out.println(map);
		
		System.out.println("using foreach write a expression to convert pojo list to map");
		Map<String, Integer> productMap = new HashMap<>();
		products.stream().forEach(product -> productMap.put(product.getName(), product.getQty()));
		System.out.println(productMap);

		List<Product2> product2Lst = products.
				stream().
				map(product -> new Product2(product.getName(), product.getQty())).
				collect(Collectors.toList());
		System.out.println(product2Lst);
	}

}
