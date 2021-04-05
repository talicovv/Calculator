package com.version1.layout;

import java.util.Scanner;
import java.math.BigDecimal;


/**
 * will calculate the operation
 *
 */
public class Calculator {


    BigDecimal value1 = null;
    BigDecimal value2 = null;
    String Operation = null;
    Util util = new Util();

    public BigDecimal getValue1() {
        return this.value1;
    }

    public void setValue1(BigDecimal value1) {
        this.value1 = value1;
    }

    public BigDecimal getValue2() {
        return this.value2;
    }

    public void setValue2(BigDecimal value2) {
        this.value2 = value2;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }

    public BigDecimal convertBigDecimal(String value){
        try {
            BigDecimal number = new BigDecimal(value);
            return number;
        }catch (NumberFormatException e){
            System.out.println("Error it is not number!");
            return null;
        }

    }

    /**
     *  Method to addition values to the result
     * @param x first value to add to the result
     * @param y second value to add to the result
     * @return will return the result adding x and y.
     */
    public BigDecimal add(BigDecimal x, BigDecimal y){

        BigDecimal result = x.add(y);
        return result;
    }

    public BigDecimal subtraction (BigDecimal x, BigDecimal y){

        BigDecimal result = x.subtract(y);
        return result;
    }
    public BigDecimal multiplication (BigDecimal x, BigDecimal y){
        BigDecimal result = x.multiply(y);
        return result;

    }
    public BigDecimal division (BigDecimal x, BigDecimal y){
        if (y.compareTo(BigDecimal.ZERO) == 0){
            System.out.println("division by zero!!!");
            throw new ArithmeticException();
           // return -1;
        }else {
            BigDecimal result = x.divide(y);
            return result;
        }
    }


    public Calculator() {
    }
}
