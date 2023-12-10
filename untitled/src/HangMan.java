// name: Javeria Zaheer
// reg no: 2021-CE-3

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class HangMan {

    private String[] wordCollection = {"banana", "apple", "mango", "pinapple", "grapefruit", "kiwi", "custardapple", "dragonfruit", "coconut", "strawberry", "blueberry", "melon", "tangerine", "apricot", "peach", "orange", "cherry", "grape", "watermelon", "pear"};
    private String compPick = null;
    private int guesses;
    private int warning = 4;

    private String guessedWord = new String();
    private String availableletters=new String("abcdefghijklmnopqrstuvwxyz");
    private  ArrayList<String> guessedLetters=new ArrayList<String>();
    private char[] Arr;
    private int count=0;


    public Boolean isInPick(char letter) {
        // if the letter is in computer picked word
        if(compPick.contains(Character.toString(letter))){
            return true;
        }else
            return false;
    }
    public void updateGuessed(char letter, int loc) {
        // if the lguess is correct update the guessed word
        if (count==0) {
            Arr = new char[compPick.length()];
        }


        for (int i=loc;i<compPick.length();i++){

            if (Character.toString(letter).equals(Character.toString(compPick.charAt(i)))){
                Arr[i]=letter;

            }
            else {
                if (Arr[i]=='_' && count!=0) {
                    Arr[i] = '_';
                } else if (count==0) {
                    Arr[i] = '_';

                }
            }

        }
        count+=1;
        guessedWord=String.valueOf(Arr);
        System.out.println(guessedWord);

    }

    //****** complete the game using the unfinished functions ******//
    public void play() {

        /* few things to do here
        1. pick secret word and set guessed accordingly and available guesses
        2. tell user number of characters in it and total guess and warnings and available charecters
        3. ask user for guess and if guess isInPick then updateGuessed and total guesses and warnings in case of invalid input
        4. continue the game unless user wins or have consumed all guesses
         */
        Random random=new Random();
        int index= random.nextInt(wordCollection.length);
        //generating a random index to select a word from wordCollection
        Scanner sc=new Scanner(System.in);
        compPick=wordCollection[index];
        guesses= (int) (1.5*compPick.length());
        System.out.println("Welcome to hangman.\n" +
                "I'm thinking of a word that is " +compPick.length()+" letters long \n" +
                " --------------------------------");
        while (guesses>0) {
            System.out.println("you have " + warning + " warnings left\n" +
                    "you have " + guesses + " guesses left\n" +
                    "guessed word: "+guessedWord +"\n"+
                    "available letters: " + availableletters);
            char guess = sc.next().charAt(0);
            Character.toLowerCase(guess);
            availableletters = availableletters.replace(Character.toString(guess), "");
            //invalid guess
            if (Character.isAlphabetic(guess) == false || guessedLetters.contains(Character.toString(guess))) {
                if (warning == 0) {
                    guesses -= 1;

                    warning += 4;
                    System.out.println("You lose one guess. ");
                } else {
                    warning -= 1;
                    System.out.println("That is an invalid guess. You lose one warning");
                }
            }
            //valid guess
            else {
                guessedLetters.add(Character.toString(guess));
                //incorrect guess
                if (this.isInPick(guess)==false) {
                    guesses-=1;
                    System.out.println("Your guess is incorrect.");

                } //correct guess
                else if (this.isInPick(guess)) {
                    int loc=0;
                    System.out.println("Great guess!");
                    this.updateGuessed(guess,loc);
                    if (compPick.equals(guessedWord)){
                        System.out.println("Hurrah! You have won the game");
                        break;
                    }
                }


            }
        }
        if (guesses==0){
            System.out.println("Oops! You ran out of guesses :( \n" +
                    "the word Was: "+compPick);
        }

    }

    public static void main(String args[]) {
        HangMan h = new HangMan();
        h.play();

    }
}

