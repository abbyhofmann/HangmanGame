package view;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import view.commands.Command;
import view.commands.EyeCommand;
import view.commands.LineCommand;
import view.commands.OvalCommand;

public class Man extends JPanel {

  private int remainingGuesses;

  public Man() {
    this.remainingGuesses = 8;
  }

  public void setRemainingGuesses(int num) {
    this.remainingGuesses = num;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);

    Map<Integer, Command> commands;
    commands = new HashMap();
    commands.put(8, new OvalCommand(238, 80, 20, 10));
    commands.put(7, new EyeCommand(238, 65, 5, 5, 250, 65, 5, 5));
    commands.put(6, new LineCommand(250, 250, 295, 300));
    commands.put(5, new LineCommand(205, 300, 250, 250));
    commands.put(4, new LineCommand(250, 155, 290, 200));
    commands.put(3, new LineCommand(210, 200, 250, 155));
    commands.put(2, new OvalCommand(225, 50, 50, 50)); // TODO: initialize outside of method so it doesn't have to do it each time
    commands.put(1, new LineCommand(250 , 100, 250,  250));


    for (int i = 1; i <= 8 - this.remainingGuesses; i ++) {

      Command cmd = commands.get(i);
      cmd.execute(g2d);

    }


//    //body
//    g2d.drawLine(250 , 100, 250,  250);
//    //head
//    g2d.drawOval(225, 50, 50, 50);
//    //left arm
//    g2d.drawLine(210, 200, 250, 155);
//    //right arm
//    g2d.drawLine(250, 155, 290, 200);
//    //left leg
//    g2d.drawLine(205, 300, 250, 250);
//    //right leg
//    g2d.drawLine(250, 250, 295, 300);
//    //eyes
//    g2d.drawOval(238, 65, 5, 5);
//    g2d.drawOval(250, 65, 5, 5);
//    //mouth
//    g2d.drawOval(238, 80, 20, 10);

  }
}
