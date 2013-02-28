package com.interview.lectures.stack;

public class TestStack {

	public static void testCase(Stack<String> stack){
		StringBuilder builder = new StringBuilder();
		String commandStr = "to be or not to - be - - that - - - is";
		String[] commands = commandStr.split(" ");
		for(String command: commands){
			if(!command.equals("-")){
				stack.push(command);
				System.out.println("Push item " + command + ", Stack size is " + stack.size());
			} else {
				String item = stack.pop();
				builder.append(item + " ");
				System.out.println("Pop item " + item + ", Stack size is " + stack.size());
			}
		}
		System.out.println(builder.toString());
	}
	public static void main(String[] args) {
		System.out.println("--------------Test Linked Stack-----------------");
		Stack<String> stack = new FixCapabilityArrayStack<String>(10);
		testCase(stack);
	}

}
