import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Problem17 {
    
    private static int[] lookup;
    
    public static void go() {
        lookup = new int[101];
        
        lookup[1] = "one".length();
        lookup[2] = "two".length();
        lookup[3] = "three".length();
        lookup[4] = "four".length();
        lookup[5] = "five".length();
        lookup[6] = "six".length();
        lookup[7] = "seven".length();
        lookup[8] = "eight".length();
        lookup[9] = "nine".length();
        lookup[10] = "ten".length();
        lookup[11] = "eleven".length();
        lookup[12] = "twelve".length();
        lookup[13] = "thirteen".length();
        lookup[14] = "fourteen".length();
        lookup[15] = "fifteen".length();
        lookup[16] = "sixteen".length();
        lookup[17] = "seventeen".length();
        lookup[18] = "eighteen".length();
        lookup[19] = "nineteen".length();
        lookup[20] = "twenty".length();
        lookup[30] = "thirty".length();
        lookup[40] = "forty".length();
        lookup[50] = "fifty".length();
        lookup[60] = "sixty".length();
        lookup[70] = "seventy".length();
        lookup[80] = "eighty".length();
        lookup[90] = "ninety".length();
        lookup[100] = "onehundred".length();
        
        long sum = 0;
        for (int i=1; i<=999; i++) {
          //  System.out.println(i + " " + numChars(i));
            sum += numChars(i);
        }
        sum += "onethousand".length();
        System.out.println(sum);
    }
    
    public static int numChars(int num) {
        if (num <= 20)
            return lookup[num];
        else if(num <= 100 && num % 10 == 0)
            return lookup[num];
        else if(num < 100)
            return lookup[num - (num % 10)] + lookup[num % 10];
        else if (num % 100 == 0)
            return lookup[(int) (num / 100)] + "hundred".length();
        else
            return lookup[(int) (num / 100)] + "hundred".length() + "and".length() + numChars(num % 100);
    }
    
}