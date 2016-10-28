import java.util.Scanner;

public class GradeDistributor {

	public static void main(String[] args){
		GradeDistributor dist = new GradeDistributor();
		dist.inputGrades();
		dist.displayTable();
	}

	private int numA = 0;
	private int numB = 0;
	private int numC = 0;
	private int numD = 0;
	private int numF = 0;


	public void inputGrades(){
		Scanner sc = new Scanner(System.in);

		System.out.print("How many A: ");
		numA = sc.nextInt();

		System.out.print("How many B: ");
		numB = sc.nextInt();

		System.out.print("How many C: ");
		numC = sc.nextInt();

		System.out.print("How many D: ");
		numD = sc.nextInt();

		System.out.print("How many F: ");
		numF = sc.nextInt();
	}

	public void displayTable(){
		int percentPerAsterisk = 2;

		String numberDisplay = "", asteriskBar = "", middleBar = "";
		int numCt = 0;
		//Format the bar
		for(int i = 0; i <= 100; i++){
			if(i % percentPerAsterisk == 0){
				asteriskBar += "*";

				if(i % 10 == 0){
					numberDisplay = numberDisplay.substring(0, numberDisplay.length() - Integer.toString(i).length() + 1);
					numberDisplay += i;
					middleBar += "|";

				}else{
					numberDisplay += " ";
					middleBar += " ";
				}
			}
		}

		//print the bars
		System.out.println(numberDisplay);
		System.out.println(middleBar);
		System.out.println(asteriskBar);

		int A_ratio = (int) Math.floor(100 * numA / getTotalNumGrades()) / percentPerAsterisk;
		int B_ratio = (int) Math.floor(100 * numB / getTotalNumGrades()) / percentPerAsterisk;
		int C_ratio = (int) Math.floor(100 * numC / getTotalNumGrades()) / percentPerAsterisk;
		int D_ratio = (int) Math.floor(100 * numD / getTotalNumGrades()) / percentPerAsterisk;
		int F_ratio = (int) Math.floor(100 * numF / getTotalNumGrades()) / percentPerAsterisk;



		System.out.println(numToAsterisk(A_ratio) + "A");
		System.out.println(numToAsterisk(B_ratio) + "B");
		System.out.println(numToAsterisk(C_ratio) + "C");
		System.out.println(numToAsterisk(D_ratio) + "D");
		System.out.println(numToAsterisk(F_ratio) + "F");



	}

	public String numToAsterisk(int num){
		String newBar = "*";

		for (int i = 0; i < num; i++){
			newBar += "*";
		}

		return newBar;

	}

	public int getTotalNumGrades(){
		return numA + numB + numC + numD + numF;
	}




}
