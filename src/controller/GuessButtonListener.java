package controller;

import java.awt.event.ActionEvent;

import javax.swing.*;

import model.HangmanInterface;
import view.GUIViewInterface;

/**
 * This represents the ActionListener for the guess button component of the view. It functions as
 * part of the controller by communicating between the view and the model based on user input and
 * information needing to be transferred between the two. When the actionPerformed method is
 * invoked (i.e. the guess button is pressed), the updateState method from the model is called and
 * the view and model are updated accordingly.
 */
public class GuessButtonListener extends AbstractButtonListener {

  /**
   * Constructs a new GuessButtonListener object given a HangmanInterface for the model and a
   * GUIViewInterface for the view. In this implementation, a GuessButtonListener is initialized
   * in the play method of GUIController, so the model and view will be the same as those
   * initialized in GUIController.
   *
   * @param m HangmanInterface representing a model.
   * @param v GUIViewInterface representing a view.
   * @throws IllegalArgumentException Exception thrown if given model or view are null.
   */
  public GuessButtonListener(HangmanInterface m, GUIViewInterface v)
          throws IllegalArgumentException {
    super(m, v);
  }

  /**
   * When the guess button is pressed, the model state is updated via the updateState method in the
   * model, and the view is updated to display the proper word, hangman, and guessed letters.
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    JComboBox<String> dropdown = view.getGuessDropdown();
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
