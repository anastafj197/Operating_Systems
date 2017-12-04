// Frank Anastasia
// Operating Systems 
// p003 Radii 

import java.util.*;
import java.io.*;

public class rpnCalculator {
    
    static Scanner s;
    
    public static void main(String[] args) {
              
        prompter();
        calculate();
        
    }
    
    // usage 
    
    public static void prompter() {
              
        System.out.println();
        System.out.println("         * Welcome to the rpn calculator *");
        System.out.println("   rpn can handle only the + - * / % ^ operators");
        System.out.println("         rpn can handle the following bases");
        System.out.println();
        System.out.println("b - unsigned binary");
        System.out.println("s - sign-magnitude binary");
        System.out.println("c - 2's compliment binary");
        System.out.println("d - (signed) decimal");
        System.out.println("x - hexadecimal");
        System.out.println();
        System.out.println("Input base is denoted i followed by a base character");
        System.out.println("Output base is denoted o followed by a base character");
        System.out.println();
      
    }
        
    // parses signmag string and converts to a decimal int 
    // takes in a string to parse 
    // returns a decimal representation
    
    public static int parseSignMag(String input) {
        
        int negBit = 0;
        negBit = input.charAt(0);
        
        int unsigned = 0;
        unsigned = parseNonnegativeInt(input.substring(1), 'b');
        
        if (negBit == 1 ) {
            unsigned = (-1) * unsigned; 
            return unsigned;
        } else {
            return unsigned;
        }
    }
    
    // parses decimal string and converts to a decimal int 
    // takes in a string to parse 
    // returns a decimal representation
    
    public static int parseDecimal(String input) {
        
        int sum = 0;
        int position = 1;
        for (int i = input.length() - 1; i >= 0; i--) {
            int number = input.charAt(i) - '0';
            sum += number * position;
            position = position * 10;
        }
        System.out.println(sum);
        return sum;
    }
    
    // parses a string according to the chosen base 
    
    public static int parseNonnegativeInt(String input, char base) {
        
        int result = 0;        
            
        if (base == 'b') {
            result = convertBtoD(input);                               
        }
        if (base == 'c') {
            //result = convertCtoB(input);    
        }
        if (base == 'x') {
            result = convertXtoD(input);       
        }
            
        return result;
    }
        
    // do conversion on the user input depending on the base 
    // push onto stack prompt for another input to push 
    // series of if statements depending on next user input 
    // + - * / % ^ all will pop the two values off and push 
    // the result of the opperation back on 
    
