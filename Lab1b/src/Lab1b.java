import java.util.Scanner;

public class Lab1b {

	
	public static final double PI = 3.1459;
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double radius = 0.0;
		double side = 0.0;
		double areaCircle = 0.0;
		double areaSquare = 0.0;
		double difference = 0.0;
		
		//Get radius
		System.out.print("Enter Radius: ");
		radius =  keyboard.nextDouble();
		
		//Get side
		System.out.print("Enter side: ");
		side = keyboard.nextDouble();
		
		//Calculate area of circle
		areaCircle = PI * radius * radius;
		//Calculate area of a square
		areaSquare = side * side;
		//Calculate difference
		difference = Math.abs(areaCircle - areaSquare);
		
		//Print difference to screen
		//System.out.print("The difference is: ");
		//System.out.println(difference);
		
		//Print difference to the screen
		if(areaCircle > areaSquare){
			System.out.print("The circle is larger than the square by: ");
		}else if (areaSquare > areaCircle){
			System.out.print("The square is larger than the circle by: ");
		}else{
			System.out.print("They are equal becaue the difference is ");
		}
		System.out.println(difference);
		
	}

}
