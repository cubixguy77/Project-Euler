import java.io.*;
import java.util.*;



public class Problem100 {

  
  public static void go() {
    double sqrt = 1.4142135623730950488016887242097;
    
    for (long i=1000000000000L; i<9999999999999L; i++) {
      long b = (long) (i / sqrt);
      long b2 = b + 1;
      
      long numerator   = b2 * b;
      long denomenator = i  * (i-1);
      
     // if (2 * numerator == denomenator)
       // System.out.println((2 * numerator) - denomenator);
    }
  }
  
  public static void main(String[] args) {  go(); }
  
  
}