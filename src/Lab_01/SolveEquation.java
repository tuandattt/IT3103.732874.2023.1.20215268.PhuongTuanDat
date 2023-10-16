package Lab_01;
//Example 7: SolveEquation.java4

import java.util.Scanner;
public class SolveEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the type of equation to solve:");
        System.out.println("1. First-degree equation with one variable");
        System.out.println("2. System of first-degree equations with two variables");
        System.out.println("3. Second-degree equation with one variable");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the value of a: ");
                double a = scanner.nextDouble();
                System.out.print("Enter the value of b: ");
                double b = scanner.nextDouble();
                solveLinearEquation(a, b);
                break;
            case 2:
                System.out.print("Enter the value of a11: ");
                double a11 = scanner.nextDouble();
                System.out.print("Enter the value of a12: ");
                double a12 = scanner.nextDouble();
                System.out.print("Enter the value of b1: ");
                double b1 = scanner.nextDouble();
                System.out.print("Enter the value of a21: ");
                double a21 = scanner.nextDouble();
                System.out.print("Enter the value of a22: ");
                double a22 = scanner.nextDouble();
                System.out.print("Enter the value of b2: ");
                double b2 = scanner.nextDouble();
                solveLinearSystem(a11, a12, b1, a21, a22, b2);
                break;
            case 3:
                System.out.print("Enter the value of a: ");
                double quadraticA = scanner.nextDouble();
                System.out.print("Enter the value of b: ");
                double quadraticB = scanner.nextDouble();
                System.out.print("Enter the value of c: ");
                double quadraticC = scanner.nextDouble();
                solveQuadraticEquation(quadraticA, quadraticB, quadraticC);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void solveLinearEquation(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinite solutions");
            } else {
                System.out.println("No solution");
            }
        } else {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        }
    }

    public static void solveLinearSystem(double a11, double a12, double b1, double a21, double a22, double b2) {
        double determinant = a11 * a22 - a21 * a12;
        if (determinant == 0) {
            if ((b1 * a22 - b2 * a12) == 0) {
                System.out.println("Infinite solutions");
            } else {
                System.out.println("No solution");
            }
        } else {
            double x1 = (b1 * a22 - b2 * a12) / determinant;
            double x2 = (a11 * b2 - a21 * b1) / determinant;
            System.out.println("The solutions are x1 = " + x1 + ", x2 = " + x2);
        }
    }

    public static void solveQuadraticEquation(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The solutions are real and distinct: x1 = " + root1 + ", x2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("The solution is a double root: x = " + root);
        } else {
            System.out.println("No real roots");
        }
    }
}

