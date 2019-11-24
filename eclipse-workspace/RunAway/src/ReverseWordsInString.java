
public class ReverseWordsInString {
	// 卧槽这个一下子就过了，我可能真的比四年前要好一些吧
	public static String reverseString(String s) {
		s = s.trim();
		String[] stringArray = s.split("\\s+");
		
		StringBuilder sb = new StringBuilder();
		for(int i = stringArray.length - 1; i >= 0; i--) {
			sb.append(stringArray[i]);
			if (i != 0) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(reverseString("  hello world!  "));
		System.out.println(reverseString("the sky is blue"));
	}
}
