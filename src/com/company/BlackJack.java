package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class BlackJack {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int total = 0;
        int computerTotal = 0;
        boolean stick = false;
        boolean computerStick = false;
        String wantToStick = "";

        Map<Integer, String> cardNames = new HashMap<Integer, String>();
        cardNames.put(1, "Ace");
        cardNames.put(2, "Two");
        cardNames.put(3, "Three");
        cardNames.put(4, "Four");
        cardNames.put(5, "Five");
        cardNames.put(6, "Six");
        cardNames.put(7, "Seven");
        cardNames.put(8, "Eight");
        cardNames.put(9, "Nine");
        cardNames.put(10, "Ten");
        cardNames.put(11, "Jack");
        cardNames.put(12, "Queen");
        cardNames.put(13, "King");

        for (int i = 0; i < 2; i++) {
            int rollNum = RollCard();
            System.out.println("Your card is: " + cardNames.get(rollNum));
            rollNum = getNumber(rollNum);
            total += rollNum;
            System.out.println("Your total is: " + total);
            System.out.println();

            System.out.println("Computer is playing... ");
            computerTotal += RollCard();
            System.out.println();

        }

        while (total < 21 && computerTotal < 21 && (!stick) || (!computerStick)) {
            do {
                System.out.println("Do you want to stick? Write y or n: ");
                wantToStick = input.next();
            } while (!wantToStick.equals("y") && !wantToStick.equals("n"));
            if (wantToStick.equals("y")) {
                stick = true;
            }

            if (computerTotal > 15) {
                computerStick = true;
            }
            if (!stick) {
                int rollNum = RollCard();
                System.out.println("Your card is: " + cardNames.get(rollNum));
                rollNum = getNumber(rollNum);
                total += rollNum;
                System.out.println("Your total is: " + total);
            }

            if (!computerStick) {
                System.out.println();
                System.out.println("Computer is playing... ");
                computerTotal += RollCard();
                System.out.println();
            }


        }


        if (total > 21) {
            System.out.println("You lost! Your total was: " + total + " (over 21) and the computer's total was " + computerTotal);
        } else if (computerTotal > 21) {
            System.out.println("You won! Your total was: " + total + " and the computer's total was " + computerTotal + " (over 21)");
        } else {

            if (total > computerTotal) {
                System.out.println("You won! Your total was: " + total + " and the computer's total was " + computerTotal);
            } else if (computerTotal > total) {
                System.out.println("You lost! Your total was: " + total + " and the computer's total was " + computerTotal);

            } else {
                System.out.println("You drew! Your total was: " + total + " and the computer's total was " + computerTotal);
            }
        }


    }

    public static int RollCard() {
        Random random = new Random();
        int cardNum = 0;
        cardNum = random.nextInt(12);
        cardNum += 1;
        return cardNum;


    }

    public static int getNumber(int x) {
        Scanner input = new Scanner(System.in);

        int rollNum = x;

        if (rollNum > 10) {
            rollNum = 10;
        }

        if (rollNum == 1) {
            int aceThrown = 0;
            do {
                try {

                    System.out.println("Do you want your ace to be a 1 or an 11? ");

                    aceThrown = input.nextInt();

                } catch (Exception e) {
                    System.out.println("Enter an integer ");
                }
            } while (aceThrown != 1 && aceThrown != 11);


            rollNum = aceThrown;

        }

        return rollNum;
    }

}
