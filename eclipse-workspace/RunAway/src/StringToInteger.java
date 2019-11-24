
public class StringToInteger {
	public static int stringToInteger(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		
		// This is the most important part, only the trim space
		str = str.trim();
		int sign = 1;
		int index = 0;
		double runningSum = 0.0;

		if(index < str.length() && str.charAt(index) == '+') {
			index++;
		}
		
		// also need to verify the else if for operator of "+" and "-"
		else if(index < str.length() && str.charAt(index) == '-') {
			index++;
			sign = -1;
		}
		
		if (index < str.length() && (str.charAt(index) < '0' || str.charAt(index) > '9')) {
			return 0;
		}
		
		for(int i = index; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				runningSum = runningSum * 10 + (c - '0');
			} else {
				break;
			}
		}
		runningSum = runningSum * sign;
		if (runningSum > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		
		if (runningSum < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int)runningSum;
	}
	
	public static void main(String args[]) {
//		System.out.println(stringToInteger("4193 with words")); 
//		System.out.println(stringToInteger("words and 9876"));
//		System.out.println(stringToInteger("s- 4 3 word"));
//		System.out.println(stringToInteger("91283472332")); 
		System.out.println(stringToInteger(" +0 123"));
	}
}
