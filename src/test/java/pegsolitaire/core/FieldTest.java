package pegsolitaire.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {
    @Test
    void testValidMove() {
        Field field = new Field();
        boolean result = field.movePeg(3, 1, 3, 3);
        assertTrue(result);
    }

    @Test
    void testInvalidMove() {
        Field field = new Field();
        boolean result = field.movePeg(3, 3, 3, 5);
        assertFalse(result);
    }

    @Test
    void testInitialBoardState() {
        Field field = new Field();
        Tile[][] board = field.getBoard();
        
        // Перевірка центру
        assertEquals(TileState.EMPTY, board[3][3].getState());
        
        // Перевірка кутів (мають бути порожніми)
        assertEquals(TileState.EMPTY, board[0][0].getState());
        assertEquals(TileState.EMPTY, board[0][6].getState());
        assertEquals(TileState.EMPTY, board[6][0].getState());
        assertEquals(TileState.EMPTY, board[6][6].getState());
        
        // Перевірка середини (мають бути фішками)
        assertEquals(TileState.PEG, board[3][1].getState());
        assertEquals(TileState.PEG, board[3][5].getState());
        assertEquals(TileState.PEG, board[1][3].getState());
        assertEquals(TileState.PEG, board[5][3].getState());
    }

    @Test
    void testMovePegRemovesMiddlePeg() {
        Field field = new Field();
        field.movePeg(3, 1, 3, 3);
        Tile[][] board = field.getBoard();
        
        // Перевірка що фішка в центрі тепер порожня
        assertEquals(TileState.EMPTY, board[3][2].getState());
    }
} 