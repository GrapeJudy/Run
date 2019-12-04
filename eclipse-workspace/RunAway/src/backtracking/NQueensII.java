package backtracking;

/*
 * have the idea of prune along the way
 * but I dont have a better to solve this.
 * 
 * Its tricky part is the (row - col + 2n) and the (row + col) part. 
 */
public class NQueensII {
	static int count = 0;
	public int totalNQueens(int n) {
		if (n <= 3) {
			return 0;
		}
		
		boolean[] col = new boolean[n];
		boolean[] diag1 = new boolean[2*n];
		boolean[] diag2 = new boolean[2*n];
		
		countQueue(n, 0, col, diag1, diag2);
		return count;
    }
	
	// so the essense is to expend one diagno (below) at a time
	// it's actually just Math.abs(row - col), Math.abs(row + col)
	// but to make it ... more ... 
	public static void countQueue(
			int n, int row, boolean[] col, boolean[] diag1, boolean[] diag2) {
		if (row == n) {
			count++;
		}
		
		for(int c = 0; c < n; c++) {
			int index1 = row - c + n;
			int index2 = row + c;
			if (col[c] || diag1[index1] || diag2[index2]) {
				continue;
			}
			col[c] = true;
			diag1[index1] = true;
			diag2[index2] = true;
			countQueue(n, row+1, col, diag1, diag2);
			col[c] = false;
			diag1[index1] = false;
			diag2[index2] = false;
		}
	}
}
