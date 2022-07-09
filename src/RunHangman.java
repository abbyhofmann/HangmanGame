import controller.ControllerInterface;
import controller.GUIController;
import model.HangmanImpl;
import model.HangmanInterface;
import view.GUIView;
import view.GUIViewInterface;

public class RunHangman {

  public static void main(String[] args) {
    HangmanInterface model = new HangmanImpl("cookie");
    GUIViewInterface view = new GUIView();
    ControllerInterface controller = new GUIController(view);
    controller.play();
  }

}
