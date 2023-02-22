package main;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReflexGameTest {
    private ReflexGame game;
    @BeforeEach
    void runBefore(){
        game = new ReflexGame();
    }

    @Test
    void testUpdate(){
        assertFalse(game.isGameOver());
        for (int i = 0; i < 16; i++) {
            assertEquals(game.getBlock().getLife(), 15-i);
            game.update();
        }
        assertTrue(game.isGameOver());
    }

    @Test
    void testUpdateLifeSpan(){
        assertEquals(game.getLifespan(), 15);
        game.updateLifeSpan();
        assertEquals(game.getLifespan(), 14);
        game.updateLifeSpan();
        assertEquals(game.getLifespan(), 13);
    }

    @Test
    void testUpdateBlockNumber(){
        assertEquals(game.getBlockNumber(), 10);
        game.updateBlockNumber();
        assertEquals(game.getBlockNumber(), 9);
        game.updateBlockNumber();
        assertEquals(game.getBlockNumber(), 8);
    }

}
