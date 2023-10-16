package Lab_01;
import java.util.Scanner;
public class AddMatrix {
    public static void print(int [][]matrix){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int [][]matrix1 = new int[3][3];
        int [][]matrix2 = new int[3][3];
        int [][]matrix3 = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                matrix1[i][j] = i + j;
                matrix2[i][j] = i - j;
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("Matrix 1: ");
        print(matrix1);

        System.out.println("Matrix 2: ");
        print(matrix2);

        System.out.println("Matrix 3: ");
        print(matrix3);

    }
}
