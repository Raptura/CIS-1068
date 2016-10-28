import java.util.Scanner;

public class Hangman {

	public static void main(String[] args){
		Hangman h = new Hangman("ypsillon");
		//System.out.println(h.getSecretWord());
		h.playGame();
	}

	private String disguisedWord = "";
	private String secretWord = "";
	private int wrongGuesses = 0, guessesMade = 0;
	private int maxGuesses = 5;

	public final String FILLER_CHAR = "@";

	public Hangman(String secWord){
		this.secretWord = secWord.toLowerCase();
	}

	public void makeGuess(String guess){
		guessesMade++;

		//Check to see if the character is in the secret word
		if(secretWord.contains(guess)){
			System.out.println("Correct Guess!");
			revealCharacter(guess);
		}else{
			wrongGuesses++;
			System.out.println("You made a wrong guess!");
		}
	}

	public void revealCharacter(String guess){

		String tempS = "";
		for(int i = 0; i < disguisedWord.length(); i++){
			if(secretWord.substring(i, i+1).equals(guess))
				tempS += guess;
			else{
				tempS += disguisedWord.substring(i, i + 1);
			}
		}
		
		disguisedWord = tempS;
	}

	public String getDisguisedWord(){
		return disguisedWord;
	}

	public String getSecretWord(){
		return secretWord;
	}

	public int getGuessCount(){
		return guessesMade;
	}

	public int getWrongGuesses(){
		return wrongGuesses;
	}

	public boolean isFound(){
		return disguisedWord.equalsIgnoreCase(secretWord);
	}

	public void gameOver(boolean win){
		if(win){
			System.out.println("Congratulations! You Won!");
		}else{
			System.out.println("Sorry! Game Over");
		}

		System.out.println("Number of Guesses: " +getGuessCount());
		System.out.println("Number of Wrong Guesses: " +getWrongGuesses());
		System.out.println("The secret word was:" +getSecretWord());
	}

	public void playGame(){
		for(int i = 0; i < secretWord.length(); i++){
			disguisedWord += FILLER_CHAR;
		}
		//Play the game
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Word:  " +getDisguisedWord());
			System.out.println("Make a guess:");
			String guess = sc.next().substring(0, 1).toLowerCase();
			makeGuess(guess);

			if(getWrongGuesses() >= maxGuesses){
				gameOver(false);
				return;
			}

			if(isFound()){
				gameOver(true);
			}

		}while(!isFound());


	}
}
