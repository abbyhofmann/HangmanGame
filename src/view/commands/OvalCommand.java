package view.commands;

import java.awt.*;

/**
 * Represents the command object for drawing an oval. It this game, the class is used to draw
 * the head of the hangman..
 */
public class OvalCommand implements Command {

  private final int x;
  private final int y;
  private final int width;
  private final int height;

  /**
   * Constructs a new OvalCommand object based on the four integers needed to draw an oval using a
   * graphics object.
   *
   * @param int1 the x value of the oval.
   * @param int2 the y value of the oval.
   * @param int3 the width of the oval.
   * @param int4 the height of the oval.
   */
  public OvalCommand(int int1, int int2, int int3, int int4) {
    this.x = int1;
    this.y = int2;
    this.width = int3;
    this.height = int4;
  }

  /**
   * Draws the oval using the given graphics object.
   *
   * @param g The graphics object needed to draw.
   */
  @Override
  public void execute(Graphics g) {
    g.drawOval(this.x, this.y, this.width, this.height);
  }
}
