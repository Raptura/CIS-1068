import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class AccountArray {

	private Account[] accounts;
	private int count;
	private int growth;

	public AccountArray(int length){
		accounts = new Account[length];
		count = 0;
		growth = length;
	}

	public Account[] getAccounts(){
		return this.accounts;
	}

	public void setAccounts(Account[] a){
		this.accounts = a;
	}

	public int getLength(){
		return this.accounts.length;
	}

	public int getCount(){
		return this.count;
	}

	public int getGrowth(){
		return this.growth;	
	}

	public Account accountAt(int i){
		return this.accounts[i];
	}


	public void resize(){
		int newLen = count + growth;

		Account[] newArr = new Account[newLen];

		for(int i = 0; i < count; i++){
			newArr[i] = accounts[i]; 
		}

		accounts = newArr; //set it to the new value
	}

	public void insert(int id, String name, double balance){
		Account newAcc = new Account(id, name, balance);
		
		if(count >= accounts.length){
			resize(); //resize the accounts
		}

		accounts[count] = newAcc;
		

		this.count++; //increment counts
	}

	public void print(){
		for(int i = 0; i < count; i++){
			accounts[i].print();
		}
	}

	public void read(){
		Scanner inputStream;
		String s;
		String sa[];
		try{
			inputStream = new Scanner(new File("accounts.txt"));
			while(inputStream.hasNextLine()){
				s = inputStream.nextLine();
				sa = s.split(",");
				insert(Integer.parseInt(sa[0]), sa[1], Double.parseDouble(sa[2]));
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
			outputStream = new PrintWriter("accounts.txt");
			for(int i=0; i< count; i++)
				outputStream.printf("%s,%s,%s\r\n", accounts[i].getID(),
						accounts[i].getName(),
						accounts[i].getBalance());
			outputStream.close();
		}
		catch(Exception ex){
			System.out.println("ERROR: " + ex.toString());
		}
	}
	public void sort(){
		//Sorts the accounts by ID
		boolean swapped = false;
		while(!swapped){
			swapped = true;
			for(int i = 0; i < count - 1; i++){
				if(accounts[i].getID() > accounts[i + 1].getID()){
					Account temp = accounts[i];
					accounts[i] = accounts[i+1];
					accounts[i+1] = temp;
					swapped = false;
				}
			}
		}
	}

	//Swaps two account elements
	public void swap(int i, int j){
		Account temp = accounts[i];
		accounts[i] = accounts[j];
		accounts[j] = temp;
	}

	//Please remember this only works on sorted arrays
	public int searchByID(int id){
		int begin = 0;
		int end = count - 1;
		int mid;

		while(begin <= end){

			mid = (int) Math.floor((begin + end) / 2);

			if(id == accounts[mid].getID()){
				return mid;
			}

			if(id > accounts[mid].getID()){
				begin = mid + 1;
			}

			if(id < accounts[mid].getID()){
				end = mid - 1;
			}
		}	
		return -1;
	}
	
	//returns the position in the array
	public int searchByName(String name){
		for(int i = 0; i < count; i++){
			if(name.equals(accounts[i].getName()))
				return i;
		}
		
		return -1;
	}
}