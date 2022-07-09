import org.junit.Before;
import org.junit.Test;

import model.HangmanImpl;

import static org.junit.Assert.*;

public class HangmanImplTest {

  HangmanImpl cookie;

  @Before
  public void initConditions() {
    cookie = new HangmanImpl("cookie");
  }

  @Test
  public void testUpdateState() {
    this.cookie.updateState("c");
    this.cookie.updateState("j");
    this.cookie.updateState("v");
    this.cookie.updateState("o");
    this.cookie.updateState("k");
    this.cookie.updateState("i");
    this.cookie.updateState("e");
    this.cookie.updateState("o");
    this.cookie.updateState("a");
    this.cookie.updateState("b");
    this.cookie.updateState("d");
    this.cookie.updateState("f");
    this.cookie.updateState("g");
    this.cookie.updateState("h");
    try {
      this.cookie.updateState("u");
      fail("no exception caught");
    } catch (IllegalStateException e) {
      assertEquals("Game is over when remainingGuesses is 0", e.getMessage());
    }
  }

}