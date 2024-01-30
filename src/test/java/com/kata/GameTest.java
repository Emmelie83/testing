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

}