import java.util.Scanner;

public class InterestCalculator {
	public static void main(String[] args){

		String input = "";

		while(!input.equalsIgnoreCase("quit")){
			Scanner sc = new Scanner(System.in);

			System.out.println("Please input a new balance(decimal value) or type 'quit' to exit program");
			input = sc.nextLine();

			//Leave if the user prompts to quit
			if(input.equalsIgnoreCase("quit")){
				continue;
			}

			double balance = Double.parseDouble(input);
			System.out.println("Please input an interest rate (decimal) Ex: 0.02 is 2 percent");
			double interestRate = sc.nextDouble();

			System.out.println("Your Monthly Interest after a year:" +monthlyInterest(balance,interestRate));
			System.out.println("Your Annual Interest after a year:" +yearlyInterest(balance,interestRate));
			System.out.println("Your Daily Interest after a year:" +dailyInterest(balance,interestRate));
		} 
	}

	public static double monthlyInterest(double balance, double interest){
		double newBalance = balance;

		for(int i = 1; i <= 12; i++){
			newBalance += (newBalance * interest / 12);
		}

		return newBalance;
	}

	public static double yearlyInterest(double balance, double interest){
		double newBalance = balance;

		newBalance += (newBalance * interest);

		return newBalance;
	}

	public static double dailyInterest(double balance, double interest){
		double newBalance = balance;

		for(int i = 1; i <= 365; i++){
			newBalance += (newBalance * interest / 365);
		}

		return newBalance;
	}
}
