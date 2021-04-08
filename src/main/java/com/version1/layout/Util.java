package com.version1.layout;

public class Util {

    public enum Operation {
        ADD,
        SUB,
        MUL,
        DIV
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
