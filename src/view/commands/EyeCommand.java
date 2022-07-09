package view.commands;

import java.awt.*;

public class EyeCommand implements Command {

  private int x;
  private int y;
  private int width;
  private int height;
  private int x2;
  private int y2;
  private int width2;
  private int height2;

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

  @Override
  public void execute(Graphics g) {
    g.drawOval(this.x, this.y, this.width, this.height);
    g.drawOval(this.x2, this.y2, this.width2, this.height2);
  }
}
