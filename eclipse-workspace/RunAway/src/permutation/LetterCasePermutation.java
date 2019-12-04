package permutation;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<String>();
        if (S == null || S.length() == 0) {
        	return res;
        }
        char[] charArr = new char[S.length()];
        generateLetters(S, res, charArr, 0);
        return res;
    }
	
	public static void generateLetters(
			String s, List<String> res, char[] charArr, int index) {
		// so this modifies each character one time..
		// doesn't really need to iterate
		if (index == s.length()) {
			res.add(String.copyValueOf(charArr));
			return;
		}
		
		if (Character.isLetter(s.charAt(index))) {
			// so make it one for each time
			charArr[index] = Character.toLowerCase(s.charAt(index));
			generateLetters(s, res, charArr, index+1);
			charArr[index] = Character.toUpperCase(s.charAt(index));
			generateLetters(s, res, charArr, index+1);
		}
		else {
			charArr[index] = s.charAt(index);
			generateLetters(s, res, charArr, index+1);
		}
	}
	
	public static void main(String[] args) {
		String S = "a1b2";
		List<String> res = letterCasePermutation(S);
		System.out.println(res.size());
		for(int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
