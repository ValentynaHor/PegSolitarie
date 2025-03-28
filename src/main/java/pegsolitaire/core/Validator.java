package pegsolitaire.core;

public class Validator {
    public static boolean isGameOver(Field field) {
        Tile[][] board = field.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getState() == TileState.PEG) {
                    if (canMove(board, i, j)) return false;
                }
            }
        }
        return true;
    }

    private static boolean canMove(Tile[][] board, int row, int col) {
        return (row > 1 && board[row - 1][col].getState() == TileState.PEG && board[row - 2][col].getState() == TileState.EMPTY) ||
               (row < 5 && board[row + 1][col].getState() == TileState.PEG && board[row + 2][col].getState() == TileState.EMPTY) ||
               (col > 1 && board[row][col - 1].getState() == TileState.PEG && board[row][col - 2].getState() == TileState.EMPTY) ||
               (col < 5 && board[row][col + 1].getState() == TileState.PEG && board[row][col + 2].getState() == TileState.EMPTY);
    }

    public static boolean isValidMove(Field field, Move move) {
        Tile[][] board = field.getBoard();
        int fromRow = move.getFromRow();
        int fromCol = move.getFromColumn();
        int toRow = move.getToRow();
        int toCol = move.getToColumn();

        // Перевірка меж поля
        if (fromRow < 0 || fromRow >= board.length || fromCol < 0 || fromCol >= board[0].length ||
            toRow < 0 || toRow >= board.length || toCol < 0 || toCol >= board[0].length) {
            return false;
        }

        // Перевірка початкової позиції
        if (board[fromRow][fromCol].getState() != TileState.PEG) {
            return false;
        }

        // Перевірка кінцевої позиції
        if (board[toRow][toCol].getState() != TileState.EMPTY) {
            return false;
        }

        // Перевірка відстані (має бути 2 клітинки)
        if (Math.abs(fromRow - toRow) != 2 && Math.abs(fromCol - toCol) != 2) {
            return false;
        }

        // Перевірка напрямку (тільки горизонтально або вертикально)
        if (fromRow != toRow && fromCol != toCol) {
            return false;
        }

        // Перевірка наявності фішки для перестрибування
        int midRow = (fromRow + toRow) / 2;
        int midCol = (fromCol + toCol) / 2;
        return board[midRow][midCol].getState() == TileState.PEG;
    }
} 