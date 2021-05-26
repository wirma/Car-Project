package com.car.systems.models;

public enum Transmission {

	NO_MATTER("Без значение "), AUTOMATIC("Автоматична"),SEMI_AUTOMATIC("Полуавтоматична"), MANUAL("Ръчна");

	private String name;

	Transmission(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
