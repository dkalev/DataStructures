
public class Stack {
	
	private int sp;
	private int size;
	private String[] theStack;
	
		//constructor 
	public Stack(int size){
		this.size = size;
		theStack = new String[size];
		sp = -1;
	}
	
		//checks if the stack is empty
	public boolean isEmpty(){
		
		boolean empty = false;
		if (sp == -1) empty = true;
		return empty;
		
	}
	
		//push method-checks if there is space on the stack and adds the entry if yes
	public void push(String newEntry){
		if (sp < size){
			sp++;
			theStack[sp] = newEntry;
		}else{
			System.out.println("Stack overflow");
		}
		
	}
	
		//pop method-pops the last item if the stack is not empty
	public String pop(){
		if (isEmpty()){
			System.out.println("Stack underflow");
			return null;
		}else{
		String last = theStack[sp];
		sp--;
		return last;
		}
	}
		//shows the last entry without popping it
	public String peek(){
		
		String last = theStack[sp];
		
		return last;
	}
	
		//display method(for tests)
	public void display(){
		for (int i = 0; i < size;i++){
			System.out.println(theStack[i]);
			System.out.println("-----------");
		}
		System.out.println("\n");
	}
		
	public static void main(String[] args) {
		Stack stack = new Stack(20);
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("3");
	
		stack.display();
		
		
		stack.pop();
		stack.push("5");
		stack.display();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.push("3");
	    stack.display();
		

	}

}
