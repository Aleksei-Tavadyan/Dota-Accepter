import java.awt.*;
import java.awt.event.InputEvent;

import static java.awt.event.InputEvent.BUTTON1_MASK;
import static java.awt.event.InputEvent.BUTTON2_MASK;

public class Clicker {


    public static void moveMouse() throws AWTException {
        Robot robot = new Robot();
        robot.delay(1000);
        robot.mouseMove(850,500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}