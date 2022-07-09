package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.HangmanInterface;
import view.GUIViewInterface;

public class NewGameButtonListener implements ActionListener {

  private HangmanInterface model;
  private GUIViewInterface view;

  public NewGameButtonListener(HangmanInterface m, GUIViewInterface v) {
    this.model = m;
    this.view = v;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.model.reset(this.view.start());
    this.view.setDisplayedWord(this.model.wordGuessedSoFar());
    this.view.displayMan(this.model.getRemainingGuesses());
    this.view.displayGuessedLetters(this.model.getGuessedLetters());
  }
}
