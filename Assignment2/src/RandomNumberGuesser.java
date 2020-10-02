import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		//VARIABLES BEING DEFINED
		int randNum;
		int nextGuess;
		String choice;
		System.out.println("*RANDOM NUMBER GUESSER*\n");
		do //IF THE USER WAS TO UNDER YES IT WOULD REPEAT THE WHOLE PROGRAM FROM HERE
		{
			int lowGuess = 0; //LOWEST GUESS THE RANDOM NUMBER CAN BE
			int highGuess = 100; //HIGHEST GUESS THE RANDOM NUMBER CAN BE
			randNum=RNG.rand();
			System.out.println("Enter your first guess "); //USER HAS TO PUT IN THEIR FIRST GUESS
			nextGuess = userInput.nextInt();
				
					do //THE LOOP FOR VALIDATION UNTIL USER GUESSED THE CORRECT #
					{
						if(RNG.inputValidation(nextGuess, lowGuess, highGuess)) //DETERMINS WHETHER THE GUESS IS VALID
						{
						if(nextGuess > randNum) //THE USER INPUT IF ITS GREATER THAN RANDOM NUMBER
						{				
							highGuess = nextGuess;
							System.out.println("Number of guess is " + RNG.getCount()); //THE # OF GUESS INCREMENTS
							System.out.println("Your guess is too high");
							System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
							nextGuess = userInput.nextInt();
						}
						
						else if(nextGuess < randNum) //THE USER INPUT IF ITS LESS THAN RANDOM NUMBER
						{
							lowGuess = nextGuess;
							System.out.println("Number of guess is " + RNG.getCount()); //THE # OF GUESS INCREMENTS
							System.out.println("Your guess is too low");
							System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
							nextGuess = userInput.nextInt();
						}
						
						else // THIS WORKS IF THE USER CORRECTS SOMETHING OUTSIDE THE GIVEN RANGE
						{
							RNG.inputValidation(nextGuess, lowGuess, highGuess);
						}
						}
						else // TASKS THE USER TO INPUT ANOTHER #
						{
							nextGuess = userInput.nextInt();
						}
					}while(nextGuess > randNum || nextGuess < randNum); //QUITS THE LOOP IF # IS GUESSED CORRECTLY
					
					System.out.println("Number of guess is " + RNG.getCount());
					System.out.println("Congratulation, you guessed correctly");
					RNG.resetCount();
					
			System.out.println("Try again? (yes or no)"); //PROMPT THE USER TO REPEAT THE GAME OR QUIT
			userInput.nextLine();
			choice = userInput.nextLine(); //INPUT CHOICE FOR THE USER
			
		}while(choice.equals("yes") || choice.equals("Yes") || choice.equals("YES")); //IF USER CHOSE YES THEN REPEAT
		
		userInput.close();
		System.out.println("Thanks for playing\n"
				+ "\n"
				+ "Programmer: Surafiel Tesfahun");
	}
}
