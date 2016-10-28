import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Transaction {

	public static int count = 0;

	private int transactionID;
	private int accountID;
	private Date date;

	//d - deposit
	//w - withdrawal
	//i - interest payment
	//o - overdraft fee
	private char transactionType;
	private double amount;

	public Transaction(int transID, int accID, Date date, char type, double amount){
		this.transactionID = transID;
		this.accountID = accID;
		this.date = date;
		this.transactionType = type;
		this.amount = amount;
		count++;
	}

	public Transaction(int transID, int accID, String date, char type, double amount){
		this.transactionID = transID;
		this.accountID = accID;

		try {
			this.date = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.transactionType = type;
		this.amount = amount;
		count++;
	}

	private Transaction(Transaction transaction) {
		this(transaction.getTransactionID(),transaction.getAccountID(), transaction.getDate(), transaction.getTransactionType(), transaction.getAmount());
	}

	public int getTransactionID(){
		return this.transactionID;
	}

	public void setTransactionId(int ID){
		this.transactionID = ID;
	}

	public int getAccountID(){
		return this.accountID;
	}

	public void setAccountID(int ID){
		this.accountID = ID;
	}

	public Date getDate(){
		return this.date;
	}

	public char getTransactionType(){
		return this.transactionType;	
	}

	public void setTransactionType(char type){
		this.transactionType = type;
	}

	public double getAmount(){
		return amount;
	}

	public void setAmount(double amt){
		this.amount = amt;
	}

	public void copy(Transaction trans){
		this.transactionID = trans.getTransactionID();
		this.accountID = trans.getAccountID();
		this.date = trans.getDate();
		this.transactionType = trans.getTransactionType();
	}

	public Transaction clone(){
		return new Transaction(this);
	}

	@Override
	public String toString(){
		String s = "";
		s += "ID: " + this.transactionID + "\n";
		s += "Account: " + this.accountID + "\n";
		s += "Date: " + this.date.toString() + "\n";
		s += "Type: " + this.transactionType + "\n";
		return s;
	}

	public void print(){
		System.out.println(this.toString());
	}

	public int compareByDate(Transaction trans){
		if(this.getDate().before(trans.getDate())){
			return -1;
		}else if(this.getDate().after(trans.getDate())){
			return 1;
		}else{
			return 0;
		}
	}


	public int compareByID(Transaction trans){
		if(this.getTransactionID() < trans.getTransactionID()){
			return -1;
		}else if(this.getTransactionID() > trans.getTransactionID()){
			return 1;
		}else{
			return 0;
		}
	}

}
