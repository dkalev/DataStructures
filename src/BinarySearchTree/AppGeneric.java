import java.util.Scanner;

public class AppGeneric {

	public static void main(String[] args) {
			
		String input;
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.println("Choose type for the BST: int or String");
			input = scan.next();
			if(input.equals("int")){
				BSTInput.startInt(scan);
			}else if(input.toLowerCase().equals("string")){
				BSTInput.startString(scan);
			}
			}while(true);
	}
}
