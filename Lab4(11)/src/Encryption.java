import java.util.Scanner;

public class Encryption {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the message to decode");
		String input = sc.nextLine(); //:mmZ\dxZmx]Zpgy --> Attack at dawn for key = 7

		for(int i = 1; i <= 100; i++){
			System.out.println("Key = " +i +" is  " +decrypt(input, i));
		}	
	}

	public static String decrypt(String s, int key){
		String newString = "";

		for(int i = 0; i < s.length(); i++){
			int newC;

			//The character as an integer
			if((int)s.charAt(i) + key > 126)
				newC = 32 + ((int)s.charAt(i) + key - 127);
			else
				newC = (int)s.charAt(i) + key;

			//remake the character
			char c = (char)newC;

			//add it to the string
			newString += c;
		}
		return newString;
	}

}
