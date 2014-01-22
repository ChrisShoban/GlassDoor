
public class ParensValidator {
	public boolean isValid(String parens) {
		StringBuffer stack = new StringBuffer();
		int topOfStack = -1; 
		String opens = "[<{(";
		for(Character c : parens.toCharArray()) {
			if(opens.indexOf(c) >= 0) {
				stack.append(c);
            	topOfStack++;
			}
			// c - 2 or c - 1 will get opposite of current c
			// http://www.asciitable.com/
			else if(c - 2 == stack.charAt(topOfStack) || c - 1 == stack.charAt(topOfStack)) {
				stack.deleteCharAt(topOfStack);
				topOfStack--;
			}
			else {
				return false;
			}
		}
		if(stack.length() > 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String test1 = "(){}[]<>{(<[]>)}";
		String test2 = "({[<]>})";
		String test3 = "()()(((())))";
		String test4 = "[[[]]()()(){()[{}]{{<>}<><><>}}]";
		ParensValidator tester = new ParensValidator();
		System.out.println(tester.isValid(test1));
		System.out.println(tester.isValid(test2));
		System.out.println(tester.isValid(test3));
		System.out.println(tester.isValid(test4));
	}
}
