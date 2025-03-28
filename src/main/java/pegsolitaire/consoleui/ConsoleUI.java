package pegsolitaire.consoleui;

import pegsolitaire.core.*;
import java.util.Scanner;

public class ConsoleUI {
    private Field field;
    private Scanner scanner;

    public ConsoleUI() {
        field = new Field();
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Ласкаво просимо до гри Peg Solitaire!");
        System.out.println("Мета гри: залишити тільки одну фішку на полі.");
        System.out.println("Введіть хід у форматі: fromRow fromCol toRow toCol");
        System.out.println("(або 'quit' для виходу)\n");

        while (true) {
            displayBoard();
            System.out.println("\nЗалишилось фішок: " + countPegs());

            if (Validator.isGameOver(field)) {
                System.out.println("\nГра закінчена!");
                if (countPegs() == 1) {
                    System.out.println("Вітаємо! Ви перемогли!");
                } else {
                    System.out.println("Спробуйте ще раз! Залишилось " + countPegs() + " фішок.");
                }
                break;
            }

            System.out.print("\nВведіть ваш хід: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("Дякуємо за гру!");
                break;
            }

            try {
                String[] parts = input.split("\\s+");
                if (parts.length != 4) {
                    throw new NumberFormatException();
                }

                int fromRow = Integer.parseInt(parts[0]);
                int fromCol = Integer.parseInt(parts[1]);
                int toRow = Integer.parseInt(parts[2]);
                int toCol = Integer.parseInt(parts[3]);

                Move move = new Move(fromRow, fromCol, toRow, toCol);
                if (Validator.isValidMove(field, move)) {
                    field.movePeg(fromRow, fromCol, toRow, toCol);
                } else {
                    System.out.println("Неправильний хід! Спробуйте ще раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неправильний формат вводу! Використовуйте формат: fromRow fromCol toRow toCol");
            }
        }

        scanner.close();
    }

    private void displayBoard() {
        System.out.println("  0 1 2 3 4 5 6");
        for (int i = 0; i < field.getSize(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < field.getSize(); j++) {
                Tile tile = field.getBoard()[i][j];
                switch (tile.getState()) {
                    case PEG:
                        System.out.print("o ");
                        break;
                    case EMPTY:
                        System.out.print(". ");
                        break;
                    case SELECTED:
                        System.out.print("* ");
                        break;
                }
            }
            System.out.println();
        }
    }

    private int countPegs() {
        int count = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (field.getBoard()[i][j].getState() == TileState.PEG) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ConsoleUI game = new ConsoleUI();
        game.play();
    }
} 