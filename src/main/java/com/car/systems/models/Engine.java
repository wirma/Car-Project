package com.car.systems.models;

public enum Engine {
	INTERNAL(""), EXTERNAL("");

	private String name;

	Engine(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
