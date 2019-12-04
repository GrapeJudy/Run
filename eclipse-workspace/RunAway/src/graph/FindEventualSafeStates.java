package graph;

import java.util.*;

public class FindEventualSafeStates {
	// maybe use a map to store the node that eventually will ended up ..
	// so if any node's children contains such node just don't bother.
	// very similar to the course schedule problem
	// Leetcode is so dump... only takes ordered answers
	public static List<Integer> eventualSafeNodes(int[][] graph) {
		int[] nodeDeps = new int[graph.length];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < graph.length; i++) {
			if (graph[i] == null || graph[i].length == 0) {
				queue.offer(i);
			} else {
				nodeDeps[i] = graph[i].length;
			}
		}
		
		List<Integer> res = new ArrayList<Integer>();
		// duplicates.
		while(!queue.isEmpty()) {
			int top = queue.poll();
			res.add(top);
			
			for(int i = 0; i < graph.length; i++) {
				for(int j : graph[i]) {
					if (top == j) {
						nodeDeps[i]--;
						if(nodeDeps[i] == 0) {
							queue.add(i);
						}
					}
				}
			}
		}
		
		return res;
	}
	
	public static List<Integer> eventualSafeNodesII(int[][] G) {
		int N = G.length;
		boolean[] safe = new boolean[N];
		
		List<Set<Integer>> graph = new ArrayList<>();
		List<Set<Integer>> rgraph = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < N; i++) {
			graph.add(new HashSet());
			rgraph.add(new HashSet());
		}
		
		for(int i = 0; i < N; i++) {
			if(G[i].length == 0) {
				queue.offer(i);
			}
			for(int j : G[i]) {
				graph.get(i).add(j);
				rgraph.get(j).add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int j = queue.poll();
			safe[j] = true;
			for(int i : rgraph.get(j)) {
				graph.get(i).remove(j);
				if (graph.get(i).isEmpty()) {
					queue.offer(i);
				}
			}
		}
		
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			if(safe[i]) {
				res.add(i);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] graph = {
				{1, 2},
				{2, 3},
				{5},
				{0},
				{5},
				{},
				{}};
		List<Integer> res = eventualSafeNodes(graph);
		System.out.println(res.size());
		for(int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}
}
