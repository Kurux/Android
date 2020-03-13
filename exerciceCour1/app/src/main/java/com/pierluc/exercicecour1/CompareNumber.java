package com.pierluc.exercicecour1;

public class CompareNumber {

    public enum comparaisonState{ONEBIGGER,EQUAL,TWOBIGGER};

    public CompareNumber() {
    }

    public comparaisonState testNumbers(int number1, int number2) {
        return number1 > number2 ? comparaisonState.ONEBIGGER : (number2 > number1 ? comparaisonState.TWOBIGGER : comparaisonState.EQUAL);
    }
}
