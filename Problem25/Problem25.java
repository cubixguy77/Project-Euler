import java.io.*;
import java.util.*;



public class Problem25 {
    
    private static int length;
    
    public static void go() {
        int[] cur = new int[1];
        int[] next = new int[1];
        cur[0]  = 1;
        next[0] = 1;
        
        length = 10;
        int term = 3;
        while (next.length < 1000) {
            int[] temp = next;
            next = add(cur, next);
            cur = temp;
            
          //  System.out.print(term + " ");
          //  printNum(next);
            term++;
        }
        System.out.println(term-1);
    }
    
    public static int[] multiply(int[] num1, int[] num2) {
        if (num2.length > num1.length)
            return multiply(num2, num1);
        else {
            int[] result = new int[num1.length + num2.length];
            int numzeros = 0;
            for (int i=num2.length-1; i>=0; i--) {
                int[] current = multiplyFactor(num1, num2[i]);
                current = addZeros(current, numzeros);
                result = add(result, current);
                numzeros++;
            }
            return result; 
        }
    }
    
    public static int[] multiplyFactor(int[] num1, int num2) {
        int max1 = num1.length - 1;
        int[] result = new int [num1.length + 1];
        int carry = 0;
        
        for (int i=max1; i>=0; i--) {
            int product = carry + (num1[i] * num2);
            int lastdig = product % 10;
            carry = (product - lastdig) / 10;
            result[i+1] = lastdig;
        }
        result[0] = carry;
        return prune(result);
    }
    
    
    public static int[] addZeros(int [] array, int numzeros) {
        int[] newarray = new int[array.length + numzeros];
        
        for (int i=0; i<array.length; i++)
            newarray[i] = array[i];
        
        return newarray;
    }
    
    public static int[] add(int[] num1, int[] num2) {
        int rlength = max(num1.length, num2.length) + 1;
        int max1 = num1.length-1;
        int max2 = num2.length-1;
        
        int[] result = new int[rlength];
        int sum=0;
        
        if (num1.length < num2.length)
            return add(num2, num1);
        else {
            int carry = 0;
            int i = max1;
            while (i >= 0) {
                
                sum = carry + num1[i];
                int num2index = i - (max1 - max2);
                if (num2index >= 0)
                    sum += num2[num2index];
                
                int lastdig = sum % 10;
                carry = (sum - lastdig) / 10;
                result[i+1] = lastdig;
                i--;
            }
            
            result[0] = carry;
        }
        return prune(result);
    }
    
    public static int[] prune(int[] array) {
        int i=0; // i could be called numZeros
        while (i < array.length && array[i] == 0) {
            i++;
        }
        
        int[] pruned = new int[array.length - i];
        for (int j=0; j<pruned.length; j++)
            pruned[j] = array[i+j];
        
        return pruned;
    }
    
    public static int sumDigits(int[] number) {
        int sum = 0;
        for (int i=0; i<number.length; i++)
            sum += number[i];
        return sum;
    }
    
    public static void printNum(int[] number) {
        int index = 0;
        while (number[index] == 0)
            index++;
        for (int i = 0; i<number.length; i++)
            System.out.print(number[i]);
        System.out.println("");
    }
    
    public static int max(int num1, int num2) {
        if (num1 > num2)
            return num1;
        return num2;
    }
    
    public static long fact(int num) {
        if (num == 1)
            return 1;
        else
            return num * fact(num - 1);
    }
    
    public static int sum(int[] number) {
        int sum = 0;
        for (int i=0; i<length; i++) {
            sum += number[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {  go(); }
    
}