import java.io.*;
import java.util.*;



public class ifuckedup {
  
  private static int[] number;
  private static int length;
  
  public static void go() {
      
      int numValid = 362880;
      long i = 1023456789L;
      while (i <=9999999999L) {
          
          if (isValid(i)) {
             // System.out.println(i + " " + numValid);
              numValid++;
          }
          
          if (i % 100000 == 0)
              System.out.println(i + " " + numValid);
          
          if (numValid == 1000000)
              System.out.println("==============OMG FOUND IT================== " + i);
          
          if (Long.toString(i).charAt(0) == Long.toString(i).charAt(1))
              i += 100000000;
          else if (Long.toString(i).charAt(1) == Long.toString(i).charAt(2))
              i += 10000000;
          else if (Long.toString(i).charAt(2) == Long.toString(i).charAt(3))
              i += 1000000;
          else if (Long.toString(i).charAt(3) == Long.toString(i).charAt(4))
              i += 100000;
          else if (Long.toString(i).charAt(4) == Long.toString(i).charAt(5))
              i += 10000;
          else if (Long.toString(i).charAt(5) == Long.toString(i).charAt(6))
              i += 1000;
          else if (Long.toString(i).charAt(6) == Long.toString(i).charAt(7))
              i += 100;
          else if (Long.toString(i).charAt(7) == Long.toString(i).charAt(8))
              i += 10;
          else
              i++;
      }
      System.out.println(numValid);
  }
  
  public static Boolean isValid(long num) {
      int[] temp = new int[10];
      String snum = Long.toString(num);

  //    if (snum.length() == 9) {
  //        snum = "0" + snum;
  //    }
      
      for (int i=0; i<10; i++) {
          temp[ Character.getNumericValue( snum.charAt(i) ) ]++;
      }
      
      for (int i=0; i<10; i++) {
          if (temp[i] != 1)
              return false;
      }
      return true;
  }
  
  public static void main(String[] args) {  go(); }
  
}