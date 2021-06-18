package com.magic.square;

import java.util.Arrays;

public class MagicSquare {

    public static void createMagicSquareOdd(int n, int[][] magicSquare) {
        int row = n / 2;
        int column = n - 1;
        magicSquare[row][column] = 1;
        int numberCount = 2;
        while (numberCount <= n * n) {
            row -= 1;
            column += 1;
            if (row == -1 && column != n) {
                row = n - 1;
            }
            if (row != -1 && column == n) {
                column = 0;
            }
            if(row==-1&&column== n){
                row = 0;
                column = n -2;
            }
            if(magicSquare[row][column]!=0){
                row+=1;
                column-=2;
            }
            magicSquare[row][column]=numberCount;
            numberCount++;
        }
        printMatrix(magicSquare);
    }

    private static void printMatrix(int[][] magicSquare) {
        for (int[] row : magicSquare) {
            for (int number:row) {
                System.out.print(number+" ");
            }
            System.out.println();
        }
    }

    public static int[][] initializeSquare(int n,int value) {
        int[][] magicSquare = new int[n][n];
        for (int[] ints : magicSquare) {
            Arrays.fill(ints, value);
        }
        return magicSquare;
    }
}
