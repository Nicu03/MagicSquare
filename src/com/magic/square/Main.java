package com.magic.square;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = getDimension(in);
        System.out.println("The magic number is: " + n * (n * n + 1) / 2);
        int [][]magicSquare;
        if(n%2==0){
            if(n%4==0){
                //TODO
                magicSquare = null;
            }else {
                magicSquare = MagicSquare.magicSquareSinglyEven(n);
            }
        }else{
            magicSquare = MagicSquare.createMagicSquareOdd(n);
        }
        MagicSquare.printMatrix(magicSquare);

        if(MagicSquare.validateMagicSquare(magicSquare,n * (n * n + 1) / 2)){
            System.out.println("This is Magic");
        }else{
            System.out.println("This is NOT Magic");
        }

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
