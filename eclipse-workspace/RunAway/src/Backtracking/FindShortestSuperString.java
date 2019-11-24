package Backtracking;

import java.util.Arrays;

/*
 * I really like this problem I havea  feeling for this problem. 
 * 
 */
public class FindShortestSuperString {
	public static int bestLength = Integer.MAX_VALUE;
	public static int[] bestPath;
	public static int[][] cost;
	public static String shortestSuperstring(String[] A) {
		helper(A);
		StringBuilder sb = new StringBuilder();
		sb.append(A[bestPath[0]]);
		for(int i = 1; i < bestPath.length; i++) {
			int indexX = bestPath[i - 1];
			int indexY = bestPath[i];
			
			sb.append(A[indexY].substring(A[indexY].length() - cost[indexX][indexY]));
		}
        return sb.toString();
    }
	
	public static void helper(String[] A) {
		int n = A.length;
		computeCostMatrxi(A);
		boolean[] used = new boolean[n];
		int[] currentPath = new int[n];
		searchPath(A, currentPath, used, 0, 0);
	}
	
	public static void searchPath(
			String[] A, 
			int[] currentPath,
			boolean[] used, 
			int currentLength,
			int index) {
		if (index > A.length) {
			return;
		}
		
		if (currentLength > bestLength) {
			return;
		}
			
		if (index == A.length) {
			if (bestLength > currentLength) {
				bestLength = currentLength;
				bestPath = Arrays.copyOf(currentPath, A.length);
				return;
			}
		}
		
		for(int i = 0; i < A.length; i++) {
			if (used[i]) continue;
			currentPath[index] = i;
			used[i] = true;
			searchPath(
					A,
					currentPath,
					used,
					index == 0? A[i].length(): currentLength + cost[currentPath[index-1]][i],
							index + 1);
			used[i] = false;						
		}
	}
	
	public static void computeCostMatrxi(String[] A) {
		int n = A.length;
		cost = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				cost[i][j] = A[j].length();
				for(int k = 1; k <= Math.min(A[i].length(), A[j].length()); k++) {
					if (A[j].substring(0, k).equals(A[i].substring(A[i].length() - k))) {
						cost[i][j] = cost[i][j] - k;
					}
				}
			}
		}
	}
	
	public static void dpSolution(String[] A) {
		int n = A.length;
		computeCostMatrxi(A);
		
		int[][] dp = new int[1<<n][n];
		int[][] parents = new int[1<<n][n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Arrays.fill(parents, -1);
		
		
		for(int i = 0; i < n; i++) {
			dp[1<<i][i] = A[i].length();
		}
		
		for(int i = 1; i < (1<<n); i++) {
			// for each of the end node j, find parent.
			for(int j = 0; j < n; j++) {
				int parent = i ^ (1<<j);
			}
		}
	}
	
	public static void main(String[] args) {
		String[] A = {"catg","ctaagt","gcta","ttca","atgcatc"};
		String[] B = {"alex","loves","leetcode"};
		String[] C = {"ab", "ba"};
		String res = shortestSuperstring(C);
		
		System.out.println(17 ^ (1<<3));
		System.out.println(17 & (~(1<<3)));
	}
}
