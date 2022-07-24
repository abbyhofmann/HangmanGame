package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Represents the interface for the view. In this program, the view is responsible for displaying
 * the hangman game, using information provided from the controller of the program.
 */
public interface GUIViewInterface {

  void makeVisible();

  void setGuessButtonListener(ActionListener actionEvent);

  void setNewGameButtonListener(ActionListener actionEvent);

  JComboBox<String> getGuessDropdown();

  void setDisplayedWord(String word);

  void renderMessage(String message);

  void displayMan(int guessesRemaining);

  String start();

  void displayGuessedLetters(ArrayList<String> letters);

}
