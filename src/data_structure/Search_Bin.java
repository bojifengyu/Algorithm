package data_structure;

public class Search_Bin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(Seach_bin(arr, 5));
	}

	public static int Seach_bin(int arr[], int key){
		int low = 0, high = arr.length - 1, mid = 0;
		while(low <= high){
			mid = low + high;
			if(arr[mid] == key){
				return mid;
			}
			else if(arr[mid] > key){
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}
		}
		return -1;
	}
}
