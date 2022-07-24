package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.HangmanInterface;
import view.GUIViewInterface;

/**
 * Represents an abstract class for the button listeners of this program. An object of a class
 * extending this class will communicate between a given model and view to perform a specific action
 * when a button is pressed.
 */
public abstract class AbstractButtonListener implements ActionListener {

  protected HangmanInterface model;
  protected GUIViewInterface view;

  /**
   * Constructs an AbstractButtonListener object based on a given model and view. The model and/or
   * view cannot be null. The subclasses that extend this class can utilize this constructor when
   * being initialized.
   *
   * @param m The model storing information for the view to display.
   * @param v The view that displays information from the model.
   * @throws IllegalArgumentException Exception thrown when parameter is null.
   */
  public AbstractButtonListener(HangmanInterface m, GUIViewInterface v)
          throws IllegalArgumentException {
    if (m == null || v == null) {
      throw new IllegalArgumentException("Parameters cannot be null");
    }
    this.model = m;
    this.view = v;
  }

  /**
   * When a button is pressed, this method is called. Based on the implementation of each subclass
   * of this abstract class, this method determines what happens when the button is pressed.
   * @param e the event to be processed
   */
  @Override
  public abstract void actionPerformed(ActionEvent e);

}
