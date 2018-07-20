import java.io.BufferedReader;
import java.util.Scanner;

public class ReadInput implements Runnable {
Boolean input=true;

    public void run(){
        Scanner sc = new Scanner(System.in);
System.out.println("Press Q to quit");


        while(input){
int x= sc.nextInt();

if (x==1) {
    input = false;
System.out.println("Thread Terminated");
}



        }
    }
}
