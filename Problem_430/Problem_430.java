import java.util.*; import java.math.*;

public class Problem_430
{
  public static long n = 10;
  public static int r = 4;
  public static long nn = n * n;
  public static double Get_P(long i, long n)
  {
    return (double) (((i - 1) * (i - 1)) + ((n - i) * (n - i))) / (n * n);
    //return (double)  (2.0 * ((i - 1) / nn)) + (double) (2.0 * ((n - i)/nn));
  }
  
  public static double Get_Probability(long i, long n, int r)
  {
    double p = Get_P(i, n);
    double q = 1 - p;
    return (.5) * (1 + Math.pow(q - p, r));
  }
  
  
    
  public static void main(String args[])
  {
    
    
    double sum = 0;
    
    for (long i=1; i<=n; i++)
    {
      double addition = Get_Probability(i, n, r);
      sum += addition;
      if (addition > 1)
        System.out.println(i + " " + addition + " " + sum);
    }
    System.out.println(sum);
  }
}