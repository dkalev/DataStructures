import java.util.Scanner;


public class StackApp {
	
	private static StackADT<Character> stack;
	
	public static void main(String[] args) {
		stack = new AdapterStack<Character>();
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.println("Type 'check' to check if parenthesis match or 'quit' to exit");
			String prompt = scan.next().toUpperCase();
			if(prompt.equals("QUIT")) {
				System.out.println("Do you want to quit?(Y/N)");
				String answer = scan.next().toUpperCase();
				if (answer.equals("Y")) {
					scan.close();
					System.exit(0);
				} else if (answer.equals("N")) {
					continue;
				} else {
					System.out.println("Invalid operation");
				}
			}else if(prompt.equals("CHECK")) {
				System.out.println("Enter a string:");
				String text = scan.next();
				if(parenthesisMatch(text)){
					System.out.println("Parenthesis match");
				}else{
					System.out.println("Parenthesis don't match");
				}
			}else{
				System.out.println("Invalid operation");
			}
		}
		
		
		
	}
	private static boolean parenthesisMatch(String text){
		for(int i = 0; i < text.length(); i++){
			char current = text.charAt(i);
			//push opening brackets to the stack
			if(current == '(' || current == '[' || current == '{' ){
				stack.push(text.charAt(i));
			//for every closing bracket check if the type is the same as the last bracket pushed	
			}else if(current == ')' || current == ']' || current == '}'){
				if(stack.isEmpty()){
					return false;
				} 
				char prev = stack.top();
	            if (current == '}' && prev == '{' || current == ')' && prev == '(' || current == ']' && prev == '[')
	                stack.pop();
	            else 
	                return false;
			}
		}
			
		if(stack.isEmpty()){
			return true;
		}else{
			while(!stack.isEmpty()) stack.pop();
			return false;
		}
	}

}
