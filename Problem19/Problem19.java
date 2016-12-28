import java.util.*;
import java.io.*;

public class Problem19 {
  
  private static int [] days;
  private static int [] daysl;
  
  public static void go() {
    days = new int[12];
    days[0] = 31;
    days[1] = 28;
    days[2] = 31;
    days[3] = 30;
    days[4] = 31;
    days[5] = 30;
    days[6] = 31;
    days[7] = 31;
    days[8] = 30;
    days[9] = 31;
    days[10] = 30;
    days[11] = 31;
    
    daysl = new int[12];
    daysl[0] = 31;
    daysl[1] = 29;
    daysl[2] = 31;
    daysl[3] = 30;
    daysl[4] = 31;
    daysl[5] = 30;
    daysl[6] = 31;
    daysl[7] = 31;
    daysl[8] = 30;
    daysl[9] = 31;
    daysl[10] = 30;
    daysl[11] = 31;
    
    int day = 1;
    int month = 0;
    int year = 1901;
    
    int numSunday = 0;
    int dayofweek = 2; // 1/1/1901 was a Tuesday
    
    while (! (day == 31 && month == 11 && year == 2000)) {
      
      if (leapYear(year)) {
        if (day == 1 && dayofweek == 0) {
          System.out.println("Day: " + day);
          System.out.println("Month: " + month);
          System.out.println("Year: " + year + "\n");
          numSunday++;
        }
        if (day == daysl[month]) {
          day = 1;
          month++;
        }
        else {
          day++;
        }
        if (month == 12) {
          month = 0;
          day = 1;
          year++;
        }
        dayofweek = (dayofweek + 1) % 7;
      }
      else {
        if (day == 1 && dayofweek == 0) {
          System.out.println("Day: " + day+1);
          System.out.println("Month: " + month+1);
          System.out.println("Year: " + year + "\n");
          numSunday++;
        }
        if (day == days[month]) {
          day = 1;
          month++;
        }
        else {
          day++;
        }
        if (month == 12) {
          month = 0;
          day = 1;
          year++;
        }
        dayofweek = (dayofweek + 1) % 7;
      }
    }
    
    System.out.println(numSunday);
  }
  
  public static Boolean leapYear(int year) {
    return ( ( (year % 4 == 0) && !(year % 100 == 0) ) 
              || ( (year % 100 == 0) && (year % 400 == 0) ) );
  }
  
  public static void main(String[] args) {
    go();
  }
}