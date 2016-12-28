public class quickieas
{
   
  /* index 0 is the rightmost digit */
  public static int getDigit(long n, int index)
  {
    return (int) (n / Math.pow(10, index)) % 10;
  }
  
  public static long s(long n)
  {
    return (long) Math.pow(2, n);
  }
  
 public static void main(String[] args)
 {
   
   
   long l = 1059402870;
   Boolean done = false;
   while (!done)
   {
     long temp = l * l;
     if (getDigit(temp, 0)  == 0 && 
         getDigit(temp, 2)  == 9 && 
         getDigit(temp, 4)  == 8 && 
         getDigit(temp, 6)  == 7 && 
         getDigit(temp, 8)  == 6 && 
         getDigit(temp, 10) == 5 && 
         getDigit(temp, 12) == 4 && 
         getDigit(temp, 14) == 3 && 
         getDigit(temp, 16) == 2 && 
         getDigit(temp, 18) == 1 )
       System.out.println("Found it: " + l);
     else
       l+=10;                            
   }
   
   
   
   
 }
  
  
  
  
}