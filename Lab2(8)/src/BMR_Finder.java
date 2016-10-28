import java.util.Scanner;

public class BMR_Finder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double BMR_W, BMR_M; //BMR for both women and man
		double weight, height;
		int age;
		
		System.out.println("Please input your weight in pounds");
		weight = sc.nextDouble();
		
		System.out.println("Please input your height in inches");
		height = sc.nextDouble();
		
		System.out.println("Please input your age");
		age = sc.nextInt();
		
		BMR_W = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
		BMR_M = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
		
		System.out.println("BMR for a Woman: " +BMR_W);
		System.out.println("BMR for a Man: " +BMR_M);

	}

}
