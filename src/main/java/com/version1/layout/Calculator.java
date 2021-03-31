package com.version1.layout;

import java.util.Scanner;
import java.math.BigDecimal;

public class Calculator {
    BigDecimal value1 = null;
    BigDecimal value2 = null;
    String Operation = null;
    Util util = new Util();

    public String getValue1() {
        return value1.toString();
    }

    public void setValue1(String value1) {
        this.value1 = new BigDecimal(value1);
    }

    public String getValue2() {
        return value2.toString();
    }

    public void setValue2(String value2) {
        this.value2 = new BigDecimal(value2);
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }

    public BigDecimal add(String x, String y){
        BigDecimal first = new BigDecimal(x);
        BigDecimal second = new BigDecimal(y);
        BigDecimal result = first.add(second);
        return result;
    }

    public BigDecimal subtraction (String x, String y){
        BigDecimal first = new BigDecimal(x);
        BigDecimal second = new BigDecimal(y);
        BigDecimal result = first.subtract(second);
        return result;
    }
    public BigDecimal multiplication (String x, String y){
        BigDecimal first = new BigDecimal(x);
        BigDecimal second = new BigDecimal(y);
        BigDecimal result = first.multiply(second);
        return result;

    }
    public BigDecimal division (String x, String y){
        if (Double.parseDouble(y)==0.0d){
            System.out.println("division by zero!!!");
            throw new ArithmeticException();
           // return -1;
        }else {
            BigDecimal first = new BigDecimal(x);
            BigDecimal second = new BigDecimal(y);
            BigDecimal result = first.divide(second);
            return result;
        }
    }


    public void executeInteractively() {
        System.out.println("Enter your operation ( 2 + 2 ) :");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        for (int i = 0; i < parts.length ; i++) {
            if (util.isNumeric(parts[i]) && getValue1() == null) {
                setValue1( parts[i]);
            } else if (util.isNumeric(parts[i]) && getValue2() == null)  {
                setValue2(parts[i]);
            } else if (util.isOperation(parts[i])){
                setOperation( parts[i]);
            }
        }

        if (getValue1() == null || getValue2() == null || getOperation() == null  ) {
             System.out.println("Please provide a operation with two numbers");
        }

    }



    public Calculator() {
    }
}
