package additionalHomework;

import java.util.Scanner;

public class JavaTask2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int n = scanner.nextInt();
        int factorial = 1;
        int i = 1;

        while (i <= n) {
            factorial *= i;
            i++;
        }
        System.out.println(factorial);
    }
}
