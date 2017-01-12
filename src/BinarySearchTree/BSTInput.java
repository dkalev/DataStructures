import java.util.Scanner;

public class BSTInput {
	
	public static void startString(Scanner scan){
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		
		while (true) {
			System.out.println("Possible operations: add | delete | search | display | quit");

			String input = scan.next().toLowerCase();
			String element;
			boolean status;
			switch (input) {
			case "add":
				System.out.print("Add element to the BST: ");
					element = scan.next();
					status = bst.add(element);
					if(status == true){
						System.out.println(element+" was added to the BST");
					}else{
						System.out.println(element+" was not added to the BST");
					}
				break;
			case "delete":
				System.out.print("Remove element from the BST: ");
					element = scan.next();
					status = bst.remove(element);
					if(status == true){
						System.out.println(element+" was removed from the BST");
					}else{
						System.out.println("The value: "+element+" was not found in the BST");
					}
				break;
			case "search":
				System.out.print("Search for element in the BST: ");
					element = scan.next();
					status = bst.search(element);
					if(status == true){
						System.out.println(element+" is in the BST");
					}else{
						System.out.println(element+" is not in the BST");
					}
				break;
			case "display":
				if(bst.isEmpty()){
					System.out.println("The BST is empty; nothing to display");
				}else{
					bst.displayValues();
					System.out.println();
				}
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
	
	public static void startInt(Scanner scan){
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		while (true) {
			System.out.println("Possible operations: add | delete | search | display | quit");

			String input = scan.next().toLowerCase();
			switch (input) {
			case "add":
				System.out.print("Add element to the BST: ");
				if(scan.hasNextInt()){
					int element = scan.nextInt();
					bst.add(element);
					System.out.println(element+" was added to the BST");
				}else{
					System.out.println("The element must be of type int");
					scan.next();	//consumes the \n character
				}
				break;
			case "delete":
				System.out.print("Remove element from the BST: ");
				if(scan.hasNextInt()){
					int element = scan.nextInt();
					boolean status = bst.remove(element);
					if(status == true){
						System.out.println(element+" was removed from the BST");
					}else{
						System.out.println("The value: "+element+" was not found in the BST");
					}
				}else{
					System.out.println("The element must be of type int");
					scan.next();	//consumes the \n character
				}
				break;
			case "search":
				System.out.print("Search for element in the BST: ");
				if(scan.hasNextInt()){
					int element = scan.nextInt();
					boolean status = bst.search(element);
					if(status == true){
						System.out.println(element+" is in the BST");
					}else{
						System.out.println(element+" is not in the BST");
					}
				}else{
					System.out.println("The element must be of type int");
					scan.next();	//consumes the \n character
				}
				break;
			case "display":
				if(bst.isEmpty()){
					System.out.println("The BST is empty; nothing to display");
				}else{
					bst.displayValues();
					System.out.println();
				}
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
