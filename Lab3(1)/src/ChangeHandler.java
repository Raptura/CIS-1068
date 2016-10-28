import java.util.Scanner;

public class ChangeHandler {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		//This can work for pennies too
		System.out.println("Enter the price of an item: (25 cents to dollar in 5 cent increments)");
		int price = sc.nextInt();

		if(price >= 25 && price <= 100 && price % 5 == 0)
		{
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
		}else{
			if(price <= 25)
				System.out.println("The price is less than 25 cents");
			if(price >= 100)
				System.out.println("The price is more than 1 dollar");
			if(price % 5 != 0)
				System.out.println("The price is not a multiple of 5");
		}
	}

}
