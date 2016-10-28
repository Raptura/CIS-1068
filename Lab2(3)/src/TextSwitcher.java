import java.util.Scanner;

public class TextSwitcher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String text, firstWord, lastWord, output;

		System.out.println("Input a string of text: ");
		text = sc.nextLine();

		String[] words = text.split(" ");

		firstWord = words[0];	 //first index of the splitted array (delimited by space) -- first word
		lastWord = words[words.length - 1]; //last index of the splitted array (delim by space) -- last word

		//Switch the first and last words
		output = lastWord;
		for(int i = 1; i < words.length - 1; i++){
			//populate the rest of the string
			output += " " +words[i];
		}
		//dont forget to add the last word
		output += " " +firstWord;

		//Output to the console
		System.out.println("I have changed the string to this: " + output);

	}

}
