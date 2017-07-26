package com.wildfly.domain;

public class Seat {

	private Integer id;
	private int price;
	private boolean booked;
	private String name;

	public Seat(int id, String name, int price) {
		this (id, name, price, false);
	}

	public Seat (int id, String name, int price, boolean booked) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.booked = booked;
	}
	
	public Integer getId() {
		return this.id;	
	}

	public boolean isBooked() {
		return this.booked;
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return name;
	}
}
