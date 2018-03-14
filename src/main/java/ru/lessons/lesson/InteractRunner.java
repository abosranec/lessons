package ru.lessons.lesson;

import java.util.Scanner;

/**
 * Created by VitAl on 13.03.2018.
 */
public class InteractRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Calculator calculator = new Calculator();
            String exit = "no";
            while(!exit.equals("yes")) {
                System.out.println("Enter first arg: ");
                String first = scanner.next();
                System.out.println("Enter second arg: ");
                String second = scanner.next();
                try {
                    calculator.div(Double.valueOf(first), Double.valueOf(second));
                    System.out.println("Result : " + calculator.getResult());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                calculator.cleanResult();
                System.out.println("Exit: yes/no ?");
                exit = scanner.next();
            }
        } finally {
            scanner.close();
        }
    }
}
