package com.dpattern.creational.builder;

/**
 * Creational design pattern -
 *
 * Builder pattern aims to "Separate the construction of a complex object
 * from its representation so that the same construction process can create different representations."
 * It is used to construct a complex object step by step and the final step will return the object.
 * The process of constructing an object should be generic so that it can be used to create different
 * representations of the same object.
 *
 * @author Srinath.Rayabarapu
 */
public class BuilderPatternMain {

	public static void main(String[] args) {
		
		MealBuilder builder = new MealBuilder();
		Meal vegBurger = builder.prepareVegBurger();
		vegBurger.showItems();
		System.out.println("Total Cost: " + vegBurger.getCost()+"\n");
		
		Meal chickenBurger = builder.prepareChickenBurger();
		chickenBurger.showItems();
		System.out.println("Total Cost: " + chickenBurger.getCost());
	}

}
