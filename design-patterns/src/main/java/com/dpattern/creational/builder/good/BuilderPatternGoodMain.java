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
		
		//create object of required home builder
		EarthQuakeResistantBuilder earthQuakeResistantBuilder = new EarthQuakeResistantBuilder();
		
		//create object of director that will keep an eye on your builder
		Director director = new Director(earthQuakeResistantBuilder);

		// configuring the object
		director.manageRequiredHomeConstruction();

		// return the built object
		Home homeConstructedAtTheEnd = director.getComplexObjectOfHome();
		
		log.info(homeConstructedAtTheEnd.toString());
	}

}