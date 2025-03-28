# Peg Solitaire Game

A classic Peg Solitaire puzzle game implemented in Java. The goal is to remove pegs by jumping over them until only one peg remains.

## Requirements

- Java Development Kit (JDK) 8 or higher
- Terminal/Command Prompt

## How to Run the Game

1. Make sure you have Java installed:
   - To check, open terminal/command prompt and type: `java -version`
   - If Java is not found, download and install JDK from:
     - [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or
     - [OpenJDK](https://adoptium.net/)

2. Save both game files (`PegSolitaire.java` and `Game.java`) in the same directory

3. Open terminal/command prompt and navigate to the directory containing the files:
   ```
   cd path/to/game/directory
   ```

4. Compile the game:
   ```
   javac PegSolitaire.java Game.java
   ```

5. Run the game:
   ```
   java Game
   ```

## How to Play

### Game Board
The game board uses these symbols:
- `o` = Peg
- `.` = Empty hole
- `#` = Invalid position

Example board:
```
  0 1 2 3 4 5 6
0 # # # o # # #
1 # # # o # # #
2 # # # o # # #
3 o o o . o o o
4 # # # o # # #
5 # # # o # # #
6 # # # o # # #
```

### Game Rules
1. A peg can jump over another peg into an empty hole
2. The jumped-over peg is removed
3. Jumps can only be made horizontally or vertically (not diagonally)
4. The goal is to remove all pegs except one

### Making Moves
1. Enter moves in the format: `fromRow fromCol toRow toCol`
   - `fromRow` = Row number of the peg you want to move
   - `fromCol` = Column number of the peg you want to move
   - `toRow` = Row number where you want to move the peg
   - `toCol` = Column number where you want to move the peg

Example moves:
- To jump from (3,1) to (3,3): Enter `3 1 3 3`
- To jump from (1,3) to (3,3): Enter `1 3 3 3`

### Additional Commands
- Type `quit` to exit the game

### Winning the Game
- You win when only one peg remains on the board
- The game ends when no more valid moves are possible
- Try to plan your moves carefully to leave as few pegs as possible!

## Tips for Success
1. Start by planning your moves - not all sequences will lead to victory
2. Try to keep pegs connected to each other
3. Avoid isolating pegs as they can't be jumped over
4. The center of the board is often key to solving the puzzle

Good luck and enjoy the game! 