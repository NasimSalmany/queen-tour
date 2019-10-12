package com.demo;

/**
 * @author Nasim Salmany
 */
public class Application {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("(" + i + "," + j + ")");
                // While we don't get a solution
                while (!new PieceTour().performPieceTour(i, j)) {
                    ;
                }
                System.out.println("------");
            }
        }
    }
}
