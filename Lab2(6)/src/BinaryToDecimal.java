import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Binary String: ");
		String text = sc.nextLine();
		int answer = 0;
		
		//Binary reads right to left
		for(int i = text.length(); i >= 0; i--)
		{
			//If we have a one for that digit, add 2^(bit), zero is ignored
			if(text.substring(i).startsWith("1")){
				answer += Math.pow(2, text.length() - i - 1);
			}
		}
		//Print the answer
		System.out.println("The answer is: " + answer);
	}
}