package com.kata;

public class Game {

    private int score;
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    public int score() {
        int i = 0;
        for (int frames = 0; frames < 10; frames++) {
            if (isStrike(i)) {
                score += 10 + addStrikeBonus(i);
                i++;
            } else if (isSpare(i)) {
                score += 10 + addSpareBonus(i);
                i += 2;
            } else {
                score += rolls[i] + rolls[i + 1];
                i += 2;
            }
        }
        return score;
    }

    boolean isStrike(int i) {
        if (rolls[i] == 10) return true;
        else return false;
    }

    int addStrikeBonus(int i) {
        return rolls[i + 1] + rolls[i + 2];
    }

    boolean isSpare(int i) {
        if (rolls[i] + rolls[i + 1] == 10) return true;
        else return false;
    }

    int addSpareBonus(int i) {
        return rolls[i + 2];
    }
}
