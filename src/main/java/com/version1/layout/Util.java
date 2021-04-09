package com.version1.layout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Util {

    static final String COMMA_DELIMITER = ",";
    public enum Operation {
        ADD,
        SUB,
        MUL,
        DIV
    }

    public static String[] get_prompt(){

        System.out.println("Enter your operation ( 2 + 2 ) :");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        return userInput.split("");

    }

    public static String[] get_file() {
        String[] values = new String[0];

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\file.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                values = line.split(COMMA_DELIMITER);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return values;

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            if (strNum.equals(".")){
                return true;
            }
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public Operation isOperation(String part) {
        Operation result;
        switch (part){
            case "+":
                result = Operation.ADD;
                break;
            case "-":
                result = Operation.SUB;
                break;
            case "/":
                result = Operation.DIV;
                break;
            case "*":
                result = Operation.MUL;
                break;
            default:
                result = null;
                break;
        }
        return result;
    }
}
