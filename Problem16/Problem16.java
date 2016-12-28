import java.util.*;
import java.io.*;

public class Problem16 {
  
  private static int [] number;
  private static int length;
  private static int max;
  
  public static void go() {
    length = 305;
    max = length - 1;
    
    number = new int[length];
    number[max] = 2;
    
    for (int i=2; i<=1000; i++) {
      updateNum();
     // System.out.print("2 ^ " + i + " ");
     // printNum();
    }
    System.out.println(sum());
  }
  
  public static void updateNum() {
    int carry = 0;
    for (int i=max; i>=0; i--) {
      int mult = carry + (2 * number[i]);
      int lastdig = mult % 10;
      carry = (mult - lastdig) / 10;
      number[i] = lastdig;
    }
  }
  
  public static void printNum() {
    int index = 0;
    while (number[index] == 0)
      index++;
    for (int i = 0; i<length; i++)
      System.out.print(number[i]);
    System.out.println("");
  }
  
  public static int pow(int i) {
    if (i == 1)
      return 2;
    else
      return 2 * pow(i - 1);
  }
  
  public static int sum() {
    int sum = 0;
    for (int i=0; i<length; i++) {
      sum += number[i];
    }
    return sum;
  }
  
  public static void main(String[] args) {
    go();
  }
}