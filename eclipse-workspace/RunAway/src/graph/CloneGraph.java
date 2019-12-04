package graph;

import java.util.*;

public class CloneGraph {
	public static Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		
		queue.add(node);
		map.put(node, new Node(node.val));
		
		while(!queue.isEmpty()) {
			Node top = queue.poll();
			
			Node copyTop = map.get(top);
			if (copyTop.neighbours == null) {
				copyTop.neighbours = new ArrayList<Node>();
			}
			for(Node neighbour: top.neighbours) {
				if (!map.containsKey(neighbour)) {
					map.put(neighbour, new Node(neighbour.val));
					queue.add(neighbour);
				}
				copyTop.neighbours.add(map.get(neighbour));
			}
		}
        return map.get(node);
    }
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		node1.neighbours = new ArrayList<Node>();
		
		Node node2 = new Node(2);
		node2.neighbours = new ArrayList<Node>();
		
		Node node3 = new Node(3);
		node3.neighbours = new ArrayList<Node>();
		
		Node node4 = new Node(4);
		node4.neighbours = new ArrayList<Node>();
		
		node1.neighbours.add(node2);
		node1.neighbours.add(node4);
		
		node2.neighbours.add(node1);
		node2.neighbours.add(node3);
		
		node3.neighbours.add(node2);
		node3.neighbours.add(node4);
		
		node4.neighbours.add(node1);
		node4.neighbours.add(node3);
		
		Node res = cloneGraph(node1);
		
		System.out.println(res.neighbours.get(1).val);
		for(Node nei : res.neighbours.get(1).neighbours) {
			System.out.print(nei.val + " ");
		}
	}
}
