import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.font.FontRenderContext;
import java.util.Scanner;

public class Basic_Auto_Click {

    public static volatile boolean flag=true;
Robot robot = new Robot();
int xCord1, yCord1;
int seconds,milliseconds;
int loopcount= 5;// remove this later, used for testing purposes
    //2500,860

    public static void main(String[] args) throws AWTException{
       // new Thread(new ReadInput()).start();
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

      Thread inputThread= new Thread( new ReadInput());
      inputThread.start();
       while(flag){
            leftClick();
            robot.delay(60);
            leftClick();
            robot.delay(totalMs);
        }

System.out.println("We made it out alive!");



    }



    public void leftClick(){


    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(200);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(200);


    }



    class ReadInput implements Runnable {

        public void run(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Press Q to quit");


            while(Basic_Auto_Click.flag){
            System.out.println("in loop");
             String x= sc.next().toString().toLowerCase();
                System.out.println(x);
                if (x.equals("q")) {
                   Basic_Auto_Click.flag=false;
                    System.out.println("Thread Terminated");
                }



            }
        }
    }

}
