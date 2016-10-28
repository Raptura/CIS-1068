import java.util.Scanner;

public class hatelove {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Please type some text:");
		String text = sc.nextLine();
		//Replace the first hate with love
		String newText = text.replaceFirst("hate", "love");
		System.out.print("I have rephrased that line to say:" + newText);
	}
}
