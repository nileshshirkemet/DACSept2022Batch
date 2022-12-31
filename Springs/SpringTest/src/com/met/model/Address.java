package com.met.model;

public class Address {

	private static int count = 0;
	
	private int id;
	private String city;
	private String country;
	
	public Address() {
		
		id = ++count;
		System.out.println("Default Address Object created with id: " + id);
		
	}
	
	public Address(String city, String country) {
		this();
		this.city = city;
		this.country = country;
		System.out.println("Default Address Object created with id: \" + id");
	}




	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Address.count = count;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
	
}
