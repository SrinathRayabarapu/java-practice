package com.dpattern.creational.builder.good;

public class Home {
	
	public String floor; 
	public String walls; 
	public String terrace;

	@Override
	public String toString() {
		return "Home{" +
				"floor='" + floor + '\'' +
				", walls='" + walls + '\'' +
				", terrace='" + terrace + '\'' +
				'}';
	}
}
