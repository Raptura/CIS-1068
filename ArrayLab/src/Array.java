
public class Array {

	int[] array;

	public static void main(String[] args){
		int[] a = new int[]{12,23,4,5,6,3,3,2,1};

		Array arrayObj = new Array(a);
		arrayObj.bubbleSort();
		arrayObj.print();
		int val = arrayObj.binarySearch(12);
		System.out.println("12 is found at index:" + val);
	}

	public Array(int[] array){
		this.array = array;
	}

	public void bubbleSort(){
		boolean swapped = true;
		int temp;
		while (swapped){
			swapped = false;
			for(int i = 0; i < array.length - 1; i++){
				if(array[i] > array[i + 1]){
					temp = array[i];
					array[i] = array[i+1];
					array[i + 1] = temp;
					swapped = true;
				}
			}
		}
	}

	public int binarySearch(int query){
		int begin = 0;
		int end = array.length - 1;
		int mid;

		while(begin <= end){

			mid = (int) Math.floor((begin + end) / 2);
			
			if(query == array[mid]){
				return mid;
			}
			
			if(query > array[mid]){
				begin = mid + 1;
			}
			
			if(query < array[mid]){
				end = mid - 1;
			}
		}	
		return -1;
	}

	public void print(){
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
	}

}