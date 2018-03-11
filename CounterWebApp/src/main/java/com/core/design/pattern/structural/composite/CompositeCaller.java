package com.core.design.pattern.structural.composite;



/**
 * Composite design pattern comes under structural design pattern as 
 * its talks about composition of two or more different objects.
 * 
 * It follows a binary tree structure where in the root node is called 'Composite'
 * and child note can be either again a sub 'Composite' node or 'Leaf' node(which doesn't any child node).
 * 
 * Example below explains this patter by composing a computer with multiple other objects like CPU & Moniter peripherals.
 * 
 * This pattern states that there should some similar operations can be performed at every level of node in a tree.
 * Ex : ram.getCost() & cpu.getCost() & computer.getCost();
 * Same operation on all objects.
 */
public class CompositeCaller {

	public static void main(String[] args) throws CloneNotSupportedException {

	 Component ram = new Leaf("Ram", 4500l);
	 Component hd = new Leaf("Hard disk", 5000l);
	 Component mb = new Leaf("mother borad", 9500l);

	 Component mouse = new Leaf("Mouse", 1000l);
	 Component speaker = new Leaf("spearker", 900l);
	 Component keyBoard = new Leaf("keyBoard", 900l);
	 
	 Composite cpu = new Composite("CPU");
	 cpu.addComponent(ram);
	 cpu.addComponent(hd);
	 cpu.addComponent(mb);

	 Composite moniterPeripherals = new Composite("Monither peripherals");
	 moniterPeripherals.addComponent(mouse);
	 moniterPeripherals.addComponent(speaker);
	 moniterPeripherals.addComponent(keyBoard);

	 Composite computer = new Composite("Computer");
	 computer.addComponent(cpu);
	 computer.addComponent(moniterPeripherals);
	 
	 
	 System.out.println(computer.getName()+"\n"+computer.getPrice());
	}
}
