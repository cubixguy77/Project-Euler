import java.util.*;
import java.io.*;

public class Problem300 {
    
    private static int length;
    private static int[] sequence;
    private static int arraysize;
    
    
    public static void go() {
        length = 15;
        arraysize = 20;
        
        sequence = new int[length];
        for (int i=0; i<length; i++)
            sequence[i] = 1;
        
        int totalContacts = 0;
        
        while (!done()) {
            int [][] B = new int[arraysize][arraysize];
            totalContacts += optimalContacts(B, 0, 3, 3);
            updateSequence(length - 1);
        }
        
        System.out.println("Answer: " + totalContacts);        
    }
    
    public static void updateSequence(int index) {
        if (sequence[index] == 1)
            sequence[index] = 2;
        else {
            sequence[index] = 1;
            updateSequence(index - 1);
        }
    }
    
    public static Boolean done() {
        for (int i=0; i<length; i++) {
            if (sequence[i] == 1)
                return false;
        }
        return true;
    }
    
    public static void printSequence() {
        for (int i=0; i<length; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println("");
    }
    
    /* The meet of this program, returns the maximum number of hydrophobic contacts a given protein sequence can make */
    public static int optimalContacts(int [][] B, int index, int row, int col) {
             
        if (index == 0) {                // first bit
            B[row][col] = sequence[0];
            return optimalContacts( B, 1, row+1, col);
        }
          
        else if (index == length-1)  {   // last bit
            B[row][col] = sequence[length-1];
            int numcontacts = getNumContacts( B );
            B[row][col] = 0;
            return numcontacts;  
        }       
        
        else {                           // not first and not last, so more to come
            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            int num4 = 0;
            
            B = updateBoard(B, row, col, index);
            
            if (isValid(B, row+1, col))
                num1 = optimalContacts( B, index+1, row+1, col);
            if (isValid(B, row, col+1))
                num2 = optimalContacts( B, index+1, row, col+1);
            if (isValid(B, row-1, col))
                num3 = optimalContacts( B, index+1, row-1, col);
            if (isValid(B, row, col-1))
                num4 = optimalContacts( B, index+1, row, col-1);
            
            B[row][col] = 0;
            
            return max(max(num1, num2), max(num3, num4));
        }
    }
    
    public static Boolean isValid(int [][] B, int row, int col) {
        if (row >= 0 && row < arraysize && col >=0 && col < arraysize && B[row][col] == 0)
            return true;
        return false;
    }
    
    public static int max(int num1, int num2) {
        if (num1 > num2)
            return num1;
        return num2;
    }
    
    public static int getNumContacts(int [][] B) {
        
        int num = 0;
        for (int col=0; col<arraysize; col++) {
            for (int row=0; row <arraysize-1; row++) {
                if (B[row][col] == 1 && B[row+1][col] == 1)
                    num++;
            }
        }
        for (int row=0; row<arraysize; row++) {
            for (int col=0; col<arraysize-1; col++) {
                if (B[row][col] == 1 && B[row][col+1] == 1)
                    num++;
            }
        }
        return num;            
    }
    
    public static int[][] updateBoard(int[][] B, int row, int col, int index) {
        if (isValid(B, row, col)) {
            B[row][col] = sequence[index];
            return B;
        }
        else {
            System.out.println("Cannot update board: " + row + " " + col + " " + index);
            printBoard(B);
            return B;
        }  
    }
    
    public static Boolean zeroRow(int [][] B, int row) {
        for (int i=0; i<arraysize; i++) {
            if (B[row][i] != 0)
                return false;
        }
        return true;
    }
    
    public static void printBoard(int [][] B) {
        int numChars = 0;
        for (int row=0; row<arraysize; row++) {
            if (!zeroRow(B, row)) {
                for (int col=0; col<arraysize; col++) {
                    if (B[row][col] == 0)
                        System.out.print("  ");
                    else {
                        System.out.print(B[row][col] + " ");
                        numChars++;
                    }
                }
                System.out.println("");
            }
        }
        System.out.println("num chars: " + numChars);
        System.out.println("");
    }
    
    public static void wait (int n){
        long t0,t1;
        t0=System.currentTimeMillis();
        do{ t1=System.currentTimeMillis(); }
        while (t1-t0 < n);
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        go();
        long end = System.currentTimeMillis();
        System.out.println("Execution time was " + (end-start) + " ms.");
    }
}