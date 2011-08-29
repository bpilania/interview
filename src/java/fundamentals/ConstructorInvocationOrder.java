package java.fundamentals;

class Parent {
	public Parent(){
		System.out.println("Parent is initialized");
	}
}

class Child extends Parent {
	public Child() {
		System.out.println("Child is initialized");
	}
}

public class ConstructorInvocationOrder {

	public static void main(String[] args) {	
		new Child();
	}

}
