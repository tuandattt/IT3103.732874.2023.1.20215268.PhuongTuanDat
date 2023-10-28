package Lab_01;
import  java.util.Scanner;
public class InputFromKeyboard {
    public static void main (String[] args){
        Scanner keyboard = new Scanner(System.in); //tao bien de nhap tu ban phim

        System.out.println("What's your name?");
        String strName = keyboard.nextLine(); //nhap tu ban phim
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you (m)?");
        double dHeight = keyboard.nextDouble(); //nhap tu ban phim

        //In ket qua
        System.out.println("Mrs/Mr" + strName + "," + iAge + " years old. " + "Your height is " +dHeight + ".   ");
    }
}
