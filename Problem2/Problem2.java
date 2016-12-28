import java.util.*;

public class Problem2 {
  
  public static void go() {
    int n = 3;
    int a = 1;
    int b = 1;
    int next = 2;
    long sum = 0;
    
    while (next < 4000000) {
      if (n % 3 == 0) 
        sum += next;
      a = b;
      b = next;
      next = a + b;
      n++;
    }
    System.out.println(a + " " + b + " " + next);
    System.out.println(sum);
  }
}
    