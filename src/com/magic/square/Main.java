package com.magic.square;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

import static com.magic.square.MagicSquare.createMagicSquareOdd;
import static com.magic.square.MagicSquare.initializeSquare;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = getDimension(in);
        System.out.println("The magic number is: " + n * (n * n + 1) / 2);
        int[][] magicSquare = initializeSquare(n,0);
        createMagicSquareOdd(n, magicSquare);
    }

    private static int getDimension(Scanner in) {
        int n;
        do {
            try {
                System.out.print("Please insert the number of the square: ");
                String input = in.nextLine();
                n = Integer.parseInt(input);
                if (n < 3) {
                    n = -1;
                    System.out.println("Insert a number >=3");
                }
            } catch (NumberFormatException ex) {
                n = -1;
                System.out.println("Please insert a number");
            }
        } while (n < 3);
        return n;
    }
}
