package com.car.systems.models;

public enum COUPE_TYPE {
	ALPHA_ROMEO("Alpha Romeo"), ASTON_MARTIN("Aston Martin"),AUDI("Audi");

	private String name;

	COUPE_TYPE(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
