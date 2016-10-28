public class TestArrayClass {

	public static void main(String[] args){

		//int[] intArray = new int[10];

		int[] intArray = new int[]{1,2,3,4,5,6,7,8,9,10};

		intArray[0] = 1;
		intArray[1] = 5;
		intArray[2] = 7;

		for(int i = 0; i < intArray.length; i++){
			intArray[i] = i;
		}


	}

	public static int[] squareThhree(int num1, int num2, int num3){
		int[] squares = new int[3];

		squares[0] = num1 * num1;
		squares[1] = num2 * num2;
		squares[2] = num3 * num3;

		return squares;
	}

	public static void bubbleSort(int[] inputArray){
		boolean swapped = true;
		int temp;
		while (swapped){
			swapped = false;
			for(int i = 0; i < inputArray.length - 1; i++){
				if(inputArray[i] > inputArray[i + 1]){
					temp = inputArray[i];
					inputArray[i] = inputArray[i+1];
					inputArray[i + 1] = temp;
					swapped = true;
				}
			}
		}
	}

	public static void selectionSort(int[] inputArray){
		for(int i = 0; i < inputArray.length - 1; i++){
			int pos = 0; //the position to swap to, always start at index 0
			for(int j = i + 1; j < inputArray.length; j++){
				if(inputArray[j] < inputArray[i]){
					pos = j;
				}
			}
			int temp = inputArray[pos];
			inputArray[pos] = inputArray[i];
			inputArray[i] = temp;
		}
	}

}
