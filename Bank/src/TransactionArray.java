import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class TransactionArray {

	private Transaction[] transactions;
	private int count;
	private int growth;

	public TransactionArray(int length){
		transactions = new Transaction[length];
		count = 0;
		growth = length;
	}

	public Transaction[] getTransactions(){
		return this.transactions;
	}

	public void setTransactions(Transaction[] a){
		this.transactions = a;
	}

	public int getLength(){
		return this.transactions.length;
	}

	public int getCount(){
		return this.count;
	}

	public int getGrowth(){
		return this.growth;	
	}

	public Transaction transactionAt(int i){
		return this.transactions[i];
	}


	public void resize(){
		int newLen = count + growth;

		Transaction[] newArr = new Transaction[newLen];

		for(int i = 0; i < count; i++){
			newArr[i] = transactions[i]; 
		}

		transactions = newArr; //set it to the new value
	}

	public void insert(int accID, Date date, char type, double amount){
		Transaction newAcc = new Transaction(count, accID, date, type, amount);
		if(count >= transactions.length){
			resize(); //resize the transactions
		}

		transactions[count] = newAcc;

		this.count++; //increment counts
	}

	public void insert(int transID,int accID, String date, char type, double amount){

		Transaction newAcc = new Transaction(transID, accID, date, type, amount);
		if(count >= transactions.length){
			resize(); //resize the transactions
		}

		transactions[count] = newAcc;

		this.count++; //increment counts
	}

	public void print(){
		for(int i = 0; i < count; i++){
			transactions[i].print();		
		}
	}

	public void read(){
		Scanner inputStream;
		String s;
		String sa[];
		try{
			inputStream = new Scanner(new File("trans.txt"));
			while(inputStream.hasNextLine()){
				s = inputStream.nextLine();
				sa = s.split(",");
				insert(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), sa[2], sa[3].charAt(0), Double.parseDouble(sa[4]));
			}
			inputStream.close();
		}
		catch(Exception ex){
			System.out.println("ERROR: " + ex.toString());
		}
	}


	public void save(){
		PrintWriter outputStream = null;
		try{
			outputStream = new PrintWriter("trans.txt");
			for(int i=0; i< count; i++)
				outputStream.printf("%s,%s,%s,%s %s \r\n", transactions[i].getTransactionID(),
						transactions[i].getAccountID(), transactions[i].getDate(),
						transactions[i].getTransactionType(), transactions[i].getAmount());
			outputStream.close();
		}
		catch(Exception ex){
			System.out.println("ERROR: " + ex.toString());
		}
	}

	public void sortByID(){
		//Sorts the transactions by ID
		boolean swapped = false;
		while(!swapped){
			swapped = true;
			for(int i = 0; i < count - 1; i++){
				if(transactions[i].getTransactionID() > transactions[i + 1].getTransactionID()){
					Transaction temp = transactions[i];
					transactions[i] = transactions[i+1];
					transactions[i+1] = temp;
					swapped = false;
				}
			}
		}
	}

	public void sortByAccount(){
		//Sorts the transactions by ID
		boolean swapped = false;
		while(!swapped){
			swapped = true;
			for(int i = 0; i < count - 1; i++){
				if(transactions[i].getAccountID() > transactions[i + 1].getAccountID()){
					Transaction temp = transactions[i];
					transactions[i] = transactions[i+1];
					transactions[i+1] = temp;
					swapped = false;
				}

				//swap by date
				//ONLY IF THE IDS are the SAME
				if(transactions[i].getAccountID() == transactions[i + 1].getAccountID()){
					if(transactions[i].compareByDate(transactions[i + 1]) == 1){
						Transaction temp = transactions[i];
						transactions[i] = transactions[i+1];
						transactions[i+1] = temp;
						swapped = false;
					}
				}
			}
		}
	}

	//Swaps two account elements
	public void swap(int i, int j){
		Transaction temp = transactions[i];
		transactions[i] = transactions[j];
		transactions[j] = temp;
	}

	//Please remember this only works on sorted arrays
	public int findFirstByAcc(int accID){
		for(int i = 0; i < count; i++){
			if(transactions[i].getAccountID() == accID){
				return i;
			}
		}
		return -1;
	}

}
