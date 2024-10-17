/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numbersystemconversion;

/**
 *
 * @author thokz
 */
import java.util.Scanner;

public class NumberSystemConversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Decimal to Binary/Octal/Hexadecimal");
            System.out.println("2. Binary to Decimal/Octal/Hexadecimal");
            System.out.println("3. Octal to Decimal/Binary/Hexadecimal");
            System.out.println("4. Hexadecimal to Decimal/Binary/Octal");
            System.out.println("5. Decimal to 1's Complement Binary");
            System.out.println("6. Decimal to 2's Complement Binary");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    double decimal = getDoubleInput(scanner, "Enter a decimal number: ");
                    System.out.println("Binary: " + decimalToBinary(decimal));
                    System.out.println("Octal: " + decimalToOctal(decimal));
                    System.out.println("Hexadecimal: " + decimalToHexadecimal(decimal));
                    break;
                case 2:
                    String binary = getStringInput(scanner, "Enter a binary number: ");
                    System.out.println("Decimal: " + binaryToDecimal(binary));
                    System.out.println("Octal: " + binaryToOctal(binary));
                    System.out.println("Hexadecimal: " + binaryToHexadecimal(binary));
                    break;
                case 3:
                    String octal = getStringInput(scanner, "Enter an octal number: ");
                    System.out.println("Decimal: " + octalToDecimal(octal));
                    System.out.println("Binary: " + octalToBinary(octal));
                    System.out.println("Hexadecimal: " + octalToHexadecimal(octal));
                    break;
                case 4:
                    String hexadecimal = getStringInput(scanner, "Enter a hexadecimal number: ");
                    System.out.println("Decimal: " + hexadecimalToDecimal(hexadecimal));
                    System.out.println("Binary: " + hexadecimalToBinary(hexadecimal));
                    System.out.println("Octal: " + hexadecimalToOctal(hexadecimal));
                    break;
                case 5:
                    double decimalForOnesComplement = getDoubleInput(scanner, "Enter a decimal number: ");
                    System.out.println("1's Complement Binary: " + decimalToOnesComplementBinary(decimalForOnesComplement));
                    break;
                case 6:
                    double decimalForTwosComplement = getDoubleInput(scanner, "Enter a decimal number: ");
                    System.out.println("2's Complement Binary: " + decimalToTwosComplementBinary(decimalForTwosComplement));
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
        return scanner.nextInt();
    }

    private static double getDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
        return scanner.nextDouble();
    }

    private static double getDoubleInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return getDoubleInput(scanner);
    }

    private static String getStringInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    private static String decimalToBinary(double decimal) {
        return Long.toBinaryString(Double.doubleToLongBits(decimal));
    }

    private static String decimalToOctal(double decimal) {
        return Long.toOctalString(Double.doubleToLongBits(decimal));
    }

    private static String decimalToHexadecimal(double decimal) {
        return Long.toHexString(Double.doubleToLongBits(decimal));
    }

    private static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    private static String binaryToOctal(String binary) {
        int decimal = binaryToDecimal(binary);
        return decimalToOctal(decimal);
    }

    private static String binaryToHexadecimal(String binary) {
        int decimal = binaryToDecimal(binary);
        return decimalToHexadecimal(decimal);
    }

    private static int octalToDecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    private static String octalToBinary(String octal) {
        int decimal = octalToDecimal(octal);
        return decimalToBinary(decimal);
    }

    private static String octalToHexadecimal(String octal) {
        int decimal = octalToDecimal(octal);
        return decimalToHexadecimal(decimal);
    }

    private static int hexadecimalToDecimal(String hexadecimal) {
        return Integer.parseInt(hexadecimal, 16);
    }

    private static String hexadecimalToBinary(String hexadecimal) {
        int decimal = hexadecimalToDecimal(hexadecimal);
        return decimalToBinary(decimal);
    }

    private static String hexadecimalToOctal(String hexadecimal) {
        int decimal = hexadecimalToDecimal(hexadecimal);
        return decimalToOctal(decimal);
    }

    private static String decimalToOnesComplementBinary(double decimal) {
        String binary = decimalToBinary(decimal);
        StringBuilder onesComplementBinary = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                onesComplementBinary.append('1');
            } else {
                onesComplementBinary.append('0');
            }
        }
        return onesComplementBinary.toString();
    }

    private static String decimalToTwosComplementBinary(double decimal) {
        String onesComplementBinary = decimalToOnesComplementBinary(decimal);
        StringBuilder twosComplementBinary = new StringBuilder();
        boolean carry = true;
        for (int i = onesComplementBinary.length() - 1; i >= 0; i--) {
            char bit = onesComplementBinary.charAt(i);
            if (carry) {
                if (bit == '1') {
                    twosComplementBinary.insert(0, '0'); // Carry forward
                } else {
                    twosComplementBinary.insert(0, '1'); // Flip and no carry
                    carry = false;
                }
            } else {
                twosComplementBinary.insert(0, bit); // No change
            }
        }
        return twosComplementBinary.toString();
    }
}