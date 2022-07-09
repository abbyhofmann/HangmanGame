package controller;

import model.HangmanImpl;
import model.HangmanInterface;
import view.GUIViewInterface;

public class GUIController implements ControllerInterface {

  private HangmanInterface model;
  private GUIViewInterface view;

  public GUIController( GUIViewInterface v) {
    this.view = v;
    this.model = new HangmanImpl(this.view.start());
  }

  @Override
  public void play() {
    this.view.makeVisible();
    this.view.setDisplayedWord(model.wordGuessedSoFar());
    this.view.setGuessButtonListener(new GuessButtonListener(model, view));
    this.view.setNewGameButtonListener(new NewGameButtonListener(model, view));
  }
}
