import java.io.*;
import java.util.*;


public class Problem18 {
    
    private static int[][] B;
    private static int[][] solved;
    
    public static void go() {
        B = new int[15][15];
        solved = new int[15][15];
        int nextInt;
        try {
            Scanner sc = new Scanner(new File("C:\\Documents and Settings\\Robert\\My Documents\\Project Euler\\Problem18\\numbers.txt"));
            int numcols = 1;
            for (int row=0; row<15; row++) {
                for (int col=0; col < numcols; col++) {
                    nextInt = sc.nextInt();
                    B[row][col] = nextInt;
                }
                numcols++;
            }
        }
        catch (java.util.NoSuchElementException e) { System.out.println("No such user"); }
        catch (IOException e) { System.out.println("iweejfoiwejf"); }
        
        for (int i=0; i<15; i++) {
            solved[14][i] = B[14][i];
        }
        
        System.out.println(bestPath(0,0));
    }
    
    public static int bestPath(int row, int col) {
        if (solved[row][col] > 0)
            return solved[row][col];
        else
            return B[row][col] + max( bestPath(row+1, col) , bestPath(row+1, col+1));    
    }
    
    public static int max(int num1, int num2) {
        if (num1 > num2)
            return num1;
        return num2;
    }
}