    public static void calculate() {
        
        Character choice = ' ';
        Character oBaseC = ' ';
        
        String iBase = "";
        String iBase2 = "";
        String oBase = "";
        String firstNum = "";
        String secondNum = "";
        String operator = "";
        
        s = new Scanner(System.in);
        
        Stack lifo = new Stack();
        
        short parsedOne = 0;
        short parsedTwo = 0;
        short poppedOne = 0;
        short poppedTwo = 0;
        double result = 0; 
        
        int temp = 0; 

        System.out.println("Enter an input base for calculations");
        iBase = s.next().trim();
        
        System.out.println("Enter an output base");
        oBase = s.next().trim();
        
        oBaseC = oBase.charAt(1);
        
        System.out.println("Enter a number in chosen base");        
        firstNum = s.next().trim();
        
        System.out.println("Enter another input base ");       
        iBase2 = s.next().trim();
        
        choice = iBase2.charAt(1);
        
        System.out.println("Enter another number in chosen base");
        secondNum = s.next().trim();
        
        System.out.println();
                               
        if (iBase.charAt(1) == 'b') {
            parsedOne = (short)parseNonnegativeInt(firstNum, 'b'); 
            lifo.push(parsedOne);
            
            switch (choice) {
                case 'b':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'b');
                           lifo.push(parsedTwo);
                    
                case 's':  parsedTwo = (short)parseSignMag(secondNum);
                           lifo.push(parsedTwo);
                    
                case 'c':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'c');
                           lifo.push(parsedTwo);
                    
                case 'd':  parsedTwo = (short)parseDecimal(secondNum);
                           lifo.push(parsedTwo);
                    
                case 'x':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'x');
                           lifo.push(parsedTwo);
            }
        }
        if (iBase.charAt(1) == 's') {
            parsedOne = (short)parseSignMag(firstNum);
            lifo.push(parsedOne);
                                 
            switch (choice) {
                case 'b':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'b');
                           lifo.push(parsedTwo);
                    
                case 's':  parsedTwo = (short)parseSignMag(secondNum);
                           lifo.push(parsedTwo);
                    
                case 'c':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'c');
                           lifo.push(parsedTwo);
                    
                case 'd':  parsedTwo = (short)parseDecimal(secondNum);
                           lifo.push(parsedTwo);
                    
                case 'x':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'x');
                           lifo.push(parsedTwo);
            }
        }
        if (iBase.charAt(1) == 'c') {
            parsedOne = (short)parseNonnegativeInt(firstNum, 'c');
            lifo.push(parsedOne);
                       
            switch (choice) {
                case 'b':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'b');
                           lifo.push(parsedTwo);
                    
                case 's':  parsedTwo = (short)parseSignMag(secondNum);
                           lifo.push(parsedTwo);
                    
                case 'c':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'c');
                           lifo.push(parsedTwo);
                    
                case 'd':  parsedTwo = (short)parseDecimal(secondNum);
                           lifo.push(parsedTwo);
                    
                case 'x':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'x');
                           lifo.push(parsedTwo);
            }
        }
        if (iBase.charAt(1) == 'd') {
            parsedOne = (short)parseDecimal(firstNum);
            lifo.push(parsedOne);   
            
            switch (choice) {
                case 'b':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'b');
                           lifo.push(parsedTwo);
                    
                case 's':  parsedTwo = (short)parseSignMag(secondNum);
                           lifo.push(parsedTwo);
                    
                case 'c':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'c');
                           lifo.push(parsedTwo);
                    
                case 'd':  parsedTwo = (short)parseDecimal(secondNum);
                           lifo.push(parsedTwo);
                    
                case 'x':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'x');
                           lifo.push(parsedTwo);
            }
        }
        if (iBase.charAt(1) == 'x') {
            parsedOne = (short)parseNonnegativeInt(firstNum, 'x');
            lifo.push(parsedOne);   
            
           switch (choice) {
                case 'b':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'b');
                           lifo.push(parsedTwo);
                    
                case 's':  parsedTwo = (short)parseSignMag(secondNum);
                           lifo.push(parsedTwo);
                    
                case 'c':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'c');
                           lifo.push(parsedTwo);
                    
                case 'd':  parsedTwo = (short)parseDecimal(secondNum);
                           lifo.push(parsedTwo);
                    
                case 'x':  parsedTwo = (short)parseNonnegativeInt(secondNum, 'x');
                           lifo.push(parsedTwo);
            }
        }
        
        System.out.println("Enter an operator");      
        operator = s.next().trim();
        
        if (operator.charAt(0) == '+') {
            //System.out.println(lifo.peek());
            poppedTwo = (short)lifo.pop();
            poppedOne = (short)lifo.pop();
            result = poppedOne + poppedTwo;
            System.out.println(result);
            printInCorrectBase(oBaseC, (int)result);
            lifo.push(result);
            
        } else if (operator.charAt(0) == '-') {
            poppedTwo = (short)lifo.pop();
            poppedOne = (short)lifo.pop();
            result = poppedOne - poppedTwo;
            printInCorrectBase(oBaseC, (int)result);
            lifo.push(result);
            
        } else if (operator.charAt(0) == '*') {
            poppedTwo = (short)lifo.pop();
            poppedOne = (short)lifo.pop();
            result = poppedOne * poppedTwo;
            printInCorrectBase(oBaseC, (int)result);
            lifo.push(result);
            
        } else if (operator.charAt(0) == '/') {
            poppedTwo = (short)lifo.pop();
            poppedOne = (short)lifo.pop();
            result = poppedOne / poppedTwo;
            printInCorrectBase(oBaseC, (int)result);
            lifo.push(result);
            
        } else if (operator.charAt(0) == '%') {
            poppedTwo = (short)lifo.pop();
            poppedOne = (short)lifo.pop();
            result = poppedOne % poppedTwo;
            printInCorrectBase(oBaseC, (int)result);
            lifo.push(result);
            
        } else if (operator.charAt(0) == '^') {
            poppedTwo = (short)lifo.pop();
            poppedOne = (short)lifo.pop();
            result = Math.pow(poppedOne, poppedTwo);
            printInCorrectBase(oBaseC, (int)result);
            lifo.push(result);
            
        } else {
            System.out.println("you entered an incorrect operator");
            System.exit(0);
        }
    }
    
    // depending on the out put base choice we print in correct form 
    
    public static void printInCorrectBase(Character oBaseChoice, int result) {
                        
        String output;              

        if (oBaseChoice == 'b') {
            output = convertDtoB(result);
            System.out.println(output);
            
        } else if (oBaseChoice == 's') {
            //output = convertDtoS(result);
            //System.out.println(output);
            
        } else if (oBaseChoice == 'c') {
            output = convertDtoC(result);
            System.out.println(output);
            
        } else if (oBaseChoice == 'd') {
            System.out.println(result);
            
        } else if (oBaseChoice == 'x') {
            output = convertDtoX(result);
            System.out.println(output);
            
        }
    }
    
    // converts a decimal number to a binary number 
    // accepts an int 
    // returns binary string representation
    
    public static String convertDtoB(int number) {
        
        int b = 2;
        String r = "";
        String c = "";

        do {
            c += (number % b);
            number /= b;         
        } while (number != 0);

        for (int i = (c.length() - 1); i >= 0; i--) {
            r += c.charAt(i);
        }
        if (r.length() < 16 ) {
            int pad = 16 - r.length();
            for (int i = 0; i < pad; i++) {
                r = "0" + r;
            }
        }
        System.out.println(r + " B");
        return r;
        
    }
    
    public static int convertBtoD(String number) {
        
        char []cA = number.toCharArray();
        int result = 0;
        for (int i = cA.length-1; i >= 0; i--) {

            if (cA[i]=='1') { 
                result += Math.pow(2, cA.length-i-1);
            }
        }
        System.out.println(result + " D");
        return result;
    }
    
    public static String convertDtoC (int number) {
        
        String temp;
        String result;
        
        temp = convertDtoB(number);
        result = convertBtoC(temp);
        return result;
    }
    
    public static String convertDtoX(int number) {
        
        String digits = "0123456789ABCDEF";
        if (number <= 0) return "0";
        
        int base = 16;   // flexible to change in any base under 16
        String hex = "";
        while (number > 0) {
            int digit = number % base;              // rightmost digit
            hex = digits.charAt(digit) + hex;  // string concatenation
            number = number / base;
        }
        System.out.println(hex + " H");
        return hex;
    }
    
    public static int convertXtoD(String s) {
        
        int val = 0;
        s = s.toUpperCase();
        String digits = "0123456789ABCDEF";
                
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16 * val + d;
        }
        return val;
    }
    
    public static String convertXtoB(String s) {
        
        int decNum;
        String hexDecNum = "";
        String biNum = "";
        decNum = convertXtoD(s);
        biNum = convertDtoB(decNum);
        return biNum;
    } 
    
    public static String convertBtoX(String binary) {
        
        int sum = 0;
        int digitNumber = 1; 
        String hex = "";
        
        for (int i = 0; i < binary.length(); i++)  {
            if (digitNumber == 1)
                sum += Integer.parseInt(binary.charAt(i) + "") * 8;
            else if (digitNumber == 2)
                sum += Integer.parseInt(binary.charAt(i) + "") * 4;
            else if (digitNumber == 3)
                sum += Integer.parseInt(binary.charAt(i) + "") * 2;
            else if (digitNumber == 4 || i < binary.length() + 1) {
                sum += Integer.parseInt(binary.charAt(i) + "") * 1;
                digitNumber = 0;
                if (sum < 10)
                    hex = hex + "" + sum;
                else if (sum == 10)
                    hex = hex + "A";
                else if (sum == 11)
                    hex = hex + "B";
                else if (sum == 12)
                   hex = hex + "C";
                else if (sum == 13)
                    hex = hex + "D";
                else if (sum == 14)
                    hex = hex + "E";
                else if (sum == 15)
                    hex = hex + "F";
                sum = 0;
            }
            digitNumber++;  
        }
        System.out.println(hex);
        return hex;
    }
    
    //public static String convertBtoS(String binary) {}
    
    //public static String convertStoB(String binary) {}
    
    public static String convertBtoC(String binary) {
        
        String flipped = "";
        String twosComp = "";
        flipped = invertDigits(binary);
        twosComp = addBinary1ToString(flipped);
        return twosComp;
    }
        
    //public static String convertCtoB(String binary) {}
    
    public static String invertDigits(String binaryInt) {
        
        String result = binaryInt;
        result = result.replace("0", " "); //temp replace 0s
        result = result.replace("1", "0"); //replace 1s with 0s
        result = result.replace(" ", "1"); //put the 1s back in
        return result;
             
    }
    
    // this was a bitch
    // had to append the string by adding a one to account 
    // for the 2s compliement 
    
    public static String addBinary1ToString(String flipped) {
         
        
        String twosComp = "";
        char[] flipSplit = flipped.toCharArray();
        int i = flipSplit.length - 1;
        int j = flipped.length() - 1;
        int count = 0;
        int loopFactor = 0;
        char lowOrderBit = flipped.charAt(j);
        
        System.out.println(lowOrderBit);
        
        for (int l = flipped.length() - 1; l > 0; l--) {
            if (flipped.charAt(l) == '1') { count++; }
            if (flipped.charAt(l) == '0') { break;   }
        }
        
        System.out.println(count + " count");
        
        if (lowOrderBit == '0') {
            flipSplit[i] = '1';
            twosComp = String.valueOf(flipSplit);
            System.out.println(twosComp);
            return twosComp;
        } else {                 
            for (int c = 0; c < count; c++) {
                flipSplit[i] = '0';
                System.out.println(lowOrderBit + " b");
                i--;
            }
            
            flipSplit[flipSplit.length - 1 - count] = '1';
            twosComp = String.valueOf(flipSplit);
            System.out.println(twosComp);
            return twosComp;
        }
    }
}
        
    
    
