import java.util.Scanner;

public class BMRFinder {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double BMR;
		double weight, height;
		int age;

		System.out.print("Please input your gender: Male(M) or Female(W):");
		boolean isMale = false;
		String genderText = sc.next();

		if(genderText.equalsIgnoreCase("M"))
			isMale = true;
		else if (genderText.equalsIgnoreCase("W"))
			isMale = false;

		System.out.println("Please input your weight in pounds");
		weight = sc.nextDouble();

		System.out.println("Please input your height in inches");
		height = sc.nextDouble();

		System.out.println("Please input your age");
		age = sc.nextInt();

		if(isMale){
			BMR = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
		}else{
			BMR= 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
		}
		System.out.println("BMR: " +BMR);
		
		int chocoCalorie = 230;
		
		System.out.println("You should eat: " +(int)(BMR / chocoCalorie) +" Chocolate Bars");
		

	}
}
