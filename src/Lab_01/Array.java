package Lab_01;
import java.util.Arrays;
import java.util.Scanner;
public class Array {
    public static void main(String[] args){
        double []a = new double[]{1789, 2035, 1899, 1456, 2013};
        double sum = 0;
        for(double number: a){
            sum += number;
        }
        double average = sum / a.length;
        Arrays.sort(a);
        System.out.println("Array after sort: ");
        System.out.println(Arrays.toString(a));

        System.out.println("Sum of this array: ");
        System.out.println(sum);

        System.out.println("Average of this array: ");
        System.out.println(average);
    }
}
