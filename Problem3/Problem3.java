import java.util.*;
import java.io.*;

//600851475143

public class Problem3 {
    
    public static void go() {
        long small = 1;
        long num = 600851475143L;
        Boolean done = false;
        while (!done) {
            if (num % small == 0) {
                long large = num / small;
               // System.out.println("Small: " + small);
              //  System.out.println("Large Factor: " + large + " is prime: " + isPrime(large));
                
                if (isPrime(num / small)) {
                    System.out.println("Largest found: " + num / small);
                    done = true;
                }
            }
            small++;
        }
    }
    
    public static Boolean isPrime(long num) {
        for (long i=2; i<num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}