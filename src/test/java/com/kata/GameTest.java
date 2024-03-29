package com.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();

    @Test
    void givenNoRollsThenScoreShouldReturn0() {
        assertEquals(0, game.score());
    }

    @Test
    void givenOneRollTakingDownOnePinThenScoreShouldReturn1() {
        game.roll(1);
        assertEquals(1, game.score());
    }

    @Test
    void givenTwentyRollsTakingDownOnePinEachThenScoreShouldReturn20() {
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    void givenASparePlusOneRollTakingDownTreePinsThenScoreShouldReturn16() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        assertEquals(16, game.score());
    }

    @Test
    void givenAStrikePlusTwoRollsTakingDownTreePinsEachThenScoreShouldReturn22() {
        game.roll(10);
        game.roll(3);
        game.roll(3);
        assertEquals(22, game.score());
    }

    @Test
    void givenAllStrikesThenScoreShouldReturn300() {
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        assertEquals(300, game.score());
    }

}