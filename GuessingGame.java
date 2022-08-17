/*
Alexander Bockheim
CS 145
Plays a guessing game with the user
The user guesses a number and the program tells them if it is higher or lower than its  number
This goes on until the user guesses correctly
A report is given at the end
Could not figure out how to bold and underline
*/
import java.util.Scanner;


public class GuessingGame {
   static final int RANGE = 100;
   
   public static void main(String args[]) {
      int games = 0;
      int minGuesses = 9999;
      int totalGuesses = 0;
      int newGuesses;
      boolean cont = true;
      char answer;
      Scanner user = new Scanner(System.in);
      intro();
      while(cont) {
         games++;
         newGuesses = play((int)(Math.random() * RANGE) + 1, user);
         if(newGuesses < minGuesses)
            minGuesses = newGuesses;
         totalGuesses += newGuesses;
         System.out.print("Do you want to play again? ");
         answer = user.next().charAt(0);
         if(Character.toUpperCase(answer) == 'Y')
            cont = true;
         else if(Character.toUpperCase(answer) == 'N')
            cont = false;
         System.out.println();
      }
      report(totalGuesses, minGuesses, games);
   }
   
   //Introduces the game and the range
   public static void intro() {
   System.out.println("This program allows you to play a guessing game.");
   System.out.println("I will think of a number between 1 and");
   System.out.println(RANGE + " and will allow you to guess until");
   System.out.println("you get it. For each guess, I will tell you");
   System.out.println("whether the right answer is higher or lower");
   System.out.println("than your guess.");
   System.out.println();
   }
   
   //Prompts the user for guesses until they guess correctly
   public static int play(int rand, Scanner user) {
      int guesses = 0;
      int userGuess;
      System.out.println("I'm thinking of a number between 1 and " + RANGE + "...");
      do {
         guesses++;
         System.out.print("Your guess? ");
         userGuess = user.nextInt();
         if(userGuess < rand)
         
            System.out.println("It's higher.");
         else if(userGuess > rand)
            System.out.println("It's lower.");
         else if (userGuess == rand && guesses == 1)
            System.out.println("You got it right in " + guesses + " guess");
         else if(userGuess == rand)
            System.out.println("You got it right in " + guesses + " guesses");
      } while(userGuess != rand);
      return guesses;
   }
   
   //Prints a report of all games played
   public static void report(int totalGuesses, int min, int games) {
      System.out.println("Overall results:");
      System.out.println("\ttotal games \t= " + games);
      System.out.println("\ttotal guesses \t= " + totalGuesses);
      Double avg = (double)totalGuesses  / (double)games;
      System.out.printf("\tguesses/game \t= %.1f",avg);
      System.out.println();
      System.out.println("\tbest game \t\t= " + min);
   }
}
