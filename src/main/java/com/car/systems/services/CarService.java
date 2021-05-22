package com.car.systems.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.systems.models.Car;
import com.car.systems.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public void saveCar(String name) {
		Car user = new Car();
		user.setName(name);
		carRepository.save(user);
	}

	public Iterable<Car> getAllCars() {
		return carRepository.findAll();
	}

	public Car getCar(Long id) {
		Optional<Car> optinalCar = carRepository.findById(id);
		if (optinalCar.isPresent()) {
			return optinalCar.get();
		} else {
			return null;
		}
	}
}
