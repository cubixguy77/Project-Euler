import java.util.*;
import java.io.*;

public class Problem12 {
    
    public static void go() {
        int divs = 0;
        int maxdivs = 0;
        long i = 1;
        int add = 2;
        int updatenum = 0;
        while (divs < 501) {
           // System.out.println(i);
            if (add % 500 == 0)
                System.out.println(i + " " + maxdivs);
            divs = numDiv(i);
            if (divs > maxdivs)
                maxdivs = divs;
            i += add;
            add++;
        }
        System.out.println(i - (add - 1));        
    }
    
    public static int numDiv(long num) {
        int divs = 0;
        for (int i=1; i < (num/2)+1; i++) {
            if (num % i == 0) {
               // System.out.println(i);
                divs++;
            }
        }
        return divs + 1;
        
    }
}