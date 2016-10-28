import java.util.Scanner;

public class PalindromeChecker {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String word;

		do{
			//New input
			System.out.println("INPUT A WORD TO SEE IF IT IS A PALINDROME(quit to quit)");
			word = sc.nextLine();
			word = word.toLowerCase(); //normalize the word to all lower case letters
			word = word.replaceAll("\\s", ""); //get rid of white space
			word = word.replaceAll("\\.", "");
			
			char[] chars = word.toCharArray();
			
			if(word.equalsIgnoreCase("quit")){
				continue;
			}
			
			if(isPalindrome(chars, chars.length - 1)){
				System.out.println("This word is a palindrome");
			}else{
				System.out.println("This word is NOT a palindromes");
			}
			
		}while(!word.equalsIgnoreCase("quit"));

		System.out.println("You have quit");
	}

	public static boolean isPalindrome(char[] a, int used){
		for(int i = 0; i < used; i++){
			if(a[i] != a[used - i]){
				return false;
			}
		}
		return true;
	}
}
