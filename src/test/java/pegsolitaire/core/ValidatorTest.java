package pegsolitaire.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    @Test
    void testValidMove() {
        Field field = new Field();
        Move move = new Move(3, 1, 3, 3);
        assertTrue(Validator.isValidMove(field, move));
    }

    @Test
    void testInvalidMoveNoPeg() {
        Field field = new Field();
        Move move = new Move(3, 3, 3, 5);
        assertFalse(Validator.isValidMove(field, move));
    }

    @Test
    void testInvalidMoveNoMiddlePeg() {
        Field field = new Field();
        field.movePeg(3, 1, 3, 3); // Видаляємо фішку посередині
        Move move = new Move(3, 0, 3, 2);
        assertFalse(Validator.isValidMove(field, move));
    }

    @Test
    void testInvalidMoveDiagonal() {
        Field field = new Field();
        Move move = new Move(3, 1, 4, 2);
        assertFalse(Validator.isValidMove(field, move));
    }

    @Test
    void testInvalidMoveTooFar() {
        Field field = new Field();
        Move move = new Move(3, 1, 3, 5);
        assertFalse(Validator.isValidMove(field, move));
    }

    @Test
    void testGameOver() {
        Field field = new Field();
        // Виконуємо ходи, які залишать тільки одну фішку
        field.movePeg(3, 1, 3, 3);
        field.movePeg(3, 4, 3, 2);
        field.movePeg(3, 6, 3, 4);
        field.movePeg(1, 3, 3, 3);
        field.movePeg(5, 3, 3, 3);
        
        assertTrue(Validator.isGameOver(field));
    }

    @Test
    void testGameNotOver() {
        Field field = new Field();
        assertFalse(Validator.isGameOver(field));
    }
} 