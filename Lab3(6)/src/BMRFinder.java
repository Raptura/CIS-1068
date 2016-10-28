import java.util.Scanner;

public class BMRFinder {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double BMR;
		double weight, height;
		int age;

		System.out.println("Please input your gender: Male(M) or Female(W):");
		boolean isMale = false;
		String genderText = sc.next();

		if(genderText.equalsIgnoreCase("M"))
			isMale = true;
		else if (genderText.equalsIgnoreCase("W"))
			isMale = false;
		
		System.out.println("Are you Sedentary/Somewhat Active/ Active/ Highly active?");
		String activityText = sc.nextLine();
		int activityChoice = 0;
		
		if(activityText.equalsIgnoreCase("Sedentary")){
			activityChoice = 0;
		}
		else if(activityText.equalsIgnoreCase("Somewhat Active")){
			activityChoice = 1;
		}
		else if(activityText.equalsIgnoreCase("Active")){
			activityChoice = 2;
		}
		else if(activityText.equalsIgnoreCase("Highly Active")){
			activityChoice = 3;
		}
		
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
		
		if(activityChoice == 0){
			BMR *= 1.2;
		}
		else if(activityChoice == 1){
			BMR *= 1.3;
		}
		else if(activityChoice == 2){
			BMR *= 1.4;
		}
		else if(activityChoice == 3){
			BMR *= 1.5;
		}
		
		
		System.out.println("BMR: " +BMR);
		
		int chocoCalorie = 230;
		
		System.out.println("You should eat: " +(int)(BMR / chocoCalorie) +" Chocolate Bars");
		

	}
}
