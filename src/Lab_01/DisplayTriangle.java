package Lab_01;
import java.util.Scanner;
public class DisplayTriangle {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hãy nhập số n");
        int n = keyboard.nextInt();
        int m = 1;
        for(int i = 0; i < n; i ++){
            for(int k = 0; k < n - i ; k++){
                System.out.print(" ");
            }
            for(int j = 0; j < m; j++){
                System.out.print("*");
            }
            System.out.print("\n");
            m += 2;
        }
    }
}
