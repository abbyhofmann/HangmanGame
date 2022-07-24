package controller;

import java.awt.event.ActionEvent;

import model.HangmanInterface;
import view.GUIViewInterface;

/**
 * This represents the ActionListener for the new game button component of the view. It functions as
 * part of the controller by communicating between the view and the model based on user input and
 * information needing to be transferred between the two. When the actionPerformed method is
 * invoked (i.e. the new game button is pressed), the model is reset to allow for a new game to be
 * played based on new user input. The view is then updated accordingly to reflect this new game.
 */
public class NewGameButtonListener extends AbstractButtonListener {

  /**
   * Constructs a new NewGameButtonListener object given a HangmanInterface for the model and a
   * GUIViewInterface for the view. In this implementation, a NewGameButtonListener is initialized
   * in the play method of GUIController, so the model and view will be the same as those
   * initialized in GUIController.
   *
   * @param m HangmanInterface representing a model.
   * @param v GUIViewInterface representing a view.
   * @throws IllegalArgumentException Exception thrown if given model or view are null.
   */
  public NewGameButtonListener(HangmanInterface m, GUIViewInterface v)
          throws IllegalArgumentException {
    super(m, v);
  }

  /**
   * When the new game button is pressed, the reset method of the model is called to set the state
   * of the new game. The view is then updated to display the initial word, hangman, and guessed
   * letters.
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    this.model.reset(this.view.start());
    this.view.setDisplayedWord(this.model.wordGuessedSoFar());
    this.view.displayMan(this.model.getRemainingGuesses());
    this.view.displayGuessedLetters(this.model.getGuessedLetters());
  }
}


