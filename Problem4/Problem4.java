import java.util.*;
import java.io.*;

public class Problem4 {
    
    public static void go() {
        int a = 999;
        
        Boolean done = false;
        while (!done) {
            for (int i=999; i>110; i--) {
               // System.out.println(a + " " + i);
                if (isPal(Integer.toString(a * i))) {
                    System.out.println(a + " " + i + " " + a * i);
                    //done = true; break;
                }
            }
            a--;
        }
    }
    
    public static Boolean isPal(String num) {
        if (num.length() == 0 || num.length() == 1)
            return true;
        else {
            if (num.charAt(0) == num.charAt(num.length()-1))
                return isPal(num.substring(1, num.length()-1));
            else
                return false;
        }
    }
}
        