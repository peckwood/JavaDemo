package com.bladespear.demo.random;

import java.util.Random;

/**
 * https://www.journaldev.com/17111/java-random#generate-random-number-using-seed
 */
public class SeedDemo {
    public static void main(String[] args) {
        int seed1 = 10;
        int seed2 = 20;
        Random seed1Generator1 = new Random(seed1);
        Random seed1Generator2 = new Random(seed1);
        Random seed2Generator1 = new Random(seed2);
        Random seed2Generator2 = new Random(seed2);

        System.out.println("seed1Generator1: " + seed1Generator1.nextInt());
        System.out.println("seed1Generator1: " + seed1Generator1.nextInt());
        System.out.println("seed1Generator1: " + seed1Generator1.nextInt());
        System.out.println();
        System.out.println("seed1Generator2: " + seed1Generator2.nextInt());
        System.out.println("seed1Generator2: " + seed1Generator2.nextInt());
        System.out.println("seed1Generator2: " + seed1Generator2.nextInt());
        System.out.println();
        System.out.println("seed2Generator1: " + seed2Generator1.nextInt());
        System.out.println("seed2Generator1: " + seed2Generator1.nextInt());
        System.out.println("seed2Generator1: " + seed2Generator1.nextInt());
        System.out.println();
        System.out.println("seed2Generator2: " + seed2Generator2.nextInt());
        System.out.println("seed2Generator2: " + seed2Generator2.nextInt());
        System.out.println("seed2Generator2: " + seed2Generator2.nextInt());
    }
}
