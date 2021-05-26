package com.car.systems.models;

public enum Model{
	
	ALL_TYPES("Всички типове"), GASOLINE("Бензин"),DIESEL("Дизел"),ELECTRIC("Електрически"),HYBRID("Хибриден");

	private String name;

	Model(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
