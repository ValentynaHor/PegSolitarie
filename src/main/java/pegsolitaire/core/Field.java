package pegsolitaire.core;

public class Field {
    private final int size = 7;
    private Tile[][] board;
    private GameState gameState;

    public Field() {
        board = new Tile[size][size];
        gameState = GameState.PLAYING;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isPlayablePosition(i, j)) {
                    board[i][j] = new Tile(TileState.PEG);
                } else {
                    board[i][j] = new Tile(TileState.EMPTY);
                }
            }
        }
        board[3][3].setState(TileState.EMPTY);
    }

    private boolean isPlayablePosition(int row, int col) {
        return !(row < 2 && col < 2 || row < 2 && col > 4 || row > 4 && col < 2 || row > 4 && col > 4);
    }

    public boolean movePeg(int fromRow, int fromColumn, int toRow, int toColumn) {
        if (board[fromRow][fromColumn].getState() != TileState.PEG) return false;
        if (board[toRow][toColumn].getState() != TileState.EMPTY) return false;

        int midRow = (fromRow + toRow) / 2;
        int midColumn = (fromColumn + toColumn) / 2;

        if (board[midRow][midColumn].getState() != TileState.PEG) return false;

        board[fromRow][fromColumn].setState(TileState.EMPTY);
        board[midRow][midColumn].setState(TileState.EMPTY);
        board[toRow][toColumn].setState(TileState.PEG);

        return true;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getSize() {
        return size;
    }
} 