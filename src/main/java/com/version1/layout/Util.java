package com.version1.layout;

public class Util {

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

    public boolean isOperation(String part) {
        String base = "+-/*" ;
        String[] op = base.split("");
        for (int i=0; i< op.length ; i++ ) {
            if (op[i].equals( part))
                return true;
        }
        return false;
    }
}
