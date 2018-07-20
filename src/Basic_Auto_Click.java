import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.font.FontRenderContext;

public class Basic_Auto_Click {
Robot robot = new Robot();
int xCord1, yCord1;
int seconds,milliseconds;
int loopcount= 5;// remove this later, used for testing purposes
    //2500,860

    public static void main(String[] args) throws AWTException{
        new Thread(new ReadInput()).start();
      new Basic_Auto_Click(2500,860,5,0);
    }
    public Basic_Auto_Click() throws AWTException {
    robot.setAutoDelay(40);
    robot.setAutoWaitForIdle(true);
    robot.delay(4000);
    leftClick();
    robot.delay(2000);
    leftClick();
    }


    public Basic_Auto_Click(int xCord,int yCord1, int seconds, int milliseconds) throws AWTException {
        int totalMs= seconds*1000+milliseconds;
        robot.mouseMove(xCord,yCord1);

        for(int i=0;i<loopcount;i++) {
            leftClick();
            robot.delay(60);
            leftClick();
            robot.delay(totalMs);
        }





    }



    public void leftClick(){


    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(200);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(200);


    }
}
