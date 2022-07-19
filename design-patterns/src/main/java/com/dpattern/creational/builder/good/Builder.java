package com.dpattern.creational.builder.good;

interface Builder {
	
	public void buildFloor(); 
	  
    public void buildWalls(); 
  
    public void bulidTerrace(); 

    public Home getComplexHomeObject();  
	
}