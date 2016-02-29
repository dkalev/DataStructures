
public class Search {
	
	private int size;
	private int[] array;
	
	Search(int[] array){
		
		this.array = array;
		size = array.length;
		
	}
	
	public int linearSearch(int key){
		
		for (int i = 0; i< array.length; i++){
			
			if (key == array[i]) return i;
			
		}
		
		return -1;
	}
	
	public int binarySearch(int key){
		
		int low = 0;
		int high = size;
		int mid = low + (high - low)/2;
		
		while (array[mid] != key){
			
			if (high < low){
				
				return -1;
				
			}else if (array[mid] < key){
				
				low = mid + 1;
				mid = low + (high - low)/2;
				
			}else{
				
				high = mid - 1;
				mid =low + (high - low)/2;
				
			}
			
		}
		
		return mid;
	}
	
	public int recursiveBinarySearch(int low, int high, int key){
		
		int mid = low + (high - low)/2;
		
		if (low > high) return -1;		//base case
		
		if (array[mid] == key){
			
			return mid;
			
		}else if (array[mid] < key){
			
			return recursiveBinarySearch(mid + 1, high, key);	//low = mid + 1
			
		}else{
			
			return recursiveBinarySearch(low, mid - 1, key);	//high = mid - 1
			
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {5,10,25,35,400,500,605,755,855,9555};	
		
		Search sch = new Search(ar);
		System.out.println(sch.binarySearch(605));
		System.out.println(sch.linearSearch(500));
		System.out.println(sch.recursiveBinarySearch(0, 10, 755));
	}

}
