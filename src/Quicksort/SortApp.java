import java.util.Arrays;
import java.util.Random;

public class SortApp {
	
	private static int[] array;
	
	public static void main(String[] args) {
		Random ran = new Random();
		array = new int[60];
		for(int i = 0; i < 60; i++){
			array[i] = ran.nextInt(100);
		}
		printArray(array);
		
		Sort.quickSort(array);
		
		printArray(array);
		
	}
	
	private static void printArray(int[] array){
		System.out.println(Arrays.toString(array).replace(", ", "|"));
		//System.out.println("\n");
	}

}
