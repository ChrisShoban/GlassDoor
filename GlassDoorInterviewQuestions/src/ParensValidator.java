
public class ParensValidator {
	public boolean isValid(String parens) {
		StringBuffer stack = new StringBuffer();
		int topOfStack = -1; // top of an empty stack is -1, first item is in 0 location
		
    	// int a = (b) ? c : d;
		for(Character c : parens.toCharArray()) {
	        switch (c) {
	            case '[': 
	            	stack.append(c);
	            	topOfStack++;
	            	break;
	            case ']': 
	            	if(stack.charAt(topOfStack) != '[') return false;
	            	stack.deleteCharAt(topOfStack);
	            	topOfStack--;
	            	break;
	            case '<':  
	            	stack.append(c);
	            	topOfStack++;
	            	break;
	            case '>':  
	            	if(stack.charAt(topOfStack) != '<') return false;
	            	stack.deleteCharAt(topOfStack);
	            	topOfStack--;
	            	break;	
	            case '{':  
	            	stack.append(c);
	            	topOfStack++;
	            	break; 
	            case '}':  
	            	if(stack.charAt(topOfStack) != '{') return false;
	            	stack.deleteCharAt(topOfStack);
	            	topOfStack--;
	            	break;
	            case '(': 
	            	stack.append(c);
	            	topOfStack++;
	            	break;
	            case ')':  
	            	if(stack.charAt(topOfStack) != '(') return false;
	            	stack.deleteCharAt(topOfStack);
	            	topOfStack--;
	            	break;
	            default: return false;
	        }
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
