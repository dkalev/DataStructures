public class Sort {
	

	public static void quickSort(int[] array){
		
		int left = 0;
		int right = array.length - 1;
		quickSort(array, left, right);
		
	}
	
	private static void quickSort(int[] array, int left, int right){
		
		if(array.length <= 5){
			insertionSort(array);			
		}else{		
			if(left < right){
				int pivot = partition(array, left, right);
			
				quickSort(array, left, pivot - 1);
				quickSort(array, pivot + 1, right);
			}
		}		
	}
	
	private static int partition(int[] array, int left, int right){
		
		int i = left;
		int j = right;
		int pivot = median(array[left], array[(left+right)/2], array[right]);
		
		while(i < j){
			while(array[i] <= pivot && i < j) i++;
			while(array[j] >= pivot && j > i) j--;
			
			if(i < j){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		array[right] = array[j];
		array[j] = pivot;
		return j;
	}
	
	private static int median(int left, int middle, int right){
		
		if (left > middle) {
			  if (middle > right) {
				  return middle;
			  } else if (left > right) {
				  return right;
			  } else {
				  return left;
			  }
		} else {
			  if (left > right) {
				  return left;
			  } else if(middle > right) {
				  return right;
			  } else {
				  return middle;
			  }
		}
	}
	private static void insertionSort(int[] array){
		
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
}
