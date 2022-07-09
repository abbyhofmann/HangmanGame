package model;

import java.util.ArrayList;

public class HangmanImpl implements HangmanInterface {

  private String wordBeingGuessed;
  private String[] wordWithGuesses;
  private ArrayList<String> guessedLetters;
  private int remainingGuesses;

  public HangmanImpl(String word) {
    this.wordBeingGuessed = word;
    this.wordWithGuesses = this.initWord(word);
    this.guessedLetters = new ArrayList<>();
    this.remainingGuesses = 8; //TODO: adjust int if necessary
  }

  private String[] initWord(String word) {
    String[] initList = new String[word.length()];
    for (int i = 0; i < word.length(); i ++) {
      if (word.substring(i, i + 1).equals(" ")) {
        initList[i] = " ";
      } else {
        initList[i] = "_";
      }
    }
    return initList;
  }

  // TODO: java doc

  /**
   *
   * @param letter
   * @throws IllegalArgumentException
   * @throws IllegalStateException
   */
  public void updateState(String letter) throws IllegalArgumentException, IllegalStateException {

    if (letter.length() > 1) {
      throw new IllegalArgumentException("Letter can only be represented by one character at a time");
    }

    this.checkGameStatus();    //TODO: is this valid to check state before and after?

    this.trackGuessed(letter);
    this.updateWordWithGuesses(letter);

    this.checkGameStatus();


    //printing for testing purposes
    StringBuilder builder1 = new StringBuilder();
    StringBuilder builder2 = new StringBuilder();

    for (int test = 0; test < this.wordWithGuesses.length; test ++) {
      builder1.append(this.wordWithGuesses[test]);
    }
    for (int test2 = 0; test2 < this.guessedLetters.size(); test2 ++) {
      builder2.append(this.guessedLetters.get(test2));
    }
    System.out.println("Word w guesses: " + builder1 + "\n Guesses remaining: " + this.remainingGuesses
    + "\n Guessed letters: " + builder2);

  }

  /**
   * Checks to see if the game is won or lost before any changes to the model are attempted. If the
   * game is either won or lost, and IllegalStateException is thrown.
   * @throws IllegalStateException Exception thrown if game is won or lost.
   */
  private void checkGameStatus() throws IllegalStateException {
    if (this.isLost()) {
      throw new IllegalStateException("Game over! No remaining guesses.");
    }
    if (this.isSolved()) {
      throw new IllegalStateException("Game over! All letters have been revealed.");
    }
  }

  /**
   * Updates the wordWithGuesses based on whether the given letterGuessed string is found within
   * the wordBeingGuessed. If it is, the wordWithGuesses is updated so that each occurrence of
   * letterGuessed in wordBeingGuessed appears in the corresponding location of wordWithGuesses. If
   * the letterGuessed is not found in the wordBeingGuessed, the wordWithGuesses is not updated and
   * instead the remainingGuesses decreases by 1. This method allows for the correct letters to
   * be revealed in wordWithGuesses as letters are provided when the method is called.
   * @param letterGuessed A string representing the letter being guessed as a letter in the word.
   */
  private void updateWordWithGuesses(String letterGuessed) {
    if (this.wordBeingGuessed.toLowerCase().contains(letterGuessed.toLowerCase())) {
      for (int i = 0; i < this.wordBeingGuessed.length(); i++) {
        if (this.wordBeingGuessed.substring(i, i + 1).equalsIgnoreCase(letterGuessed)) {
          this.wordWithGuesses[i] = letterGuessed;
        }
      }
    } else {
      this.remainingGuesses = this.remainingGuesses - 1;
    }
  }

  /**
   * Updates the contents of the guessedLetters ArrayList by checking if the given letterGuessed is
   * contained in the guessedLetters array. If it is not, the letterGuessed is added to the
   * ArrayList. This prevents the same letter from being added multiple times each time it is
   * guessed.
   * @param letterGuessed A string representing the letter being guessed as a letter in the word.
   */
  private void trackGuessed(String letterGuessed) {
    if (! (this.guessedLetters.contains(letterGuessed))) {
      this.guessedLetters.add(letterGuessed);
    }
  }

  /**
   * Determines if a game is lost. A game is lost when there are 0 guesses remaining.
   * @return True if the game is lost, false if not.
   */
  public boolean isLost() {
    return this.remainingGuesses == 0;
  }

  /**
   * Determines if a game is won. A game is won when all letters in wordWithGuesses have been
   * revealed.
   * @return True if the game is won, false if not.
   */
  public boolean isSolved() {
    boolean solved = true;
    for (int i = 0; i < this.wordWithGuesses.length; i ++) {
      if (this.wordWithGuesses[i].equals("_")) {
        solved = false;
      }
    }
    return solved;
  }

  public String wordGuessedSoFar() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < this.wordWithGuesses.length; i ++) {
      builder.append(this.wordWithGuesses[i] + " ");
    }
    return builder.toString();
  }

  @Override
  public int getRemainingGuesses() {
    return this.remainingGuesses;
  }

  @Override
  public void reset(String newWord) {

    this.wordBeingGuessed = newWord;
    this.wordWithGuesses = this.initWord(newWord);
    this.guessedLetters = new ArrayList<>();
    this.remainingGuesses = 8;

  }

  @Override
  public ArrayList<String> getGuessedLetters() {
    return this.guessedLetters;
  }

}


/*
Model
- user should be able to set word for each round of the game
  - this will be a String field in the model class
- user will guess letters one character at a time
  - this will be represented as an ArrayList<Character>
- user will have a limited number of guesses
  - represented as an int

View
- panel for displaying the hangman being drawn
- textbox for user input
- restart game button
- quit game button
- error message will pop up if...
  - user enters a number
 */