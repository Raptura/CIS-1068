
public class Account {

	public static int count = 0;

	private int id;
	private String name;
	private double balance;

	public Account(int id, String name, double balance){
		this.id = id;
		this.name = name;
		this.balance = balance;
		count++;
	}

	private Account(Account clone){
		this(clone.getID(), clone.getName(), clone.getBalance());
	}

	public int getID(){
		return this.id;
	}

	public void setID(int id){
		this.id = id;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getBalance(){
		return this.balance;
	}

	public void setBalance(double b){
		this.balance = b;
	}

	@Override
	public String toString(){
		String s = "";
		s += "ID: " +getID() +"\n";
		s += "Owner: " +getName() +"\n";
		s += "Balance: "+getBalance() + "\n";
		return s;
	}

	public void print(){
		System.out.println(this.toString());
	}

	public void copy(Account a){
		this.name = a.getName();
		this.id = a.getID();
		this.balance = a.getBalance();
	}

	public Account clone(){
		return new Account(this);
	}


}
