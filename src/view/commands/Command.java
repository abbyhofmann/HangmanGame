package view.commands;

import java.awt.*;

/**
 * Represents the interface for the command objects for visualizing the various body parts of the
 * hangman. These command objects are used to display the various body parts of a hangman in the
 * game.
 */
public interface Command {

  /**
   * Each subclass of this interface has an execute method, which calls the corresponding method
   * of the given graphics object to display the command object.
   * @param g The graphics object needed to draw.
   */
  void execute(Graphics g);
}
