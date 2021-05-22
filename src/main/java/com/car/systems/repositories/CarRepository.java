package com.car.systems.repositories;

import org.springframework.data.repository.CrudRepository;

import com.car.systems.models.Car;

public interface CarRepository extends CrudRepository<Car, Long>{

}
