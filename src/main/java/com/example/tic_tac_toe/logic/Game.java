package com.example.tic_tac_toe.logic;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();

    private static final String LINE = "-----------";

    public void startGame() {
        String winMessage = "Congratulations! You win!!!";
        String drawMessage = "IT'S THE DRAW!!!";
        String looseMessage = "OPSSS! You loose!!!";
        Field box = new Field();
        printGameRules();
        while (true) {
            if (inputPlayerAndCheckWin(box)) {
                showBox(box);
                System.out.println(winMessage);
                return;
            }
            if (!box.boxAvailable()) {
                showBox(box);
                System.out.println(drawMessage);
                return;
            }
            if (doPCAndCheckWin(box)) {
                showBox(box);
                System.out.println(looseMessage);
                return;
            }
            showBox(box);
        }
    }

    private void showBox(Field box) {
        String template = " %c | %c | %c %n";
        System.out.printf(template, box.getElement(0), box.getElement(1), box.getElement(2));
        System.out.println(LINE);
        System.out.printf(template, box.getElement(3), box.getElement(4), box.getElement(5));
        System.out.println(LINE);
        System.out.printf(template, box.getElement(6), box.getElement(7), box.getElement(8));
    }

    private boolean doPCAndCheckWin(Field box) {
        List<Integer> emptyCells = box.getAllEmptyCells();
        int inputComputer = random.nextInt(emptyCells.size());
        box.setElement(emptyCells.get(inputComputer), 'O');
        return checkForWin(box, 'O');
    }

    private boolean inputPlayerAndCheckWin(Field box) {
        int input;
        while (true) {
            input = scan.nextInt();
            if (input > 0 && input <= box.getBoxSize()) {
                if (box.isEmpty(input - 1)) {
                    box.setElement(input - 1, 'X');
                    break;
                } else System.out.println("That one is already in use. Enter another.");
            } else System.out.println("Invalid input. Enter again.");
        }
        return checkForWin(box, 'X');
    }

    private boolean checkForWin(Field box, char value) {
        boolean result;
        result = box.getElement(0) == value && box.getElement(1) == value && box.getElement(2) == value;
        result |= box.getElement(3) == value && box.getElement(4) == value && box.getElement(5) == value;
        result |= box.getElement(6) == value && box.getElement(7) == value && box.getElement(8) == value;
        result |= box.getElement(0) == value && box.getElement(3) == value && box.getElement(6) == value;
        result |= box.getElement(1) == value && box.getElement(4) == value && box.getElement(7) == value;
        result |= box.getElement(2) == value && box.getElement(5) == value && box.getElement(8) == value;
        result |= box.getElement(0) == value && box.getElement(4) == value && box.getElement(8) == value;
        result |= box.getElement(2) == value && box.getElement(4) == value && box.getElement(6) == value;
        return result;
    }

    private void printGameRules() {
        System.out.println("Enter box number to select. Enjoy!\n");
        System.out.println("\n\n 1 | 2 | 3 ");
        System.out.println(LINE);
        System.out.println(" 4 | 5 | 6 ");
        System.out.println(LINE);
        System.out.println(" 7 | 8 | 9 ");
    }
}