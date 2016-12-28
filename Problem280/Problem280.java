import java.io.*;
import java.util.*;


//377.52918000036995246110874752594
//377.28612587535205865269756380892

public class Problem280 {
    public String[][] Board;
    public int curRow;
    public int curCol;
    public int numMoves;
    public int movesMade;
    public Boolean carrying;
    
    public  Problem280() {
        curRow = 2;
        curCol = 2;
        numMoves = 0;
        movesMade = 0;
        carrying = false;
        
        Board = new String[5][5];
        Board[0][0] = "_";Board[0][1] = "_";Board[0][2] = "_";Board[0][3] = "_";Board[0][4] = "_";
        Board[1][0] = "_";Board[1][1] = "_";Board[1][2] = "_";Board[1][3] = "_";Board[1][4] = "_";
        Board[2][0] = "_";Board[2][1] = "_";Board[2][2] = "_";Board[2][3] = "_";Board[2][4] = "_";
        Board[3][0] = "_";Board[3][1] = "_";Board[3][2] = "_";Board[3][3] = "_";Board[3][4] = "_";
        Board[4][0] = "X";Board[4][1] = "X";Board[4][2] = "X";Board[4][3] = "X";Board[4][4] = "X";
 
     //   printBoard();
    }
    
    public void reset() {
        curRow = 2;
        curCol = 2;
        numMoves = 0;
        movesMade = 0;
        carrying = false;
        
        Board = new String[5][5];
        Board[0][0] = "_";Board[0][1] = "_";Board[0][2] = "_";Board[0][3] = "_";Board[0][4] = "_";
        Board[1][0] = "_";Board[1][1] = "_";Board[1][2] = "_";Board[1][3] = "_";Board[1][4] = "_";
        Board[2][0] = "_";Board[2][1] = "_";Board[2][2] = "_";Board[2][3] = "_";Board[2][4] = "_";
        Board[3][0] = "_";Board[3][1] = "_";Board[3][2] = "_";Board[3][3] = "_";Board[3][4] = "_";
        Board[4][0] = "X";Board[4][1] = "X";Board[4][2] = "X";Board[4][3] = "X";Board[4][4] = "X";
 
       // printBoard();
    }
    
    public void printBoard() {
        for (int row=0; row<5; row++) {
            System.out.print("|");
            for (int col=0; col<5; col++) {
                if (row == curRow && col == curCol) {
                    if (carrying)
                        System.out.print("C" + "|");
                    else
                        System.out.print("A" + "|");
                }
                else
                    System.out.print(Board[row][col] + "|");
            }
            System.out.println("");
        }
        System.out.println("Number of moves made: " + movesMade);
    }
    
    public void updatePosition() {
        int[] legalX = getLegalX(curCol, curRow);
        int[] legalY = getLegalY(curCol, curRow);
        Random random = new Random();
        int pick = random.nextInt(numMoves);
        int newX = legalX[pick];
        int newY = legalY[pick];
    //    System.out.println("I was at " + curRow + " " + curCol + " and now am at " + newX + " " + newY);
        
        if (carrying) {
            if (newY == 4) {
            }
            else if (newY == 0) {
                if (Board[newY][newX].equals("_")) {
                    carrying = false;
                    Board[newY][newX] = "X";
                }
            }        
        }
        else {
            if (newY == 0) {}
            else if (newY == 4) {
                if (Board[newY][newX].equals("X")) {
                    carrying = true;
                    Board[newY][newX] = "_";
                }
            }
            else {}
        }
        curCol = newX;
        curRow = newY;
        movesMade++;
    }
        
    public int[] getLegalX(int x, int y) {
        int[] legalX = new int[4];
        int num = 0;
        if (isLegal(x,   y-1)) { legalX[num] = x; num++; }
        if (isLegal(x-1, y))   { legalX[num] = x-1; num++; }
        if (isLegal(x+1, y))   { legalX[num] = x+1; num++; }
        if (isLegal(x,   y+1)) { legalX[num] = x; num++; }
        numMoves = num;
        return legalX;
    }
    public int[] getLegalY(int x, int y) {
        int[] legalY = new int[4];
        int num = 0;
        if (isLegal(x,   y-1)) { legalY[num] = y-1; num++; }
        if (isLegal(x-1, y))   { legalY[num] = y; num++; }
        if (isLegal(x+1, y))   { legalY[num] = y; num++; }
        if (isLegal(x,   y+1)) { legalY[num] = y+1; num++; }
        numMoves = num;
        return legalY;
    }
    
    public int numLegalMoves(int x, int y) {
        int numLegal = 0;
        if (isLegal(x,   y-1)) numLegal++;
        if (isLegal(x-1, y)) numLegal++;
        if (isLegal(x+1, y)) numLegal++;
        if (isLegal(x,   y+1)) numLegal++;
        return numLegal;
    }
        
    public Boolean isLegal(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
    
    public Boolean Done() {
        return (Board[0][0] == "X" && 
                Board[0][1] == "X" && 
                Board[0][2] == "X" && 
                Board[0][3] == "X" && 
                Board[0][4] == "X");
    }
    
    public void go() {
        
        try {
            FileWriter fstream = new FileWriter("C:\\Documents and Settings\\Robert\\Desktop\\numbers.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);
            
            
            while (true) {
                while (!Done()) {
                    updatePosition();
                }
                out.write(Integer.toString(movesMade));
                out.newLine();
                reset();
            }
            
        }
        catch (Exception e){ System.err.println("Error: " + e.getMessage()); }
    }
    
    public static void main(String[] args) {
        Problem280 p = new Problem280();
  p.go();
    }
    
}