import java.util.Scanner;

public class ChangeHandler {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		//This can work for pennies too
		System.out.println("Enter the price of an item: (25 cents to dollar in 5 cent increments)");
		int price = sc.nextInt();

		validate(price);

		System.out.println("You bought something for" +price +"cents and you gave me a dollar, so your change is:");
		int change = 100 - price;
		int quarters = 0, dimes = 0, nickels = 0;

		quarters = (int) (change / 25);
		change -= 25 * quarters;

		dimes = (int) (change / 10);
		change -= 10 * dimes;

		nickels = (int) (change / 5);
		change -= 5 * nickels;


		System.out.println(quarters + "Quarters");
		System.out.println(dimes + "Dimes");
		System.out.println(nickels+ "Nickels");

	}

	public static void validate(int input){

		if(input < 25){
			System.out.println("Input is not 25 cents or greater");
			System.exit(0);
		}
		if(input > 100){
			System.out.println("Input is not 1 dollar or less");
			System.exit(1);
		}
		if(input % 5 != 0){
			System.out.println("Input is not a multiple of 5");
			System.exit(2);
		}
	}
}
