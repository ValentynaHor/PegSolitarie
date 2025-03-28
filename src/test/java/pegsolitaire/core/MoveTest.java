package pegsolitaire.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    @Test
    void testMoveCreation() {
        Move move = new Move(1, 2, 3, 4);
        
        assertEquals(1, move.getFromRow());
        assertEquals(2, move.getFromColumn());
        assertEquals(3, move.getToRow());
        assertEquals(4, move.getToColumn());
    }

    @Test
    void testMoveWithNegativeCoordinates() {
        Move move = new Move(-1, -2, -3, -4);
        
        assertEquals(-1, move.getFromRow());
        assertEquals(-2, move.getFromColumn());
        assertEquals(-3, move.getToRow());
        assertEquals(-4, move.getToColumn());
    }
} 