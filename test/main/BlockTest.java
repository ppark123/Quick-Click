package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class BlockTest {

    private Block b;
    private int lifespan = 5;

    @BeforeEach
    void runBefore(){
        b = new Block(10, 10, lifespan);
    }

    @Test
    void testUpdateLifeSpan() {
        assertEquals(b.getLife(), 5);
        b.updateLifeSpan();
        assertEquals(b.getLife(), 4);
        b.updateLifeSpan();
        assertEquals(b.getLife(), 3);
        b.updateLifeSpan();
        assertEquals(b.getLife(), 2);
        b.updateLifeSpan();
        assertEquals(b.getLife(), 1);
        b.updateLifeSpan();
        assertEquals(b.getLife(), 0);
        b.updateLifeSpan();
        assertEquals(b.getLife(), 0);
        assertFalse(b.isAlive());

    }
    @Test
    void testUpdateBlock() {
        assertEquals(b.get_Color(), new Color(86, 178, 86));
        assertEquals(b.getLife(), 5);
        b.updateBlock();
        assertEquals(b.get_Color(), new Color(218, 79, 79));
        assertEquals(b.getLife(), 4);
    }

    @Test
    void testBlockClicked() {
        assertFalse(b.clicked());
        b.setClicked();
        assertTrue(b.clicked());
    }
}
