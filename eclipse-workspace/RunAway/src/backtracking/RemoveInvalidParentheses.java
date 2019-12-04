package backtracking;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/*
 * A lot of the hints from the original solution
 */
public class RemoveInvalidParentheses {
	// can also use an array int[] minimumCount = new int[0]
 	static private int mimimumRemoveCount = Integer.MAX_VALUE;
	public static List<String> removeInvalidParentheses(String s) {
		Set<String> res = new HashSet<String>();
		if (s == null || s.length() == 0) {
			return new ArrayList(res);
		}
		StringBuilder sb = new StringBuilder();
		removeHelper(res, sb, s, 0, 0, 0, 0);
		return new ArrayList<String>(res);
    }
	
	public static void removeHelper(
			Set<String> list,
			StringBuilder sb,
			String s,
			int left, 
			int right,
			int index,
			int removeDepth) {
		if (index == s.length()) {
			System.out.println("index euqls");
			// but how to compare the level of valid parentheses
			// where to validate the correct parenthesis
			if (left == right) {
				System.out.println(sb.toString() + " " + removeDepth);
				if (removeDepth <= mimimumRemoveCount) {
					String possibleExpression = sb.toString();
					if (removeDepth < mimimumRemoveCount) {
						mimimumRemoveCount = removeDepth;
						list.clear();
					}
					list.add(possibleExpression);
				}
			}
			return;
		}
		
		char currentChar = s.charAt(index);
		if (currentChar != '(' && currentChar != ')') {
			sb.append(currentChar);
			removeHelper(list, sb, s, left, right, index + 1, removeDepth);
			sb.deleteCharAt(sb.length() - 1);
		} else {
			// do nothing just throw away the case
			System.out.println("why " + removeDepth + " " + currentChar);
			removeHelper(list, sb, s, left, right, index+1, removeDepth + 1);
			if (currentChar == '(') {
				sb.append(currentChar);
				removeHelper(list, sb, s, left+1, right, index+1, removeDepth);
				sb.deleteCharAt(sb.length() - 1);
			} else if (right < left) {
				sb.append(currentChar);
				removeHelper(list, sb, s, left, right + 1, index + 1, removeDepth);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "()";
		List<String> res = removeInvalidParentheses(s);
		System.out.println(res.size());
		for(String subStr : res) {
			System.out.println(subStr);
		}
	}
}
