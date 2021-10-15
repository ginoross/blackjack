package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int minEggs = 26 * 12;
        int numOfChickens = 0;
        int numofEggs = 0;
        int totalEggs = 0;

        System.out.println("Enter the number of chickens: ");
        numOfChickens = input.nextInt();

        for (int i = 0; i < numOfChickens - 1; i++) {
            int randomEggs = random.nextInt(60);
            numofEggs = (minEggs + randomEggs);
            System.out.println("This chicken laid: " + numofEggs);
            totalEggs += numofEggs;
        }
        System.out.println("The total number of eggs was: " + totalEggs);


    }
}
