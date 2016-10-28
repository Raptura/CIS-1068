import java.util.Scanner;

public class Student {

	//There is no reason to put the main method anywhere else
	public static void main(String[] args){
		Student student1 = new Student();
		student1.displayStudentScores();
		student1.inputScores();
		student1.displayStudentScores();
	}
	
	private double finalExamScore = 0; //50% of grade
	private double midterm1 = 0, midterm2 = 0; //25% of grade EACH
	private double quiz1 = 0, quiz2 = 0; //25% Total

	private double finalGrade = 0;
	private String finalLetterGrade = "F";

	public void inputScores(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please input the first quiz score(A value from 0.0 to 100.0)");
		quiz1 = sc.nextDouble();
		
		System.out.println("Please input the second quiz score(A value from 0.0 to 100.0)");
		quiz2 = sc.nextDouble();
		
		System.out.println("Please input the first midterm score(A value from 0.0 to 100.0)");
		midterm1 = sc.nextDouble();
		
		System.out.println("Please input the second midterm score(A value from 0.0 to 100.0)");
		midterm2 = sc.nextDouble();
		
		System.out.println("Please input the final exam score(A value from 0.0 to 100.0)");
		finalExamScore = sc.nextDouble();
		
		System.out.println("Calculating Final Grade...");
		setFinalGrade();
		setFinalLetterGrade();
		System.out.println("Calculation Completed");
	}

	public void setFinalGrade(){
		double totalEarnablePoints = 500;
		double finalPoints = finalExamScore * (totalEarnablePoints * 0.5);
		double midterm1Points = midterm1 * (totalEarnablePoints * 0.25);
		double midterm2Points = midterm2 * (totalEarnablePoints * 0.25);
		double quizPoints = ((quiz1 + quiz2) / 2) * (totalEarnablePoints * 0.25);


		finalGrade = (finalPoints + midterm1Points + midterm2Points + quizPoints) / totalEarnablePoints;
	}

	public void setFinalLetterGrade(){
		if(finalGrade >= 90.0)
			finalLetterGrade = "A";
		else if (finalGrade >= 80)
			finalLetterGrade = "B";
		else if (finalGrade >= 70)
			finalLetterGrade = "C";
		else if(finalGrade >= 60)
			finalLetterGrade = "D";
		else
			finalLetterGrade = "F";
	}
	
	public void displayStudentScores(){
		System.out.println("~~~~Student Data~~~~");
		System.out.println("Quiz One Score: " + quiz1);
		System.out.println("Quiz Two Score: " + quiz1);
		System.out.println("Midterm One Score: " + midterm1);
		System.out.println("Midterm Two Score: " + midterm2);
		System.out.println("Final Exam Score: " + finalExamScore);
		System.out.println("Final Grade: " + finalGrade +"(" +finalLetterGrade +")");
	}
}