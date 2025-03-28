package pegsolitaire.core;

public enum GameState {
    PLAYING,  // Гра триває
    SOLVED,   // Виграш (лише одна фішка)
    FAILED    // Програш (немає доступних ходів)
} 