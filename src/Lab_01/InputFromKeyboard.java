package Lab_01;
import  java.util.Scanner;
public class InputFromKeyboard {
    public static void main (String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What's your name?");
        String strName = keyboard.nextLine();
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you (m)?");
        double dHeight = keyboard.nextDouble();

        //similar to other data type
        //nextByte(), nextShort(), nextLong(), nextFloat(), nextBoolean()

        System.out.println("Mrs/Mr" + strName + "," + iAge + " years old. " + "Your height is " +dHeight + ".   ");
    }
}
