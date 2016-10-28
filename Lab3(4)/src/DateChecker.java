import java.util.Scanner;

public class DateChecker {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input a date in the format mm/dd/yyyy");
		String dateText = sc.nextLine();
		String[] dateInfo = dateText.trim().split("/"); //Split the string delim by "/", remove whitespace

		int month = Integer.parseInt(dateInfo[0]);
		int day = Integer.parseInt(dateInfo[1]);
		int year = Integer.parseInt(dateInfo[2]);
		
		boolean isBad = false;
		//Check the month
		if(month > 12){
			System.out.println("Month cannot be greater than 12");
			isBad = true;
		}
		
		//Check the day
		if(day > 31){
			System.out.println("Day cannot be greater than 31");
			isBad = true;
		}
		if(day > 30 && (month == 9 || month == 4 || month == 6 || month == 11)){
			System.out.println("The Months of April, June, September and November cannot have more than 30 days");
			isBad = true;
		}
		//Februrary check
		if(day > 28 && month == 2){
		//February can only have 29 on leap years
			boolean isLeap = (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
			
			if(day == 29 && month == 2 && !isLeap){
				System.out.println("February can only have 29 on leap years");
				isBad = true;
			}
			else if(isLeap && day > 29){
				System.out.println("February cannot have more than 29 days on this year");
				isBad = true;
			}
		}
		
		if(!isBad){
			System.out.println("Your date is valid: " +dateText);
		}
	}
}