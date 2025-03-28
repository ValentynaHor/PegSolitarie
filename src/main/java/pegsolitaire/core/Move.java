package pegsolitaire.core;

public class Move {
    private int fromRow, fromColumn;
    private int toRow, toColumn;

    public Move(int fromRow, int fromColumn, int toRow, int toColumn) {
        this.fromRow = fromRow;
        this.fromColumn = fromColumn;
        this.toRow = toRow;
        this.toColumn = toColumn;
    }

    public int getFromRow() { return fromRow; }
    public int getFromColumn() { return fromColumn; }
    public int getToRow() { return toRow; }
    public int getToColumn() { return toColumn; }
} 