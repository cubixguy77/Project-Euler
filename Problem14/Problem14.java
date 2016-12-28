import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Problem14 {
    
    public static void go() {
        long longestindex = 1;
        long longestlength = 1;
        
        for (long i=1; i<1000000; i++) {
            long length = getLength(i);
            if (length > longestlength) {
                longestlength = length;
                longestindex = i;
            }
            //if (i % 10000 == 0)
            //    System.out.println(i + " " + longestindex + " " + longestlength);
        }       
        System.out.println(longestindex + " " + longestlength);
    }
    
    public static long getLength(long i) {
       // System.out.println(i);
        if (i == 1)
            return 1;
        else if (i % 2 == 0)
            return 1 + getLength(i / 2);
        else if (i < 0) {
            System.out.println("negative number_____________________+++++++++++++++++++++++++++++");
            return -1;
        }
        else
            return 1 + getLength((3 * i) + 1); 
    }
    
    public static int getLength2(int start) {
        int length = 0;
        int n = start;
        
        while (n != 1) {
            if (n % 2 == 0)
                n /= 2;
            else
                n = (n * 3) + 1;
        }
        return -1;
    }
    
}