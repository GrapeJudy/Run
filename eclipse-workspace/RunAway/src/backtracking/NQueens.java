package backtracking;

import java.util.*;

/*
 * I can think of the solution by myself though
 */
public class NQueens {
	public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n <= 0) {
        	return res;
        }
        
        List<String> list = new ArrayList<String>();
        placeCell(n, res, list, 0);
        return res;
    }
	
	public static void placeCell(
			int n, 
			List<List<String>> res,
			List<String> list,
			// level is the col
			int level) {
		if (level == n) {
			List<String> copy = new ArrayList<String>(list);
			res.add(copy);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!isValid(level, i, list)) {
				continue;
			}
			
			char[] arr = new char[n];
			Arrays.fill(arr, '.');
			arr[i] = 'Q';
			list.add(arr.toString());
			placeCell(n, res, list, level + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public static boolean isValid(
			int row, int col, List<String> list) {
		for(int i = 0; i < row; i++) {
			int currentQIndex = list.get(i).indexOf('Q');
			// no vertical
			if (currentQIndex == col) {
				return false;
			}
			// horizonal not possible
			// no diagnal
			int rowDistance = Math.abs(row - i);
			int colDistance = Math.abs(currentQIndex - col);
			if (rowDistance == colDistance) {
				return false;
			}
		}
		
		return true;
	}
}
