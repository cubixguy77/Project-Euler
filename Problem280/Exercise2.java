import java.util.Scanner; // Needed for the Scanner
import java.io.*; // Needed for the File and IOException

/**
 * This program reads data from a file.
 */

public class Exercise2
    
{
    public static void main(String[] args) throws IOException
    {
        
// Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        
        
        
// Open the file.
        File file = new File("C:\\Documents and Settings\\Robert\\Desktop\\numbers.txt");
        Scanner inputFile = new Scanner(file);
        
        
        System.out.println("The file "+"'1.txt'"+" contains the numbers:");
        
        int numbersCounter = 0; //counts how many numbers in file
        int sum = 0; //sum of all the numbers
        
// Read lines from the file until no more are left.
        while (inputFile.hasNext())
        {
// Read the next number.
            int numList = inputFile.nextInt();
            
// Display the last number read.
//System.out.println(numList);
            sum = sum + numList;
            numbersCounter++;
            
        }
        double average = sum / numbersCounter;
        System.out.println("Sum: " + sum + " numbers " + numbersCounter);
        System.out.println("Average: " + average);
        
// Close the file.
        inputFile.close();
        
        
        
        
        
    }
}