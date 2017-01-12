import java.util.Scanner;

public class DequeADTApp {
	
	public static void main(String[] args) {
		
		DequeADT<String> app = null;
		Scanner scan = new Scanner(System.in);
		while(app == null){
			System.out.println("Choose between NodeDeque and ArrayDequeDeque:");
			String input = scan.next().toLowerCase();
			if(input.equals("nodedeque")){
				app = new NodeDeque<String>();
			}else if(input.equals("arraydequedeque")){
				app = new ArrayDequeDeque<String>();
			}
		}
		
		while (true) {
			System.out.println("Possible operations: addFirst | addLast | getFirst | getLast | removeFirst | removeLast | isEmpty | size | quit");

			String input = scan.next().toLowerCase();
			switch (input) {
			case "addfirst":
				System.out.print("Add first element in the deque: ");
				String elementFirst = scan.next();
				app.addFirst(elementFirst);
				System.out.println(elementFirst + " was added to the front of the deque.");
				break;
			case "addlast":
				System.out.print("Add last element in the deque: ");
				String elementLast = scan.next();
				app.addLast(elementLast);
				System.out.println(elementLast + " was added to the end of the deque.");
				break;
			case "removefirst":
				try {
					System.out.println(app.removeFirst()+" was removed from the deque");
				} catch (EmptyDequeException e) {
					System.err.println(e);
				}
				break;
			case "removelast":
				try {
					System.out.println(app.removeLast()+" was removed from the deque");
				} catch (EmptyDequeException e) {
					System.err.println(e);
				}
				break;
			case "getfirst":
				try {
					System.out.println(app.getFirst()+" is the first element of the deque");
				} catch (EmptyDequeException e) {
					System.err.println(e);
				}
				break;
			case "getlast":
				try {
					System.out.println(app.getLast()+" is the last element of the deque");
				} catch (EmptyDequeException e) {
					System.err.println(e);
				}
				break;
			case "isempty":
				if(app.isEmpty()){
					System.out.println("Deque is empty.");
				}else{
					System.out.println("Deque is not empty.");
				}
				break;
			case "size":
				System.out.println("The size of the deque is: " + app.size());
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
