package view.commands;

import java.awt.*;

/**
 * Represents the command object for drawing a line. In this game, the LineCommand object is used
 * for drawing the arms, legs, and body of the hangman.
 */
public class LineCommand implements Command {
  private final int x1;
  private final int y1;
  private final int x2;
  private final int y2;

  /**
   * Constructs a new LineCommand object by taking in the four necessary integers for drawing with
   * a graphics object.
   *
   * @param int1 x value of where to start the line.
   * @param int2 y value of where to start the line.
   * @param int3 x value of where to end the line.
   * @param int4 y value of where to end the line.
   */
  public LineCommand(int int1, int int2, int int3, int int4) {
    this.x1 = int1;
    this.y1 = int2;
    this.x2 = int3;
    this.y2 = int4;
  }

  /**
   * Draws a line based on the integers of the LineCommand object fields.
   *
   * @param g The graphics object needed to draw.
   */
  @Override
  public void execute(Graphics g) {
    g.drawLine(this.x1, this.y1, this.x2, this.y2);
  }
}
