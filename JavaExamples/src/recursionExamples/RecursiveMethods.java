package recursionExamples;

public class RecursiveMethods {
	

	//This recursiveProduct intends to follow the constraint, literally, of:
	//"Write a recursive method takes two (non-negative) int parameters and returns their product.
	//But... you may only use +, not * in your code.
	//TODO: Fix this. Currently broken.

	public static int recursiveProduct(int a, int b) {
		int product = 0;
		if(a == b) {
			return a + a;
		}
		if(a > b) {
			product += recursiveProduct(a,b+1);
		}
		product += recursiveProduct(a,0);
		return product;
	}

// A more sensible recursiveProduct method. Commented out while you work on the hard one.
//	public static int recursiveProduct(int a, int b) {
//		if(b == 0) {
//			return 0;
//		}
//		return a + (recursiveProduct(a,b-1));
//	}
	
	
	public static int recursiveLetterCounter(String s, char c) {
		if(s.length() == 0) {
			return 0;
		}

		if(s.charAt(0) == c) {
			return 1 + recursiveLetterCounter(s.substring(1),c);
		} else {
			return 0 + recursiveLetterCounter(s.substring(1),c);
		}
	}
}