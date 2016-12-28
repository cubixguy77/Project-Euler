import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Problem15 {
    
    private static long[][] B;
    
    public static void go() {
        B = new long[20][20];
        for (int i=0; i<20; i++) {
            B[18][i] = 20 - i;
            B[19][i] = 1;
            B[i][18] = 20 - i;
            B[i][19] = 1;
        }
        for (int row=17; row>=0; row--) {
            for (int col=17; col>=0; col--) {
                //System.out.println("Updating " + row + " " + col + " with value " + B
                B[row][col] = B[row+1][col] + B[row][col+1];
            }
        }
        for (int row=0; row<20; row++) {
            for (int col=0; col<20; col++) {
                System.out.print(B[row][col] + " ");               
            }
            System.out.println("");
        }
    }
    
    public static int numMoves(int row, int col) {
        if (row == 21 && col == 21)
            return 0;
        else
            return -1;
    }
    public static long gone() {
        long prod = 1;
        int numeven = 0;
        int numthree = 0;
        int [] factors = new int[20];
        for (int i=0; i<20; i++)
            factors[i] = i+1;
        for (int i=0; i<20; i++) {
            int num = 21 + i;
            prod *= num;
            System.out.println(prod);
            for (int j=0; j<20; j++) {
                if (prod % factors[j] == 0 && factors[j] != 1) {
                    prod /= factors[j];
                    factors[j] = 1;
                }
            }
        }
        for (int i=0; i<20; i++) {
            prod /= factors[i];
        }
        return prod;
    }
}