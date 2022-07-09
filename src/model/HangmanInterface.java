package model;

import java.util.ArrayList;

public interface HangmanInterface {

  // TODO: add public methods

  void updateState(String letter) throws IllegalArgumentException, IllegalStateException;

  boolean isLost();

  boolean isSolved();

  String wordGuessedSoFar();

  int getRemainingGuesses();
  void reset(String newWord);
  ArrayList<String> getGuessedLetters();

}
