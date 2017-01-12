import java.util.Scanner;

public class stackADTApp {
	
	public static void main(String[] args) {
		
		StackADT<String> app = new ArrayStack<String>();
		Scanner scan = new Scanner(System.in);
		
		
		while (true) {
			System.out.println("Possible operations: push | pop | top | isEmpty | size | quit");

			String input = scan.next().toLowerCase();
			switch (input) {
			case "push":
				System.out.print("Push element in the stack: ");
				String element = scan.next();
				try {
					app.push(element);
					System.out.println(element + " was pushed to the stack.");
				} catch (FullStackException e) {
					System.err.println(e);
				}
				break;
			case "pop":
				try {
					System.out.println(app.pop()+" was popped from the stack");
				} catch (EmptyStackException e) {
					System.err.println(e);
				}
				break;
			case "top":
				try {
					System.out.println(app.top()+" is on top of the stack");
				} catch (EmptyStackException e) {
					System.err.println(e);
				}
				break;
			case "isempty":
				System.out.println(app.isEmpty());
				break;
			case "size":
				System.out.println(app.size());
				break;
			case "quit":
				System.out.println("Do you want to quit?(Y/N)");
				String answer = scan.next().toUpperCase();
				if (answer.equals("Y")) {
					scan.close();
					System.exit(0);
				} else if (answer.equals("N")) {
					break;
				} else {
					System.out.println("Invalid operation");
				}
				break;
			default:
				System.out.println("Invalid operation");
				break;
			}
			

		}

	}

}
