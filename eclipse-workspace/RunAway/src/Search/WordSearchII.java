package Search;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/*
 * https://leetcode.com/articles/word-search-ii/
 * 
 * The backbone is hard to think about, basically constructing a Trie tree with the words
 * (instead of constructing a mess tree with all the characters from the entire board..
 * 
 * The implementation is fairly straight forward then.. And I can make it by myself.
 */
public class WordSearchII {
	
	public static class TrieNode {
		HashMap<Character, TrieNode> childern = new HashMap<Character, TrieNode>();
		String word;
		boolean hasValue;
		public TrieNode() {}
	}
	
	public static TrieNode constructTrieNode(String[] words) {
		TrieNode root = new TrieNode();
		TrieNode curr;
		for(String word: words) {
			curr = root;
			for(int i = 0; i < word.length(); i++) {
				char tmp = word.charAt(i);
				if (!curr.childern.containsKey(tmp)) {
					curr.childern.put(tmp, new TrieNode());
				}
				curr = curr.childern.get(tmp);
			}
			curr.word = word;
			// this is good move I like it.
			curr.hasValue = true;
		}
		return root;
	}
	
	public static void findWordsHelper(
			List<String> res, TrieNode root, char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return;
		}
		
		char letter = board[i][j];
		board[i][j] = '#';

		if (root.hasValue) {
			res.add(root.word);
			root.word = null;
			// this is to avoid the duplicates!
			root.hasValue = false;
//			return; no no no no return we still want to explore..
		}
		if (i - 1 >= 0 && root.childern.containsKey(board[i-1][j])) {
			findWordsHelper(res, root.childern.get(board[i-1][j]), board, i-1,j);
		}
		if (i + 1 < board.length && root.childern.containsKey(board[i+1][j])) {
			findWordsHelper(res, root.childern.get(board[i+1][j]), board, i+1,j);
		}
		if (j + 1 < board[0].length && root.childern.containsKey(board[i][j+1])) {
			findWordsHelper(res, root.childern.get(board[i][j+1]), board, i, j + 1);
		}
		if (j - 1 >= 0 && root.childern.containsKey(board[i][j-1])) {
			findWordsHelper(res, root.childern.get(board[i][j-1]), board, i, j -1);
		}
		board[i][j] = letter;
	}
	
	public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(board == null || board.length == 0 || words.length == 0) {
        	return res;
        }
        
        TrieNode root = constructTrieNode(words);
        int m = board.length, n = board[0].length;
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if (root.childern.containsKey(board[i][j])){
        			findWordsHelper(res, root.childern.get(board[i][j]), board, i, j);
        		}
        	}
        }
        return res;
    }
	

	public static void main(String[] args) {
//		char[][] board = {
//				{'o', 'a', 'a', 'n'},
//				{'e', 't', 'a', 'e'},
//				{'i', 'h', 'k', 'r'},
//				{'i', 'f', 'l', 'v'}
//		};
//		String[] words = {"oath", "pea", "eat", "rain"};
		char[][] board = {{'a', 'a'}};
		String[] words = {"a"};
		List<String> res = findWords(board, words);
		System.out.println(res.size());
//		for(String s : res) {
//			System.out.println(s);
//		}
	}
	/*
	 * This is just word searchI
	 */
//	public static boolean callCase(char[][] board, String word) {
//		for(int i = 0; i < board.length; i++) {
//			for(int j = 0; j < board[0].length; j++) {
//				if (findWord(word, board, i, j, 0)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//	public static boolean findWord(
//			String word, char[][] board, int i, int j, int k) {
//		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
//			return false;
//		}
//		
//		if (k == word.length() - 1) {
//			return true;
//		}
//		
//		if (board[i][j] == '#') {
//			return false;
//		}
//		
//		if (board[i][j] == word.charAt(k)) {
//			char tmp = board[i][j];
//			board[i][j] = '#';
//			boolean foundWord = findWord(word, board, i-1, j, k+1) ||
//					findWord(word, board, i + 1, j, k + 1) ||
//					findWord(word, board, i, j - 1, k+ 1) ||
//					findWord(word, board, i, j + 1, k + 1);
//			board[i][j] = tmp;
//			return foundWord;
//		}
//		return false;
//	}
}
