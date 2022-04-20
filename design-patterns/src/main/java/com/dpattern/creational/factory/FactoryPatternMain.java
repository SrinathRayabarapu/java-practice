package com.dpattern.creational.factory;

/**
 * In Factory pattern, we create object without exposing the creation logic to the client
 * and refer to newly created object using a common interface.
 *
 * @author Srinath.Rayabarapu
 */
public class FactoryPatternMain {
	
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		IShape shape = shapeFactory.getShape("circle");
		shape.draw();
		
		shape = shapeFactory.getShape("square");
		shape.draw();
		
		shape = shapeFactory.getShape("triangle");
		shape.draw();
	}

}
