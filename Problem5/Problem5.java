import java.util.*;
import java.io.*;

public class Problem5 {
    
    public static void go() {
      /*  long start = 1*2*3*5*7*11*13*17*19;
        Boolean done = false;
        while (!done) {
            if (isDiv(start)) {
                System.out.println(start);
                done = true;
            }
            start++;
        }*/
    }
    
    public static long isDiv(long num) {
        for (int i=1; i<20; i++) {
            if (num % i != 0) {
                System.out.println("Number " + num + " is not div by " + i);
                return isDiv(num * i);
            }
        }
        return num;
    }
    
    public static Boolean isDivi(long num) {
        for (int i=1; i<20; i++) {
            if (num % i != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static long prune(long num) {
        long newnum = num;
        while (isDivi(newnum)) {
            newnum /= 2;
        } newnum *= 2;
        while (isDivi(newnum)) {
            newnum /= 3;
        } newnum *= 3;
        while (isDivi(newnum)) {
            newnum /= 5;
        } newnum *= 5;
        while (isDivi(newnum)) {
            newnum /= 7;
        } newnum *= 7;
        while (isDivi(newnum)) {
            newnum /= 11;
        } newnum *= 11;
        while (isDivi(newnum)) {
            newnum /= 13;
        } newnum *= 13;
        while (isDivi(newnum)) {
            newnum /= 17;
        } newnum *= 17;
        while (isDivi(newnum)) {
            newnum /= 19;
        } newnum *= 19;
        return newnum;
    }
}