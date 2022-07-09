package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.HangmanInterface;
import view.GUIViewInterface;

public class GuessButtonListener implements ActionListener {

  private HangmanInterface model;
  private GUIViewInterface view;


  public GuessButtonListener (HangmanInterface m, GUIViewInterface v) throws IllegalArgumentException {
    if (m == null || v == null) {
      throw new IllegalArgumentException("parameters cannot be null");
    }
    this.model = m;
    this.view = v;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JComboBox dropdown = view.getGuessDropdown();
    String selectedLetter = (String) dropdown.getSelectedItem();
    try {
      model.updateState(selectedLetter);
      view.setDisplayedWord(model.wordGuessedSoFar());
      view.displayMan(model.getRemainingGuesses());
      view.displayGuessedLetters(model.getGuessedLetters());
    } catch (IllegalStateException ex) {
      view.setDisplayedWord(model.wordGuessedSoFar());
      view.renderMessage(ex.getMessage());
    }
  }
}
