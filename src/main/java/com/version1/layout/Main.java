package com.version1.layout;

import java.math.BigDecimal;


public class Main {


    public static Calculator startCalc(String[] parts){
        Util util = new Util();
        Calculator cal = new Calculator();

        String number1 = null;
        String number2 = null;
        for (String part : parts) {
            if (Util.isNumeric(part)) {

                if (number1 == null) {
                    number1 = new String(part);
                } else if (number2 == null) {
                    number2 = new String(part);
                }

            } else if (util.isOperation(part) != null) {
                cal.setOperation(util.isOperation(part));
            }
        }

        if (((number1 != null ? number1.length() : 0) == 0) || ((number2 != null ? number2.length() : 0) == 0) || cal.getOperation() == null  ) {
            System.out.println("Please provide a operation with two numbers");
        } else {
            cal.setValue1(cal.convertBigDecimal(number1));
            cal.setValue2(cal.convertBigDecimal(number2));
            return cal;
        }
        return null;
    }
    public static void calPrompt(){
        BigDecimal result = new BigDecimal("0.0");
        Calculator cal_Prompt = new Calculator();
        cal_Prompt = startCalc(Util.get_prompt() );
        result = cal_Prompt.calculator();
        System.out.println("Prompt result is: "+result);
    }
    public static void calFiles(){
        BigDecimal result = new BigDecimal("0.0");
        Calculator cal_File = new Calculator();
        String [] file = Util.get_file();
        String [] fileCurrent = new String[3];
        fileCurrent[0] = file[0];
        fileCurrent[1] = file[1];
        fileCurrent[2] = file[2];
        cal_File = startCalc(fileCurrent);
        result = cal_File.calculator();
        if (file.length > 3){
            for (int i=3; i < file.length;i++){
                fileCurrent[0] = file[0];
                fileCurrent[1] = result.toString();
                fileCurrent[2] = file[i];
                cal_File = startCalc(fileCurrent);
                result = cal_File.calculator();
            }
        }
        System.out.println("File result is: "+result);
    }


    public static void main(String[] args) {

        calPrompt();
        calFiles();
    }


}
