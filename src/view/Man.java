package view;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import view.commands.Command;
import view.commands.EyeCommand;
import view.commands.LineCommand;
import view.commands.OvalCommand;

/**
 * This class is a part of the view and serves to display the hangman figure of the game. The
 * hangman figure that is displayed relies upon the number of remaining guesses the user has. As
 * incorrect guesses are made and the remaining guesses decreases, additional limbs are displayed
 * through this panel.
 */
public class Man extends JPanel {

  private int remainingGuesses;

  /**
   * Constructs a new Man object, where the remainingGuesses are initialized as 8.
   */
  public Man() {
    this.remainingGuesses = 9;
  }

  /**
   * Sets the remainingGuesses of a Man object to the integer value provided. This allows the figure
   * displayed to be updated.
   *
   * @param num The number of remaining guesses.
   */
  public void setRemainingGuesses(int num) {
    this.remainingGuesses = num;
  }

  /**
   * Displays the hangman figure using a graphics component, which allows for ovals and lines to be
   * drawn. There are 8 different body parts that can be displayed, represented as command objects
   * and stored in a HashMap that corresponds the remaining guesses to the body parts that should
   * be displayed.
   *
   * @param g the <code>Graphics</code> object to protect
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);

    Map<Integer, Command> commands;
    commands = new HashMap<>();
    commands.put(8, new OvalCommand(238, 80, 20, 10));
    commands.put(7, new EyeCommand(238, 65, 5, 5, 250, 65, 5, 5));
    commands.put(6, new LineCommand(250, 250, 295, 300));
    commands.put(5, new LineCommand(205, 300, 250, 250));
    commands.put(4, new LineCommand(250, 155, 290, 200));
    commands.put(3, new LineCommand(210, 200, 250, 155));
    commands.put(2, new OvalCommand(225, 50, 50, 50));
    commands.put(1, new LineCommand(250, 100, 250, 250));


    for (int i = 1; i <= 9 - this.remainingGuesses; i++) {

      Command cmd = commands.get(i);
      cmd.execute(g2d);

    }
  }

}
