package com.java.core.designpatterns;


class FactoryDesignPattern {

	public static void main(String[] args) {
		Service factory = getFactory("Qa");
		factory.execute();
	}
	
	public static Service getFactory(String input){
		return input.equals("Qa")?new QaTest():new DeveloperTest();
	}

}




interface Service{
	void execute();
}

class DeveloperTest implements Service{
	@Override
	public void execute() {
		System.out.println("developer");
		
	}
	
}

class QaTest implements Service{
	@Override
	public void execute() {
		System.out.println("QA");
		
	}
}