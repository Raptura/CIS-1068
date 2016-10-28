import java.util.Scanner;

public class ProfanityFilter {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//Boolean to check if profane or not
		boolean isProfane = false;
		
		System.out.print("Please input a sentence");
		String text = sc.nextLine();
		String[] words = text.split(" "); //each word in an array: delimit by spaces
		
		//Check each of the words to make sure its not profane
		for(int i = 0; i < words.length; i++){
			//Check words individually, ignore case.
			if(words[i].equalsIgnoreCase("cat") ||
				(words[i].equalsIgnoreCase("dog")) ||
				(words[i].equalsIgnoreCase("llama"))){
				isProfane = true;
			}
		}
		
		//Output
		if(isProfane){
			System.out.print("Your sentence was rejected for profanity!");
		}else{
			System.out.print("Your sentence:" +text);
		}
		
		
	}
}
