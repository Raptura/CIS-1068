import java.util.Scanner;

public class Converter {

	public static void main(String[] args){
		//Create the scanner
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input a tempereture in degrees Farenheit: ");
		int tempF = sc.nextInt();
		//If you don't cast tempF to double, you get round off errors
		double tempC = (5 * ((double)tempF - 32)) /9;
		//Use format to bring the decimal 
		System.out.printf(tempF + " degrees Fahrenheit is %.1f degrees Celcius",tempC);
	}
}
