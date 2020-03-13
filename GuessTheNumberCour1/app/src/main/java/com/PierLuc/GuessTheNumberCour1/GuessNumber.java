package com.PierLuc.GuessTheNumberCour1;

import java.util.Random;

public class GuessNumber {

    private int currentNumber;
    private int maxNumber;

    public enum guessState{BIGGER,EQUAL,SMALLER};


    public GuessNumber(int maxNumber) {
        this.maxNumber = maxNumber;
        generateNewNumber();
    }

    public guessState testNumber(int numberToTest)
    {
        return numberToTest == currentNumber ? guessState.EQUAL : (numberToTest > currentNumber ? guessState.BIGGER : guessState.SMALLER);
    }

    public void  generateNewNumber(){
        currentNumber=new Random().nextInt(maxNumber+1);
    }

}
