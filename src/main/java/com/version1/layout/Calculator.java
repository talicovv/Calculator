package com.version1.layout;

import lombok.Data;
import java.math.BigDecimal;
import java.math.RoundingMode;



/**
 * will calculate the operation
 *
 */
public @Data class Calculator {


    BigDecimal value1 = null;
    BigDecimal value2 = null;
    Util.Operation Operation = null;


    public BigDecimal convertBigDecimal(String value){
        try {
            return new BigDecimal(value);
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

        return x.add(y);
    }

    public BigDecimal subtraction (BigDecimal x, BigDecimal y){

        return x.subtract(y);
    }
    public BigDecimal multiplication (BigDecimal x, BigDecimal y){
        return x.multiply(y);

    }
    public BigDecimal division (BigDecimal x, BigDecimal y){
        if (y.compareTo(BigDecimal.ZERO) == 0){
            System.out.println("division by zero!!!");
            throw new ArithmeticException();
           // return -1;
        }else {
            return x.divide(y, 2, RoundingMode.HALF_UP);
        }
    }


    public Calculator() {
    }
}
