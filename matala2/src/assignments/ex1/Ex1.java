package assignments.ex1;

import java.math.BigInteger;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use  Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */


public class Ex1 {
    /*
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */



    public static int number2Int(String num) {
        int ans = -1;

        //isNumeric checks if num contains just a numbers by using regex and if it is, the number will return
        if(isNumeric(num)) return Integer.parseInt(num);

       if (num.indexOf('b') == -1 || num.indexOf('b') == 0) return ans;
        String[] numberAndBaseArr = num.split("b");
        String numberPart = numberAndBaseArr[0];
        String basePart = numberAndBaseArr[1];
        if (numberAndBaseArr[0].isEmpty() || numberAndBaseArr[1].isEmpty()) return ans;


        int base;

        if(isNumeric(basePart)){
            base = Integer.parseInt(basePart);
        } else {
            switch (basePart) {
                case "A":
                    base = 10;
                    break;
                case "B":
                    base = 11;
                    break;
                case "C":
                    base = 12;
                    break;
                case "D":
                    base = 13;
                    break;
                case "E":
                    base = 14;
                    break;
                case "F":
                    base = 15;
                    break;
                case "G":
                    base = 16;
                    break;
                default: return ans;
            }
        }


        if (base < 2 || base > 16) return ans;

        ans = Integer.parseInt(numberPart, base);
        return ans;
    }


//In isNumeric function you enter a string and it returns a Boolean answer whether it contains only digits
    public static boolean isNumeric(String num) {
        boolean ans = false;
        boolean isNumeric = num.matches("\\d+");
        if (isNumeric){
            return true;
        }
        return ans;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true if the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        //isNumeric checks if a contains just a numbers by using regex and if it is, true will return
        if (isNumeric(a)) return true;

        if (a.indexOf('b') == 0) return false;


        String[] numberAndBaseArr = a.split("b");

        if (numberAndBaseArr.length != 2) return false;

        String numberPart = numberAndBaseArr[0];
        String basePart = numberAndBaseArr[1];

        if (numberPart.isEmpty() || basePart.isEmpty()) return false;



        int base;
        if(isNumeric(basePart)){
            base = Integer.parseInt(basePart);
        } else {
            switch (basePart) {
                case "A":
                    base = 10;
                    break;
                case "B":
                    base = 11;
                    break;
                case "C":
                    base = 12;
                    break;
                case "D":
                    base = 13;
                    break;
                case "E":
                    base = 14;
                    break;
                case "F":
                    base = 15;
                    break;
                case "G":
                    base = 16;
                    break;
                default: return false;
            }
        }


        if (base < 2 || base > 16) return false;

        for (int i = 0; i < numberPart.length(); i++) {
            char digit = numberPart.charAt(i);
            int numberValue;

            //Check every numberPart digit by ASCII value
            if (!(Character.isDigit(digit) || (digit >= 'A' && digit <= 'G'))) return false;

            if (Character.isDigit(digit)) {
                numberValue = digit - '0';
            } else {
                numberValue = digit - 'A' + 10;
            }
            if (numberValue >= base) return false;
        }

        return ans;
    }


    /**
     * Calculate the number representation (in basis base) // חשב את ייצוג המספרים
     * of the given natural number (represented as an integer). // של מספר טבעי נתון
     * If num<0 or base is not in [2,16] the function should return "" (the empty String). //
     *
     * @param num  the natural number (include 0). //
     * @param base the basis [2,16] //
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        String strBase = "";
        if (num < 0 || base < 2 || base > 16) return ans;
        if(num == 0) {
            if (base == 10) {
                return "0";
            }else {
                return "0b"+String.valueOf(base);
            }
        }

        //StringBuilder use is for add a char to specific place in a string (dosn't works with String).
        StringBuilder finalNumber = new StringBuilder();

        while (num > 0) {
            int divRem = num % base;
            char digit;

            if (divRem < 10) {
                digit = (char) ('0' + divRem);
            } else {
                digit = (char) ('A' + divRem - 10);
            }
            finalNumber.insert(0, digit);
            num = num/base;

        }

        switch (base){
            case 10: strBase = "A"; break;
            case 11: strBase = "B"; break;
            case 12: strBase = "C"; break;
            case 13: strBase = "D"; break;
            case 14: strBase = "E"; break;
            case 15: strBase = "F"; break;
            case 16: strBase = "G"; break;
            default: strBase = String.valueOf(base);
        }
        if (base == 10) return String.valueOf(finalNumber);
        return String.valueOf(finalNumber)+'b'+strBase;
    }


    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        int n1Int, n2Int;

        if (isNumber(n1) && isNumber(n2)) {
            n1Int = number2Int(n1);
            n2Int = number2Int(n2);
        } else {
            return false;
        }

        if (n1Int != n2Int) return false;
        return ans;
    }



    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        int maxNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(isNumber(arr[i])){
                int val = number2Int(arr[i]);
                if(val > maxNum){
                    maxNum = val;
                    ans = i;
                }
            }
        }
        return ans;
    }


}

