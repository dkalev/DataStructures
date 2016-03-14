import java.util.Arrays;

public class Sorts {

	
	
	public static void bubbleSort(int[] array){
		
		boolean flag = true;
		//loop until no swaps occur => the array is sorted
		while(flag){
			flag = false;
			for (int i = 0; i < array.length - 1; i++){
				
				//check if two adjacent elements are sorted
				if (array[i] > array[i+1]){
					
					//swap values
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					flag = true; //if a swap has occurred loop through the array again
				}
				
			}
		}
		
		
	}

	public static void selectionSort(int[] array){
		
		int tmp;
		//compare every element to the rest
		for (int i = 0; i < array.length-1; i++){
			int min = i;
			
			for (int j = i+1; j < array.length; j++){
				
				if (array[min] > array[j] ) min = j;//if an element with smaller value exists, 
													//put its index in min.
				
			}
			//swap the values 
			tmp = array[i];
			array[i] = array[min];
			array[min] = tmp;
		}
		
		
	}
	
	public static void insertionSort(int[] array){
		
		for (int i = 1; i < array.length; i++){
			
			int temp = array[i];
			int j = i;
			
			//loop until you reach the beginning of the array or you reach an element with smaller value
			while (j > 0 && array[j-1] > temp){
				
				array[j] = array[j-1];//shift every element larger than temp one position to the right
				j--;
				
			}
			array[j] = temp;//put temp in the opened position
		}
			
						
	}
	
	public static void quickSort(int[] array, int left, int right){
		
		int i = left;
		int j = right;
		int pivot = array[(left+right)/2];
		//partition part
		while(i <= j){
			while (array[i] < pivot) i++;//looking for a value larger than the pivot on the left
			while (array[j] > pivot) j--;//looking for a value smaller than the pivot on the right
			//if such values exist swap them
			if (i <= j){
				
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				
				i++;
				j--;
			} 
		}
		//recursion part
		if (left < j) quickSort(array, left, j);
		if (i < right) quickSort(array, i, right);
		
	}
	
	public static int[] mergeSort(int[] array){
		int size = array.length;
		if (size <= 1) return array;	//base case for the recursion
		
		//split the array into two smaller arrays
		int[] firstHalf = new int[size/2];
		int[] secondHalf = new int[size - size/2];
		System.arraycopy(array, 0, firstHalf, 0, firstHalf.length);
		System.arraycopy(array, size/2, secondHalf, 0, secondHalf.length);
		
		//sort the arrays
		mergeSort(firstHalf);
		mergeSort(secondHalf);
		
		//merge them together(using helper function)
		merge(firstHalf, secondHalf, array);
		return array;
	}
	
	//helper method for mergeSort
	private static void merge(int[] first, int[] second, int[] result) {
		
		int iFirst = 0;
		int iSecond = 0;
		int iResult = 0;
		
		//loop until one of the arrays reaches its end
		while (iFirst < first.length && iSecond < second.length){
			
			//compare elements in the arrays and move the smaller one in result
			if (first[iFirst] < second[iSecond]){
				result[iResult] = first[iFirst];
				iFirst++;
			}else{
				result[iResult] = second[iSecond];
				iSecond++;
			}
			iResult++;	//increment the index of result after each added eleent
		}
		
		// copy the remaining part of the arrays in result
		System.arraycopy(first, iFirst, result, iResult, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iResult, second.length - iSecond);
	}

	private static void printArray(int[] array){
		
		
		System.out.println(Arrays.toString(array).replace(", ", "|"));
		System.out.println("\n");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {5,7,14,21,3,2,9,17,5,4};
		System.out.println("The array at the beginning");
		printArray(array);
		
		System.out.println("Bubble sort");
		bubbleSort(array);
		printArray(array);
		array = new int[]{5,7,14,21,3,2,9,17,5,4};
		
		System.out.println("Selection sort");//
		selectionSort(array);
		printArray(array);
		array = new int[]{5,7,14,21,3,2,9,17,5,4};
		
		System.out.println("Insertion sort");
		insertionSort(array);
		printArray(array);
		array = new int[]{5,7,14,21,3,2,9,17,5,4};
		
		System.out.println("Quick sort");
		quickSort(array,0 , array.length-1);
		printArray(array);
		array = new int[]{5,7,14,21,3,2,9,17,5,4};
		
				
		int[] array1 = mergeSort(array);
		System.out.println("Merge sort");
		printArray(array1);

	}

}
