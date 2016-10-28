
public class Movie {

	public static void main(String[] args){
		
		//First movie
		Movie m1 = new Movie();
		m1.setName("The house on the hill");
		m1.setMPAA("R");
		//Add 5 Ratings
		m1.addRating(2);
		m1.addRating(1);
		m1.addRating(5);
		m1.addRating(5);
		m1.addRating(4);
		
		System.out.println(m1.getName() +" MPAA: " +m1.getMPAA() +" Viewer Ratings " +m1.getAverage() +" out of 5 Stars");
		
		//Second movie
		Movie m2 = new Movie();
		m2.setName("Spongebob Movie");
		m2.setMPAA("PG");
		//Add 5 Ratings
		m2.addRating(5);
		m2.addRating(5);
		m2.addRating(5);
		m2.addRating(5);
		m2.addRating(4);
		
		System.out.println(m2.getName() +" MPAA: " +m2.getMPAA()  +" Viewer Ratings " +m2.getAverage() +" out of 5 Stars");
	}

	private String name;
	private String MPAA_Rating;
	//Number of people who rated the movie 1 through 5
	private int num_1 = 0,
			num_2 = 0,
			num_3 = 0,
			num_4 = 0,
			num_5 = 0;

	public void addRating(int rate){
		switch (rate){
		case 1:
			num_1++;
			break;
		case 2:
			num_2++;
			break;
		case 3:
			num_3++;
			break;
		case 4:
			num_4++;
			break;
		case 5:
			num_5++;
			break;
		default:
			System.out.println("This is not a valid rating");
		}
	}

	public double getAverage(){
		double sum = num_1 + num_2 + num_3 + num_4 + num_5;
		double points = num_1 + (2 * num_2) + (3 * num_3) + (4* num_4) + (5 * num_5);
		return points / sum;
	}
	
	public String getMPAA(){
		return MPAA_Rating;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setMPAA(String rate){
		MPAA_Rating = rate;
	}


}
