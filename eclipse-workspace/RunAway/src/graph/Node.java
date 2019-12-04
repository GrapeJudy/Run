package graph;

import java.util.*;

public class Node {
	public int val;
	public Node next;
	public Node random;
	public List<Node> neighbours;
	
	public Node(int val) {
		this.val = val;
	}
	
	public Node(int val, Node next, Node random) {
		this.val = val;
		this.next = next;
		this.random = random;
	}
}
