import java.io.*;
import java.util.*;



public class Problem23 {
  
  private static int[] abund;
  
  public static void go() {
    
    abund = new int[6965];
    int cur = 0;
    for (int i=0; i<28124; i++) {
      if (sumDivs(i) > i) {
        abund[cur] = i;
        cur++;
      }
    }
    
    int[][] sums = new int[6965][6965];
    
    
    for (int i=0; i<6965; i++) {
      for (int j=0; j<6965; j++) {
        sums[i][j] = abund[i] + abund[j];
        
      }
    }
    
    long sum = 0;
    for (int i=0; i<28123; i++) {
      if (!presentInMatrix(sums, i))
       // System.out.println(i);
        sum += i;
    }
    System.out.println(sum);
     
  }
  
  public static Boolean formableSum(int[] abund, int num) {
      int temp;
      for (int i=0; i<abund.length; i++) {
          for (int j=0; j<abund.length; j++) {
          }
      }
      return false;
  }
  
  public static Boolean presentInMatrix(int[][] matrix, int num) {
    int i = 0; int j = 0;
    
    while (i < matrix.length) {
      int cur = matrix[i][j];
      
     // if (num == 12)
     //   System.out.println("==========checking 12========== " + cur + " " + i + " " + j);
      
      if (cur == num)
        return true;
      
      if (cur > num && j == 0)
          return false;
      
      if (cur > num || j == matrix.length) {
          i++;
          j = 0;
      }
      else 
          j++;
    }
    
    return false;
  }
  
  public static int sumDivs(int num) {
    if (num == 0 || num == 1)
      return 0;
    else {
      int sum = 1;
      int stop = (int) Math.sqrt(num);
      if (stop * stop == num)
        sum -= (1 * stop);
      for (int i=2; i<=stop; i++) {
        if (num % i == 0) {
          sum += i;
          sum += num / i;
        }
      }
      return sum;
    }
  }
  
  public static void printArray(int[] array) {
      for (int i=0; i<array.length; i++)
          System.out.print(array[i] + " ");
      System.out.println();
  }
    
  
  public static void main(String[] args) {  go(); }
  
}