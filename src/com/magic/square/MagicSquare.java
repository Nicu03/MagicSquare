package com.magic.square;

import java.util.Arrays;

public class MagicSquare {

    public static int[][] createMagicSquareOdd(int n) {
        int row = n / 2;
        int column = n - 1;
        int[][] magicSquare = initializeSquare(n, 0);
        magicSquare[row][column] = 1;
        int numberCount = 2;
        row -= 1;
        column += 1;
        while (numberCount <= n * n) {
            if (row == -1 && column == n) {
                row = 0;
                column = n - 2;
            } else if (row == -1) {
                row = n - 1;
            } else if (column == n) {
                column = 0;
            }
            if (magicSquare[row][column] != 0) {
                row += 1;
                column -= 2;
                continue;
            }
            magicSquare[row][column] = numberCount;
            numberCount++;
            row -= 1;
            column += 1;
        }
        return magicSquare;
    }

    static int[][] magicSquareSinglyEven(int n) {
        int size = n * n;
        int halfN = n / 2;
        int subSquareSize = size / 4;

        int[][] subSquare = createMagicSquareOdd(halfN);
        int[] quadrantFactors = {0, 2, 3,1 };
        int[][] result = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int quadrant = (r / halfN) * 2 + (c / halfN);
                result[r][c] = subSquare[r % halfN][c % halfN];
                result[r][c] += quadrantFactors[quadrant] * subSquareSize;
            }
        }

        int nColsLeft = halfN / 2;
        int nColsRight = nColsLeft - 1;

        for (int r = 0; r < halfN; r++)
            for (int c = 0; c < n; c++) {
                if (c < nColsLeft || c >= n - nColsRight
                        || (c == nColsLeft && r == nColsLeft)) {

                    if (c == 0 && r == nColsLeft)
                        continue;

                    int tmp = result[r][c];
                    result[r][c] = result[r + halfN][c];
                    result[r + halfN][c] = tmp;
                }
            }

        return result;
    }

    public static void printMatrix(int[][] magicSquare) {
        for (int[] row : magicSquare) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static int[][] initializeSquare(int n, int value) {
        int[][] magicSquare = new int[n][n];
        for (int[] ints : magicSquare) {
            Arrays.fill(ints, value);
        }
        return magicSquare;
    }

    public static boolean validateMagicSquare(int[][] magicSquare, int magicNumber) {
        int rowSum;
        int columnSum;
        for (int row = 0; row < magicSquare.length; row++) {
            rowSum = 0;
            columnSum = 0;
            for (int column = 0; column < magicSquare[row].length; column++) {
                rowSum += magicSquare[row][column];
                columnSum += magicSquare[column][row];
            }
            if (rowSum != magicNumber || columnSum != magicNumber) {
                return false;
            }
        }
        int mainDiagSum = 0;
        int secondDiagSum = 0;
        for (int row = 0; row < magicSquare.length; row++) {
            mainDiagSum += magicSquare[row][row];
            secondDiagSum += magicSquare[row][magicSquare.length - row - 1];
        }
        return mainDiagSum == magicNumber && secondDiagSum == magicNumber;
    }
}
