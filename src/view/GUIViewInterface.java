package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public interface GUIViewInterface {

  void makeVisible();
  void setGuessButtonListener(ActionListener actionEvent);
  void setNewGameButtonListener(ActionListener actionEvent);
  JComboBox getGuessDropdown();
  void setDisplayedWord(String word);
  void renderMessage(String message);
  void displayMan(int guessesRemaining);
  String start();
  void displayGuessedLetters(ArrayList<String> letters);

}
