import java.util.*;
import java.io.*;

public class Problem9 {
    
    public static void go() {
        long currentprime = 0;
        long sum = 0;
        try {
            Scanner sc = new Scanner(new File("C:\\Documents and Settings\\Robert\\Desktop\\primes1.txt"));
            while (currentprime < 2000000) {
              //  System.out.println(currentprime);
                currentprime = sc.nextInt();
                sum += currentprime;
            }
        }
        catch (java.util.NoSuchElementException e) {
            System.out.println("No such user");
        }
        catch  (IOException e) {
        }
        System.out.println(sum - currentprime);
    }
}