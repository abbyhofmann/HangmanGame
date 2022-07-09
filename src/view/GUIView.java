package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class GUIView extends JFrame implements GUIViewInterface {

  private JPanel mainPanel;
  private Man hangmanPanel;
  private JPanel guessPanel;
  private JComboBox<String> guessDropdown;
  private JButton guessButton;
  private JLabel visualizeWord;
  private JButton newGameButton;
  private JLabel guessedLetters;

  public GUIView() {
    super();
    this.setTitle("Image Processor");
    this.setSize(500, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    this.add(mainPanel);

    hangmanPanel = new Man();
    hangmanPanel.setBorder(BorderFactory.createTitledBorder("Stick Figure"));
    hangmanPanel.setPreferredSize(new Dimension(500, 350));
    mainPanel.add(hangmanPanel);

    visualizeWord = new JLabel();
    mainPanel.add(visualizeWord);

    guessPanel = new JPanel();
    guessPanel.setLayout(new FlowLayout());
    guessDropdown = new JComboBox<>();
    String[] options = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    for (int i = 0; i < options.length; i++) {
      guessDropdown.addItem(options[i]);
    }
    guessPanel.add(guessDropdown);
    guessButton = new JButton("Guess");
    guessPanel.add(guessButton);
    mainPanel.add(guessPanel);

    guessedLetters = new JLabel();
    mainPanel.add(guessedLetters);

    newGameButton = new JButton("New Game");
    mainPanel.add(newGameButton);

  }

  public void makeVisible() { //TODO add to interface?
    this.setVisible(true);
  }

  @Override
  public void setGuessButtonListener(ActionListener actionEvent) {
    this.guessButton.addActionListener(actionEvent);
  }

  @Override
  public void setNewGameButtonListener(ActionListener actionEvent) {
    this.newGameButton.addActionListener(actionEvent);
  }

  @Override
  public JComboBox getGuessDropdown() {
    return this.guessDropdown;
  }

  @Override
  public void setDisplayedWord(String word) {
    visualizeWord.setText(word);
    visualizeWord.setFont(new Font("Serif", Font.BOLD, 30));
  }

  @Override
  public void renderMessage(String message) {
    JOptionPane.showMessageDialog(null, message, "Game Over",
            JOptionPane.INFORMATION_MESSAGE);
  }

  @Override
  public void displayMan(int guessesRemaining) {
    hangmanPanel.setRemainingGuesses(guessesRemaining);
    this.repaint();
  }

  @Override
  public String start() {
    return JOptionPane.showInputDialog(null, "Enter the word being guessed.");
  }

  @Override
  public void displayGuessedLetters(ArrayList<String> letters) {
    StringBuilder builder = new StringBuilder();
    for (String letter : letters) {
      builder.append(letter + " ");
    }
    String allLetters = builder.toString();
    guessedLetters.setText(allLetters);
    visualizeWord.setFont(new Font("Serif", Font.BOLD, 30));
  }


}


/*
TODO:
- display the letters the user has guessed
 */