import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Bank {

	public static final double OVERDRAFT_FEE = 35.0;
	public static final double INTEREST_RATE = 0.02;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){
		Bank bank = new Bank();

		int choice = -1;
		while(choice != 10){
			choice = bank.displayMenu();

			switch(choice){
			case 1:
				bank.acctArr.read();
				bank.transArr.read();
				bank.acctArr.sort();
				bank.transArr.sortByAccount();
				break;
			case 2:
				bank.reconcile();
				break;
			case 3:
				bank.printAccByID();
				break;
			case 4:
				bank.printAcctByOwner();
				break;
			case 5:
				bank.printSummaryReport();
				break;
			case 6:
				bank.printDetailReport();
				break;
			case 7:
				bank.acctArr.print();
				break;
			case 8:
				bank.transArr.print();
				break;
			case 9:
				bank.acctArr.save();
				bank.transArr.save();;
				break;
			}
		}

		System.out.println("Quitting Program");
	}


	//Bank Object -- Non Static
	public AccountArray acctArr;
	public TransactionArray transArr;

	public Bank(){
		acctArr = new AccountArray(10);
		transArr = new TransactionArray(10);
	}

	public int displayMenu(){
		String menu = "";
		menu += "1-Read and sort account and transaction files \n";
		menu += "2-Reconcile accounts \n";
		menu += "3-Find account by ID-Binary Search-List Transactions \n";
		menu += "4-Find account by owner-Selection Search-List Transactions \n";
		menu += "5-Print account summary report \n";
		menu += "6-Print account detail report \n";
		menu += "7-Print all accounts \n";
		menu += "8-Print all transactions \n";
		menu += "9-Save account and transactions to file \n";
		menu += "10-Exit \n";
		menu += "Enter a choice: ";

		System.out.println(menu);

		int input = sc.nextInt();

		if(input > 0 && input <= 10){
			return input;
		}

		return displayMenu(); //Do that again

	}

	public void reconcile(){
		System.out.println("Reconciling accounts ...");

		for (int i = 0; i < acctArr.getCount(); i++){
			Account a  = acctArr.accountAt(i);

			//Do those transactions
			for(int j = 0; j < transArr.getCount(); j++){
				Transaction t = transArr.transactionAt(j);

				//d - deposit
				//w - withdrawal
				//i - interest payment
				//o - overdraft fee

				//Process the transactions
				if(t.getAccountID() == a.getID()){
					if(t.getTransactionType() == 'd'){
						a.setBalance(a.getBalance() + t.getAmount());
					}else if (t.getTransactionType() == 'w'){
						a.setBalance(a.getBalance() - t.getAmount());
					}else if (t.getTransactionType() == 'i'){
						a.setBalance(a.getBalance() + t.getAmount());
					}else if (t.getTransactionType() == 'o'){
						a.setBalance(a.getBalance() - t.getAmount());
					}
				}

			}

			//Overdraft fees and added interest rates
			if(a.getBalance() < 0){
				transArr.insert(a.getID(), new Date() , 'o', OVERDRAFT_FEE);
			}

			//Add interest
			transArr.insert(a.getID(), new Date() , 'i', round((a.getBalance() * INTEREST_RATE/12), 2));

			transArr.sortByAccount();
		}
	}

	public double round(double d, int digits){
		int n = (int)(d*Math.pow(10.0, digits+1));
		n += 5;
		n /= 10;
		d = (double)n;
		d /= Math.pow(10.0, digits);
		//System.out.println("n = " + n + " d = " + d);
		return d;

	}

	public void printSummaryReport(){
		System.out.println("Account Summary Report");
		System.out.println("ID \t Owner \t Balance");
		for(int i = 0; i < acctArr.getCount(); i++){
			String s = "";
			s += acctArr.accountAt(i).getID() + "\t";
			s += acctArr.accountAt(i).getName() + "\t";
			s += acctArr.accountAt(i).getBalance() + "\t";
			System.out.println(s);
		}
	}

	public void printDetailReport(){
		System.out.println("Account Detail Report");
		for(int i = 0; i < acctArr.getCount(); i++){
			acctArr.accountAt(i).print();
			System.out.println("ID \t Date \t Type \t Amount");
			for(int j = 0; j < transArr.getCount(); j++){
				if(transArr.transactionAt(j).getAccountID() == acctArr.accountAt(i).getID()){
					String s = "";
					s += transArr.transactionAt(j).getTransactionID() + "\t";
					s += transArr.transactionAt(j).getDate().toString() + "\t";
					s += transArr.transactionAt(j).getTransactionType() + "\t";
					s += transArr.transactionAt(j).getAmount() + "\t";

					System.out.println(s);
				}
			}
		}
	}

	public void printAccByID(){
		System.out.println("Enter an account Number:");
		int accID = sc.nextInt();
		
		System.out.println("Account Report:");
		printAcctAndTrans(acctArr.searchByID(accID));
	}

	public void printAcctByOwner(){
		System.out.println("Enter an Account Owner's Name: \n");
		String accName = sc.next();
		
		System.out.println("Account Report:");
		printAcctAndTrans(acctArr.searchByName(accName));
	}

	public void printAcctAndTrans(int accAt){
		Account a = acctArr.accountAt(accAt);
		a.print();

		System.out.println("ID \t Date \t Type \t Amount");
		for(int i = 0; i < transArr.getCount(); i++){
			if(transArr.transactionAt(i).getAccountID() == a.getID()){
				String s = "";
				s += transArr.transactionAt(i).getTransactionID() + "\t";
				s += transArr.transactionAt(i).getDate().toString() + "\t";
				s += transArr.transactionAt(i).getTransactionType() + "\t";
				s += transArr.transactionAt(i).getAmount() + "\t";

				System.out.println(s);
			}
		}
	}
}
