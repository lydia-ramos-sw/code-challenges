package com.smallworlds.fibonacci;

public class FibonacciChallenge {
    private static final double SQRT_5 = Math.sqrt(5);
    private static final double AU = (1 + SQRT_5) / 2;
    private static final double AU_CON = (1 - SQRT_5) / 2;
    public static long fibonacci(int n) {
        return Math.round((Math.pow(AU, n) - Math.pow(AU_CON, n)) / SQRT_5);
    }
    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            System.out.print(fibonacci(i) + ",");
        }
    }
}