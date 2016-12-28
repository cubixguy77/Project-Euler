import java.io.*;
import java.util.*;



public class Problem24 {
  
  private static int[] number;
  private static int length;
  
  public static void go() {
      length = 5;
      int[] number = new int[length];
      int max = length - 1;
      
      for (int i=0; i<length; i++)
          number[i] = i;
      
      int cycleindex = max - 2; // index of the digit that is being looped over, 3rd digit from the end
      Boolean swapLast = true;
      int[] lastDigits = new int[2];
      
      int numperms = 1;
      
      while (numperms < 1000000) {
          while (cycleindex >= 0 || number[cycleindex] <= max) {
              
              System.out.print(numperms + " " ); 
              printArray(number);
              
              if (swapLast) {                      // first action in the pair is to swap
                  int temp = number[max];
                  number[max] = number[max-1];
                  number[max-1] = temp;
                  swapLast = false;
                  
              }
              else {                          
                  number[cycleindex] = getMissingDigit(number, number[cycleindex], cycleindex);           // second action is to increment the 3rd index from the end
                  if (number[cycleindex] >= length) {
                      
                      number[cycleindex-1] = getMissingDigit(number, number[cycleindex-1], cycleindex-1);                                       
                      number[cycleindex] = getMissingDigit(number, 0, cycleindex);
                      
                      if (number[cycleindex] >= length)
                          cycleindex--;
                  }
                  lastDigits = getMissingDigits(number);
                  number[max-1] = lastDigits[0];
                  number[max] = lastDigits[1];
                  swapLast = true;
              }
              numperms++;
          }
      } 
  }
  
  public static int getMissingDigit(int[] number, int min, int index) {
      
      int[] temp = new int[length];
      
      for (int i=0; i<length; i++) 
          temp[ i ] = -1;
     
      for (int j=0; j<index; j++)
          temp[ number[j] ] = number[j];
      
      for (int k=0; k<length; k++) {
          if (temp[k] == -1 && k > min)
              return k;
      }
      return -1;
  }
  public static int[] getMissingDigits(int[] number) {
      System.out.print("MISSING DIGIT: "); printArray(number);
      
      int numFound = 0;
      int[] temp = new int[length];
      int[] missingdigits = new int[2];
      
      for (int i=0; i<length; i++) 
          temp[ i ] = -1;
     
      for (int j=0; j<length-2; j++)
          temp[ number[j] ] = number[j];
      
      for (int k=0; k<length; k++) {
          if (temp[k] == -1) {
              missingdigits[ numFound ] = k;
              numFound++;
          }
      }
      
      return missingdigits;              
  }
  
  public static void printArray(int[] array) {
      for (int i=0; i<array.length; i++)
          System.out.print(array[i]);
      System.out.println();
  }
  
  public static void main(String[] args) {  go(); }
  
}