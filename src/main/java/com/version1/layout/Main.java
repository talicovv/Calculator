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
        Boolean before = false;
        String number1 = null;
        String number2 = null;
        for (int i = 0; i < parts.length ; i++) {
            if (util.isNumeric(parts[i])) {
                if (!before){
                   if (number1 ==null){
                       number1 = parts[i];
                       before = true;
                    }else if (number2 == null){
                       number2 = parts[i];
                       before = true;
                   }
                }else {
                    if(number1 != null && number2 != null){
                        number2 = number2 + parts[i];
                    } else {
                        number1 = number1 + parts[i];
                    }
                }

            }else {
                before = false;
                if (util.isOperation(parts[i])){
                    cal.setOperation(parts[i]);
                }
            }

        }

        if (number1.isEmpty() || number2.isEmpty() || cal.getOperation() == null  ) {
            System.out.println("Please provide a operation with two numbers");
        } else {
            cal.setValue1(number1);
            cal.setValue2(number2);
            switch (cal.getOperation()){
                case "+":
                    result = cal.add(cal.getValue1(),cal.getValue2());
                    break;
                case "-":
                    result = cal.subtraction(cal.getValue1(),cal.getValue2());
                    break;
                case "*":
                    result = cal.multiplication(cal.getValue1(),cal.getValue2());
                    break;
                case "/":
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
