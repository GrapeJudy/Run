package graph;

import java.util.*;

public class CopyListRandomPointer {
	public static Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		
		Node p = head;
		// first needle the copy list in
		while(p != null) {
			Node copy = new Node(p.val);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
		
		p = head;
		while(p != null) {
			if (p.random != null) {
				// this because each node has a copied version now.
				p.next.random = p.random.next;
			}
			p = p.next.next;
		}
		
		p = head;
		Node newHead = head.next;
		
		while(p != null) {
			Node temp = p.next;
			p.next = temp.next;
			if (temp.next != null) {
				temp.next = temp.next.next;
			}
			p = p.next;
		}
		return newHead; 
    }
	
	// this uses a hashMap to map the original and 
	// copied node together.
	public static Node copyRandomListII(Node head) {
		if (head == null) {
			return null;
		}
		
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node newHead = new Node(head.val);
		// What I thought was correct.. about how to put the node into
		// the dictionary, but I forget to have pointers to point to
		// both the heads. 
		Node p = head;
		Node q= newHead;
		
		map.put(p, newHead);
		p = p.next;
		
		while(p != null) {
			Node tmp = new Node(p.val);
			map.put(p, tmp);
			q.next = tmp;
			q = q.next;
			p = p.next;
		}
		
		p = head;
		q = newHead;
		
		while(p != null) {
			if (p.random != null) {
				q.random = map.get(p.random);
			} else {
				q.random = null;
			}
			p = p.next;
			q = q.next;
		}
		return newHead;
	}
}
