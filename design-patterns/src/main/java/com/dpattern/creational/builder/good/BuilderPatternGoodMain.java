package com.dpattern.creational.builder.good;

import lombok.extern.slf4j.Slf4j;

/**
 * used to build - complex objects which has a lot of configurations
 *
 * idea: Have an object which has different methods to build behaviour. Have another director who takes this object and
 * call the different methods on it and build the complex object and return it.
 */
@Slf4j
public class BuilderPatternGoodMain {
	public static void main(String[] args) {

		HouseBuilder houseBuilder = new ConcreteHouseBuilder();

		CivilEngineer civilEngineer = new CivilEngineer(houseBuilder);
		civilEngineer.constructHouse();
		House house = civilEngineer.getHouse();

		System.out.println("Final House : " + house);


		houseBuilder = new IglooHouseBuilder();
		civilEngineer = new CivilEngineer(houseBuilder);
		civilEngineer.constructHouse();

		house = civilEngineer.getHouse();
		System.out.println("Final House : " + house);

	}

}