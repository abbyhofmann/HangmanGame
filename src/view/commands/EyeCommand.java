package view.commands;

import java.awt.*;

/**
 * Represents the command object for drawing the eyes of a hangman.
 */
public class EyeCommand implements Command {

  private final int x;
  private final int y;
  private final int width;
  private final int height;
  private final int x2;
  private final int y2;
  private final int width2;
  private final int height2;

  /**
   * Constructs an EyeCommand object given 8 parameters, which are needed for drawing the two ovals.
   *
   * @param int1 x value of left oval.
   * @param int2 y value of left oval.
   * @param int3 width of left oval.
   * @param int4 height of left oval.
   * @param int5 x value of right oval.
   * @param int6 y value of right oval.
   * @param int7 width of right oval.
   * @param int8 height of right oval.
   */
  public EyeCommand(int int1, int int2, int int3, int int4, int int5, int int6, int int7, int int8) {
    this.x = int1;
    this.y = int2;
    this.width = int3;
    this.height = int4;
    this.x2 = int5;
    this.y2 = int6;
    this.width2 = int7;
    this.height2 = int8;
  }

  /**
   * Draws the two ovals.
   *
   * @param g The graphics object needed to draw.
   */
  @Override
  public void execute(Graphics g) {
    g.drawOval(this.x, this.y, this.width, this.height);
    g.drawOval(this.x2, this.y2, this.width2, this.height2);
  }
}
