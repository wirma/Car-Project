package com.car.systems.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private Brand brand;

	@Enumerated(EnumType.STRING)
	private Model model;

	@Column
	private String engineModification;
	
	@Column
	private String color;
	
	@Column
	private String generation;
	
	@Column
	private Long doorsCount;
	
	@Column
	private String power;
	
	@Column
	private Long maxSpeed;
	
	@Enumerated(EnumType.STRING)
	private COUPE_TYPE coupeType;
	
	@Column
	private Long fuelConsumption;
	
	@Column
	private String frontSuspension;
	
	@Column
	private String backSuspension;
	
	@Column
	private Long numberOfSpeeds;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getEngineModification() {
		return engineModification;
	}

	public void setEngineModification(String engineModification) {
		this.engineModification = engineModification;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public Long getDoorsCount() {
		return doorsCount;
	}

	public void setDoorsCount(Long doorsCount) {
		this.doorsCount = doorsCount;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public Long getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Long maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public COUPE_TYPE getCoupeType() {
		return coupeType;
	}

	public void setCoupeType(COUPE_TYPE coupeType) {
		this.coupeType = coupeType;
	}

	public Long getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(Long fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public String getFrontSuspension() {
		return frontSuspension;
	}

	public void setFrontSuspension(String frontSuspension) {
		this.frontSuspension = frontSuspension;
	}

	public String getBackSuspension() {
		return backSuspension;
	}

	public void setBackSuspension(String backSuspension) {
		this.backSuspension = backSuspension;
	}

	public Long getNumberOfSpeeds() {
		return numberOfSpeeds;
	}

	public void setNumberOfSpeeds(Long numberOfSpeeds) {
		this.numberOfSpeeds = numberOfSpeeds;
	}

	

}
