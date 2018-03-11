package com.core.design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Composite implements Component{
	
	private List<Component> leafs = new ArrayList<>();
	private String name;
	private Long price;
	
	public Composite(String name) {
		super();
		this.name = name;
	}

	public List<Component> getLeafs() {
		return leafs;
	}

	@Override
	public String getName() {
		String collect = getLeafs().parallelStream().map(leaf -> "\t"+leaf.getName()).collect(Collectors.joining("\n"));
		return this.name+"\n"+collect;
	}

	@Override
	public Long getPrice() {
		return getLeafs().stream().mapToLong(leaf -> leaf.getPrice()).sum();
	}
	public void addComponent(Component component){
		getLeafs().add(component);
	}

}
