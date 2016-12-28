import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Problem13 {
    
    private static int [][] B;
    private static int []   solution;
    public static void go() {
        load();
        solution = new int[60];
        
        int carry = 0;
        int sum = 0;
        
        for (int col=49; col>=0; col--) {
          //  System.out.println("Col: " + col);
            sum = carry;
            for (int row=0; row<100; row++) {
                sum += B[row][col];
            }
            solution[col] = sum % 10;
            carry = (sum - (sum % 10)) / 10;
           // System.out.println("");
            System.out.println("Column: " + col + " " + sum + " " + carry);
        }
        System.out.print(sum + " "); for (int i=0; i<8; i++) System.out.print(solution[i]); System.out.println("");
    }
    
    public static void load() {
        B = new int[100][50];
        int nextInt;
        try {
            Scanner sc = new Scanner(new File("C:\\Documents and Settings\\Robert\\My Documents\\Project Euler\\Problem13\\numbers.txt"));
            for (int row=0; row<100; row++) {
                String line = sc.nextLine();
                for (int col=0; col<50; col++) {
                    nextInt = Character.getNumericValue(line.charAt(col));
                    B[row][col] = nextInt;
                }
            }
        }
        catch (java.util.NoSuchElementException e) { System.out.println("No such user"); }
        catch (IOException e) { System.out.println("iweejfoiwejf"); }
    }
}