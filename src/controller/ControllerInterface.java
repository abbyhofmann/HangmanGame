package controller;

/**
 * The controller interface for the hangman game. The functions have been designed to give control
 * to the controller, allowing a hangman game to be played as the controller processes input from
 * a user.
 */
public interface ControllerInterface {

  /**
   * Start the program, i.e. give control to the controller so a game can be playec.
   */
  void play();

}
