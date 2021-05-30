package com.car.systems.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.systems.models.Car;
import com.car.systems.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public void saveCar(Car car) {
		carRepository.save(car);
	}

	public void deleteCar(Long carId) {
		carRepository.deleteById(carId);
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

	public Iterable<Car> compareCars(Long carId1, Long carId2) {
		ArrayList<Long> idList = new ArrayList<Long>();
		idList.add(carId1);
		idList.add(carId2);
		return carRepository.findAllById(idList);
	}
}
