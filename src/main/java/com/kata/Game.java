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
            if (rolls[i] == 10) {
                score += 10 + rolls[i + 1] + rolls[i + 2];
                i++;
            } else if (rolls[i] + rolls[i + 1] == 10) {
                score += 10 + rolls[i + 2];
                i += 2;
            } else {
                score += rolls[i] + rolls[i + 1];
                i += 2;
            }
        }
        return score;
    }
}
