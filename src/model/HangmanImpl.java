package model;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Represents one implementation of HangmanInterface. In this implementation, the word being
 * guessed in the game is represented as a String. The wordWithGuesses field represents the
 * wordBeingGuessed throughout the game as a list of Strings, where each String is a letter. This
 * list is initialized as a list of underscores to reflect unguessed letters, and the list is then
 * updated to reflect guesses that are made during the game. The guessed letters are kept track of
 * in the guessedLetters field, which is an ArrayList of String, where there are no repeated
 * letters. The user also has a limited number of guesses, which begins at 8 and decreases each time
 * an incorrect guess is made.
 */
public class HangmanImpl implements HangmanInterface {

  private String wordBeingGuessed;
  private String[] wordWithGuesses;
  private ArrayList<String> guessedLetters;
  private int remainingGuesses;

  /**
   * Constructs a HangmanImpl object given a String representing the word being guessed. The given
   * String is used to initialize the wordWithGuesses as a list of underscores, where there is one
   * underscore for each letter in the given word. The guessedLetters is initialized as an empty
   * ArrayList, and there are 8 remainingGuesses starting off.
   *
   * @param word The word being guessed in the game.
   * @throws IllegalArgumentException Exception thrown if word is null; ie user selected "cancel"
   *         button instead of entering a word.
   */
  public HangmanImpl(String word) throws IllegalArgumentException {
    if (word == null) {
      throw new IllegalArgumentException("Word cannot be null");
    }
    this.wordBeingGuessed = word;
    this.wordWithGuesses = this.initWord(word);
    this.guessedLetters = new ArrayList<>();
    this.remainingGuesses = 8; //TODO: adjust int if necessary
  }

  /**
   * Initializes the list of String for the wordWithGuesses by going through each character in the
   * given String. If the character is a space, it will be represented as an empty String in the
   * list. If the character is anything else, it will be represented as an underscore. The list of
   * String reflects no guesses being made.
   *
   * @param word The word being converted to a list of underscores.
   * @return The list of String.
   */
  private String[] initWord(String word) {
    return word.chars().mapToObj(x -> x == ' ' ? " " : "_").toArray(String[]::new);
  }

  // TODO: java doc

  /**
   * Updates the state of the game in response to a given String, which represents a letter being
   * guessed. As long as the game is not yet won or lost, the given String will be used to update
   * the guessedLetters and wordWithGuesses fields, which is delegated to two helper methods. This
   * method checks if the game has been won or lost a second time after the updatewordWithGuesses
   * method has been called to ensure the game has not been won or lost in response to the guess.
   * The given String must only have a length of 1.
   *
   * @param letter String representation of the letter being guessed.
   * @throws IllegalArgumentException Exception thrown if String is greater than one character.
   * @throws IllegalStateException    Exception thrown if game is won or lost.
   */
  public void updateState(String letter) throws IllegalArgumentException, IllegalStateException {

    if (letter.length() > 1) {
      throw new IllegalArgumentException("Letter can only be represented by one character at a time");
    }

    this.checkGameStatus();

    this.trackGuessed(letter);
    this.updateWordWithGuesses(letter);

    this.checkGameStatus();


  }

  /**
   * Checks to see if the game is won or lost before any changes to the model are attempted. If the
   * game is either won or lost, and IllegalStateException is thrown.
   *
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
   *
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
   *
   * @param letterGuessed A string representing the letter being guessed as a letter in the word.
   */
  private void trackGuessed(String letterGuessed) {
    if (!(this.guessedLetters.contains(letterGuessed))) {
      this.guessedLetters.add(letterGuessed);
    }
  }

  /**
   * Determines if a game is lost. A game is lost when there are 0 guesses remaining.
   *
   * @return True if the game is lost, false if not.
   */
  public boolean isLost() {
    return this.remainingGuesses == 0;
  }

  /**
   * Determines if a game is won. A game is won when all letters in wordWithGuesses have been
   * revealed.
   *
   * @return True if the game is won, false if not.
   */
  public boolean isSolved() {
    return !Arrays.asList(this.wordWithGuesses).contains("_");
  }

  /**
   * Method for formatting the wordWithGuesses as a String. In this implementation, this method is
   * used to provide this information to the view for display purposes.
   *
   * @return String of the wordWithGuesses.
   */
  public String wordGuessedSoFar() {
    StringBuilder builder = new StringBuilder();
    for (String wordWithGuess : this.wordWithGuesses) {
      builder.append(wordWithGuess).append(" ");
    }
    return builder.toString();
  }

  /**
   * Getter for the remaining guesses.
   *
   * @return The number of remaining guesses for this state of the game.
   */
  @Override
  public int getRemainingGuesses() {
    return this.remainingGuesses;
  }

  /**
   * Resets the state of the game, where the fields are initialized for a new game to be played. If
   * the newWord given is null (ie the user opted to cancel the new game), the program ends.
   *
   * @param newWord String representing a new word to be guessed.
   */
  @Override
  public void reset(String newWord) {
    if (newWord == null) {
      System.exit(0);
    }
    this.wordBeingGuessed = newWord;
    this.wordWithGuesses = this.initWord(newWord);
    this.guessedLetters = new ArrayList<>();
    this.remainingGuesses = 9;

  }

  /**
   * Getter for the guessedLetters.
   *
   * @return The ArrayList<String> of guessedLetters of this state of the game.
   */
  @Override
  public ArrayList<String> getGuessedLetters() {
    return this.guessedLetters;
  }

}

