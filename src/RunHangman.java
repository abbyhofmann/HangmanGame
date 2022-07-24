import controller.ControllerInterface;
import controller.GUIController;
import view.GUIView;
import view.GUIViewInterface;

/**
 * Class containing the main method that allows the program to be run.
 */
public class RunHangman {

  /**
   * Runs a new game of hangman by providing a new GUIView to a new GUIController.
   *
   * @param args
   */
  public static void main(String[] args) {
    GUIViewInterface view = new GUIView();
    ControllerInterface controller = new GUIController(view);
    controller.play();
  }

}
