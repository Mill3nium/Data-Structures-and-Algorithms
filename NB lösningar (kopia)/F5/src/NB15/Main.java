package NB15;


import java.util.*;

public class Main {


    private static int binaryToDecimal(String binaryNumber) {
        int decimal = 0;
        int length = binaryNumber.length();
        if (length > 0) {
            String substring = binaryNumber.substring(1);
            int digit = Character.getNumericValue(binaryNumber.charAt(0));
            decimal = digit * (int) Math.pow(2, length - 1) + binaryToDecimal(substring);
            return decimal;
        }
        return decimal;
    }

    static String decimalToBinary(int decimal_number)
    {
        int result;
        if(decimal_number > 0)
        {
            result = decimal_number % 2;
            return (decimalToBinary(decimal_number / 2) + "" + result);
        }
        return "";
    }

    public static void main(String[] args) {
        String binary = "11";
        int decimal = 5;


        System.out.println("Binary to decimal: " + binaryToDecimal(binary));
        System.out.println("Decimal to binary: " + decimalToBinary(decimal));

    }
}
