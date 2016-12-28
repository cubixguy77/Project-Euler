import java.io.*;

class Prime
{
  
   /*
  public static Boolean verifyFactors(int[] factors, int n)
  {
    int prod = n;
    int lastfactor = 0;
    for (int i=0; i<factors.length; i++)
    {
      if (factors[i] == lastfactor)
      {
        System.out.println("error: duplication on " + n);
        return false;
      }    
      if (prod % factors[i] != 0)
      {
        System.out.println("error: " + factors[i]  + " is not a factor of " + n);
        return false;
      }
      while (prod % factors[i] == 0)
        prod /= factors[i];
      lastfactor = factors[i];
    }
    while (prod % 2 == 0)
      prod /= 2;
    if (prod != 1)
    {
      System.out.println("product doesn't add up: " + prod + " " + n);
      return false;
    }
    return true;
  }
  */
    /*
    String outputFile = "Prime_Factorization.txt";    
    File file = new File(outputFile);          
    file.delete();
    
    try 
    { 
      FileWriter out = new FileWriter(outputFile, true);      
      for (int i=2; i<=100000000; i++)
      {
        int[] factors = primeFactors(i);
        out.write(i + " ");
        for (int f=0; f<factors.length; f++)
          out.write(factors[f] + " ");
        out.write("\n");
      }
      out.close();
    }
    catch(java.io.IOException e) { System.out.println(" nope "); }
    */
      
    /*
    for (int i=2; i<=10000000; i++)
    {
      verifyFactors(primeFactors(i), i);
    }
    */
    
    
    
    
    
    /*
    int max = 14;
    
    long total = 0L;
    
    int numFactors = 0;
    int[] temp = new int[7];
    
        
    try {
      Scanner s = new Scanner(new File(inputFile));
      
      while (i < max) 
      {
        String name = s.next();
        i++;
      }               
    }
    
    catch (java.io.FileNotFoundException e) { ; }
    catch (java.util.NoSuchElementException e) { ; }
*/
  
  /*
  public static int[] getPrimeFactors(int x)
  {
    int num = x;
    while (num % 2 == 0)
      num /= 2;
    
    int[] result = new int[15];
    int curIndex = 0;
    for (int i=0; i<primes.length; i++)
    {
      int prime = primes[i];
      if (prime > num)
        break;
      if (num % prime == 0)
      {
        result[curIndex] = prime;
        curIndex++;
        while (num % prime == 0)
          num /= prime;
      }
    }
    
    int output[] = new int[curIndex];
    for (int i=0; i<output.length; i++)
      output[i] = result[i];
    
    return output;
  }  
  */
  
  
  
  public static void main( String args[] )
  {
    
    
    String inputFile = "primes.txt";
    String outputFile = "output.txt";
    
    File file = new File(outputFile);          
    file.delete();       
    
    try {
      FileWriter out = new FileWriter(outputFile, true);               
      
      
      int x, y;
    for( x = 3; x < 34000000; x++ )
    {
      
      
        for( y = 2; y <= x / 2; y++ )
        {
          if( x % y == 0 )
          {
            break;
          }   
        }
 
        if( y > x / 2 )
        {
          //System.out.println(x + ",");
          out.write(x + ",");
        }
      
    }
    }
    catch(java.io.IOException e) { System.out.println(" nope "); }
    
    
    
      
  }    
}