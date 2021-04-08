package com.version1.layout;


import java.math.BigDecimal;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Util util = new Util();
        BigDecimal result = new BigDecimal("0.0");

        System.out.println("Enter your operation ( 2 + 2 ) :");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split("");
        boolean before = false;
        StringBuilder number1 = null;
        StringBuilder number2 = null;
        for (String part : parts) {
            if (Util.isNumeric(part)) {
                if (!before) {
                    if (number1 == null) {
                        number1 = new StringBuilder(part);
                        before = true;
                    } else if (number2 == null) {
                        number2 = new StringBuilder(part);
                        before = true;
                    }
                } else {
                    if ( number2 != null) {
                        number2.append(part);
                    } else {
                        number1.append(part);
                    }
                }

            } else {
                before = false;
                if (util.isOperation(part) != null) {
                    cal.setOperation(util.isOperation(part));
                }
            }

        }

        if (((number1 != null ? number1.length() : 0) == 0) || ((number2 != null ? number2.length() : 0) == 0) || cal.getOperation() == null  ) {
            System.out.println("Please provide a operation with two numbers");
        } else {
            cal.setValue1(cal.convertBigDecimal(number1.toString()));
            cal.setValue2(cal.convertBigDecimal(number2.toString()));
            switch (cal.getOperation()){
                case ADD:
                    result = cal.add(cal.getValue1(),cal.getValue2());
                    break;
                case SUB:
                    result = cal.subtraction(cal.getValue1(),cal.getValue2());
                    break;
                case MUL:
                    result = cal.multiplication(cal.getValue1(),cal.getValue2());
                    break;
                case DIV:
                    result = cal.division(cal.getValue1(),cal.getValue2());
                    break;
            }
            if (result != null) {
                String output = String.format("Result is %.2f ", result);
                System.out.println(output);
            }
        }

    }


}
