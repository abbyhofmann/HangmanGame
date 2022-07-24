package controller;

import model.HangmanImpl;
import model.HangmanInterface;
import view.GUIViewInterface;

/**
 * This class represents one implementation of the ControllerInterface to be used with a GUI view.
 * Here, the controller uses a given GUIViewInterface object and initializes a new HangmanInterface
 * object as the model (based on supplied user String input for the word to be guessed). This
 * controller acts as a liaison between the model and the view, providing the view with information
 * from the model to correctly display information. In this way, the view does not directly rely on
 * a model and instead uses the controller as its source of information.
 */
public class GUIController implements ControllerInterface {

  private HangmanInterface model;
  private GUIViewInterface view;

  /**
   * Constructs a new GUIController object given a GUIViewInterface object. The given object serves
   * as the view, while the model is initialized as a new HangmanImpl object with a String user
   * input as the word to be guessed in the hangman game.
   *
   * @param v The view for displaying information from the model.
   */
  public GUIController(GUIViewInterface v) {
    this.view = v;
    try {
      this.model = new HangmanImpl(this.view.start());
    } catch (IllegalArgumentException e) {
      System.exit(0);
    }
  }

  @Override
  public void play() {
    this.view.makeVisible();
    this.view.setDisplayedWord(model.wordGuessedSoFar());
    this.view.setGuessButtonListener(new GuessButtonListener(model, view));
    this.view.setNewGameButtonListener(new NewGameButtonListener(model, view));
  }
}
