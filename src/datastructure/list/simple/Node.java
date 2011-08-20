package datastructure.list.simple;

public class Node {
	private String value;
	private Node nextNode;
	
	public Node(String value, Node nextNode){
		this.value = value;
		this.nextNode = nextNode;
	}
	
	public String getValue() {
		return value;
	}
	
	public Node next(){
		return this.nextNode;
	}
	
	public void setNextNode(Node nextNode){
		this.nextNode = nextNode;
	}
	
}
