package model;

import java.util.ArrayList;

/**
 * Represents the interface for a HangmanInterface, which serves as the model for a hangman game -
 * this is where the functionality of the game itself is stored. This interface allows its
 * implementations to store information about the state of the game, as well as to update the state
 * of the game based on input.
 */
public interface HangmanInterface {

  void updateState(String letter) throws IllegalArgumentException, IllegalStateException;

  boolean isLost();

  boolean isSolved();

  String wordGuessedSoFar();

  int getRemainingGuesses();

  void reset(String newWord);

  ArrayList<String> getGuessedLetters();

}
