import java.util.*;
import java.io.*;

public class Problem7 {
    
    public static void go() {
        int current = 0;
        try {
            Scanner sc = new Scanner(new File("C:\\Documents and Settings\\Robert\\Desktop\\primes.txt"));
            
            for (int i=0; i<10001; i++) {
                current = sc.nextInt();
            }
            System.out.println(current);
        }
        catch (java.util.NoSuchElementException e) {
            System.out.println("No such user");
        }
        catch  (IOException e) {
        }
    }
}
 