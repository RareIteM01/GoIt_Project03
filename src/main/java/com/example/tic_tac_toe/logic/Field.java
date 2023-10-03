package com.example.tic_tac_toe.logic;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private char[] boxArray;
    private static final int BOX_SIZE = 9;

    public Field() {
        this.boxArray = initBox();
    }

    private char[] initBox() {
        char[] emptyBox = new char[9];

        for (byte i = 0; i < 9; i++) {
            emptyBox[i] = ' ';
        }
        return emptyBox;
    }

    public char getElement(int index) {
        checkIndex(index);
        return boxArray[index];
    }

    public void setElement(int index, char value) {
        checkIndex(index);
        boxArray[index] = value;
    }

    public boolean isEmpty(int index) {
        checkIndex(index);
        return boxArray[index] == ' ';
    }

    public byte getBoxSize() {
        return BOX_SIZE;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= BOX_SIZE) {
            throw new IndexOutOfBoundsException("IllegalBoxIndex");
        }
    }

    public boolean boxAvailable() {
        for (int i = 0; i < BOX_SIZE; i++)
            if (boxArray[i] == ' ') return true;
        return false;
    }

    public List<Integer> getAllEmptyCells() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < BOX_SIZE; i++)
            if (boxArray[i] == ' ') result.add(i);
        return result;
    }
}