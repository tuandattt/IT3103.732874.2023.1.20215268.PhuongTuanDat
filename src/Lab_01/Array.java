package Lab_01;
import java.util.Arrays;
import java.util.Scanner;
public class Array {
    public static void main(String[] args){
        double []a = new double[]{1789, 2035, 1899, 1456, 2013}; // khởi tạo mảng
        double sum = 0; //khoi tao tong
        for(double number: a){
            sum += number;
        } //ham tinh tong
        double average = sum / a.length; //tinh gia tri trung binh
        Arrays.sort(a); //sap xep mang a

        //In ket qua
        System.out.println("Array after sort: ");
        System.out.println(Arrays.toString(a));

        System.out.println("Sum of this array: ");
        System.out.println(sum);

        System.out.println("Average of this array: ");
        System.out.println(average);
    }
}
