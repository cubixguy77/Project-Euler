import java.io.*;
import java.util.*;



public class Problem21 {
  
  private static int[] sumDivs;
  
  public static void go() {
    sumDivs = new int[10000];
    for (int i=1; i<10000; i++)
      sumDivs[i] = sumDivs(i);
    
    int sum = 0;
    int[] amicables = new int [10000];
    for (int a=2; a<10000; a++) {
      int b = sumDivs[a];
      if (b < 10000 && sumDivs[b] == a && a != b)
        sum += a;
    }
    
    System.out.println( sum );
    
  }
  
  public static int sumDivs(int num) {
    if (num == 1)
      return 0;
    else {
      int sum = 1;
      int stop = (int) Math.sqrt(num);
      if (stop * stop == num)
        sum+=stop;
      for (int i=2; i<stop; i++) {
        if (num % i == 0) {
          sum += i;
          sum += num / i;
        }
      }
      return sum;
    }
  }
  
  public static int sumArray(int[] array) {
    int sum = 0;
    for (int i=0; i<array.length; i++) {
      sum += array[i];
      System.out.print(array[i] + " ");
    }
    return sum;
  }
  
  public static void main(String[] args) {  go(); }
  
}