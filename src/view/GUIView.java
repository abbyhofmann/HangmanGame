package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * The implementation of the GUIViewInterface for this hangman game. In this implementation, the
 * user is prompted to type in the word to be guessed. Then, a new window will pop up with an area
 * for the hangman to be displayed, as well as an area where the guessed letters will be displayed.
 * The word being guessed is initially shown as a series of underscores, but this is updated as the
 * user makes guesses with the dropdown menu of the alphabet. There is also a button where the user
 * can begin a new game. This view simply displays information from the model that is provided from
 * the controller.
 */
public class GUIView extends JFrame implements GUIViewInterface {

  private final JPanel mainPanel;
  private final Man hangmanPanel;
  private final JPanel guessPanel;
  private final JComboBox<String> guessDropdown;
  private final JButton guessButton;
  private final JLabel visualizeWord;
  private final JButton newGameButton;
  private final JLabel guessedLetters;

  /**
   * Constructs a new GUIView object, which is displayed as a 500 by 600 window with all the
   * necessary components for game play.
   */
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
    for (String option : options) {
      guessDropdown.addItem(option);
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

  /**
   * Makes the game visible so the user can see the display.
   */
  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  /**
   * Adds an action listener for the guess button of the GUI view.
   *
   * @param actionEvent The action event - ie the button being pressed.
   */
  @Override
  public void setGuessButtonListener(ActionListener actionEvent) {
    this.guessButton.addActionListener(actionEvent);
  }

  /**
   * Adds an action listener for the new game button.
   *
   * @param actionEvent The action event - ie the button being pressed.
   */
  @Override
  public void setNewGameButtonListener(ActionListener actionEvent) {
    this.newGameButton.addActionListener(actionEvent);
  }

  /**
   * Gets the dropdown menu that contains every letter for the alphabet. This method is used to
   * get the letter that was selected by the user in making a guess.
   *
   * @return Returns the dropdown menu.
   */
  @Override
  public JComboBox<String> getGuessDropdown() {
    return this.guessDropdown;
  }

  /**
   * Displays the user's state of the word to be guessed. Initially, the word to be guessed is
   * displayed as a series of underscores (per model representation), but this is updated as the
   * user makes correct letter guesses.
   *
   * @param word The user's state of the word being guessed.
   */
  @Override
  public void setDisplayedWord(String word) {
    visualizeWord.setText(word);
    visualizeWord.setFont(new Font("Serif", Font.BOLD, 30));
  }

  /**
   * Displays a message for the user in the form of a pop-up box. This method is used when a game
   * has been either won or lost.
   *
   * @param message The message to display to the user.
   */
  @Override
  public void renderMessage(String message) {
    JOptionPane.showMessageDialog(null, message, "Game Over",
            JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Displays the hangman as the user makes correct and incorrect guesses.
   *
   * @param guessesRemaining The number of guesses the user has left before the game is over.
   */
  @Override
  public void displayMan(int guessesRemaining) {
    hangmanPanel.setRemainingGuesses(guessesRemaining);
    this.repaint();
  }

  /**
   * Displays the initial pop-up text input box, which allows the user to input the word that is
   * to be guessed in the game.
   *
   * @return Returns the word the user inputted into the text field.
   */
  @Override
  public String start() {
    return JOptionPane.showInputDialog(null, "Enter the word being guessed.");
  }

  /**
   * Displays the letters the user has guessed so far, without duplicates.
   *
   * @param letters A list of the letters the user has guessed so far.
   */
  @Override
  public void displayGuessedLetters(ArrayList<String> letters) {
    StringBuilder builder = new StringBuilder();
    for (String letter : letters) {
      builder.append(letter).append(" ");
    }
    String allLetters = builder.toString();
    guessedLetters.setText(allLetters);
    visualizeWord.setFont(new Font("Serif", Font.BOLD, 30));
  }


}
