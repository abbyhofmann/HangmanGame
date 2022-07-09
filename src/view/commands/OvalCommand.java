package view.commands;

import java.awt.*;

public class OvalCommand implements Command {

  private int x;
  private int y;
  private int width;
  private int height;

  public OvalCommand(int int1, int int2, int int3, int int4) {
    this.x = int1;
    this.y = int2;
    this.width = int3;
    this.height = int4;
  }

  @Override
  public void execute(Graphics g) {
    g.drawOval(this.x, this.y, this.width, this.height);
  }
}
