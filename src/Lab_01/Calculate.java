package Lab_01;
//Example 6: Calculate.java4
import javax.swing.JOptionPane;
public class Calculate {
    public static void main(String[] args){
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number:", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number:", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num1  = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble((strNum2));
        double sum = num1 + num2;
        double diff = num1 - num2;
        double product = num1 * num2;
        System.out.println(sum);
        System.out.println(diff);
        System.out.println(product);
        if(num1 == 0 && num2 != 0){
            System.out.println(0);
        }else if(num2 == 0 && num1 != 0){
            System.out.println(0);
        }else if(num1 == 0 && num2 == 0){
            System.out.println("Error! The quotidien does not exist");
        }else{
            double a = num1/num2;
            System.out.println(a);
        }

    }
}
