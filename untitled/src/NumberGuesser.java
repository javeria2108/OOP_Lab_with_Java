/*Name:Javeria Zaheer
Reg no: 2021-CE-3
 */


import java.util.*;

public class NumberGuesser {

    private int guesses = 10;
    private int warning = 1;
    private int guessedNo;
    private int secretNo;
    private int[] alreadyTold = new int[10];
    private int i=0;
    public void setAlreadyTold(int number) {
        // if the number is not in the array already add it
        if (this.isAlreadyTold(number)==false && i<= alreadyTold.length) {
            alreadyTold[i] =  number;
            i++;

        }

    }




    public Boolean isAlreadyTold(int number) {
        // if the number is already in told or not
        for (int element:alreadyTold){
            if (element==number){
                return true;

            }
        }

        return false;
    }

    //****** complete the game using the unfinished functions ******//
    public void play() {

        /* few things to do here
        1. pick secret number and set guessed accordingly
        2. tell user the range of number guessed and total guesses and warnings
        3. ask user for guess check if guess is invalid or repeated user loses a warning and if no warning is left user loses a guess
        5. in case of valid guess check if the guess is equal or not to the guessed number and show appropiate message
        4. continue the game unless user wins or have consumed all guesses
         */
        Random random=new Random();
        secretNo=random.nextInt(1000);
        System.out.println("'Welcome to Number Guesser game'\n" +
                "I am thinking of a number between 0-1000\n" +
                "------------------------------------------\n");

        while (guesses>0) {

            System.out.println("You have " + warning + " warnings left\n" +
                    "You have " + guesses + " guesses left\n" +
                    "--------------------------------\n" +
                    "Numbers Guessed: " + Arrays.toString(alreadyTold) + "\n");
            System.out.println("please guess a number: ");
            Scanner sc=new Scanner(System.in);
            if (sc.hasNextInt()) {
                guessedNo= sc.nextInt();


                if (this.isAlreadyTold(guessedNo) || guessedNo < 0 || guessedNo > 1000) {

                    if (warning <1) {
                        guesses -= 1;

                        warning += 1;
                        System.out.println("You ran out of warnings.You lose one guess. ");
                    } else {
                        warning -= 1;

                        System.out.println("That is an invalid guess.You lose one warning");
                    }

                } else {
                    this.setAlreadyTold(guessedNo);
                    if (guessedNo == secretNo) {
                        System.out.println("Hurrah!! You have guessed the correct number");
                        break;
                    } else if (guessedNo > secretNo) {
                        System.out.println("your guess is bigger");
                        guesses -= 1;
                    } else if (guessedNo < secretNo) {
                        System.out.println("Your guess is smaller");
                        guesses -= 1;
                    }
                }

            }
            else {
                if (warning <1) {
                    guesses -= 1;

                    warning += 1;
                    System.out.println("You ran out of warnings. You lose one guess. ");
                } else {
                    warning -= 1;
                    System.out.println("That is an invalid guess. You lose one warning");
                }

            }
        }if (guesses == 0) {
            System.out.println("Oops! You ran out of guesses. The number was " + secretNo);
        }

    }

    public static void main(String args[]) {
        NumberGuesser n = new NumberGuesser();
        n.play();
    }
}
