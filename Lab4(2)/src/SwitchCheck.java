import java.util.Scanner;

public class SwitchCheck {
	public static void main(String[] args){
		String input = "";

		while(!input.equalsIgnoreCase("quit")){
			Scanner sc = new Scanner(System.in);
			System.out.println("Please input a string, or type 'quit' to exit");
			input = sc.nextLine();

			if(input.equalsIgnoreCase("quit")){
				continue; //leave the loop
			}

			String switchLetter = letterSwitch(input); //Switch first and last letters
			String backwards = readBackwards(switchLetter); //read it backwards

			//check if true
			if(backwards.equals(input)){
				System.out.println("Letter Switch OKAY");
			}else{
				System.out.println("DOES NOT HOLD TRUE");
			}
		}
	}

	//switch first and last letters
	public static String letterSwitch(String s){
		String newString = "";
		//Switch the letters
		newString += s.substring(1, s.length()); //the middle letters
		newString += s.substring(0,1); //add the first letter to the end of the word

		return newString;
	}

	//read a string backwards
	public static String readBackwards(String s){
		String newString = "";

		for(int i = s.length(); i > 0; i--){
			newString += s.substring(i-1, i);
		}

		return newString;
	}
}