import java.util.Scanner;

public class Lab1a {

	public static void main(String[] args){
		System.out.println("Hello World!");
		
		Scanner keyboard = new Scanner(System.in);
		String name = new String();
		int age = 0;
		
		System.out.print("Enter your name:");
		name = keyboard.next();
		
		System.out.print("Enter your age");
		age = keyboard.nextInt();
		
		System.out.print("Hello ");
		System.out.print(name);
		System.out.print(" your age is ");
		System.out.print(age);
	}
}
