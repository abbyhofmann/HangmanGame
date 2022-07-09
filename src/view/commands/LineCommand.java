package view.commands;

import java.awt.*;

public class LineCommand implements Command {
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public LineCommand(int int1, int int2, int int3, int int4) {
    this.x1 = int1;
    this.y1 = int2;
    this.x2 = int3;
    this.y2 = int4;
  }

  @Override
  public void execute(Graphics g) {
    g.drawLine(this.x1 , this.y1, this.x2,  this.y2);
  }
}
