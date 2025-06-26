import enums.Symbol;
import models.Board;
import models.Player;
import strategy.DefaultMoveStrategy;
import strategy.DefaultWinStrategy;
import strategy.MoveStrategy;
import strategy.WinStrategy;

import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private MoveStrategy moveStrategy;
    private WinStrategy winStrategy;

    public TicTacToe() {
        GameController gameController = GameController.getInstance();
        board = new Board();
        player1 = new Player("Chandler", Symbol.X);
        player2 = new Player("Joey", Symbol.O);
        currentPlayer = player1;
        moveStrategy = new DefaultMoveStrategy();
        winStrategy = new DefaultWinStrategy();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Player : " + currentPlayer.getSymbol() + "'s turn!");
            System.out.println("Enter row number (0/1/2) : ");
            int r = scanner.nextInt();
            System.out.println("Enter col number (0/1/2) : ");
            int c = scanner.nextInt();

            if (moveStrategy.isValidMove(board, r, c)) {
                board.updateBoard(r, c, currentPlayer.getSymbol());
                if (winStrategy.checkWin(board, currentPlayer.getSymbol())) {
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                    break;
                }
                if (isDraw()) {
                    System.out.println("Game is a draw!");
                    break;
                }
                switchPlayer();
                printBoard(board);
            } else {
                System.out.println("Invalid Move! Try Again!");
            }
        }
        scanner.close();
    }

    private boolean isDraw() {
        for (int i=0 ; i<board.getSIZE() ; i++) {
            for (int j=0 ; j<board.getSIZE() ; j++) {
                if (board.getCell(i, j) == Symbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer==player1) ? player2 : player1;
    }

    private void printBoard(Board board) {
        System.out.print("\n");
        for (int i=0 ; i<board.getSIZE() ; i++) {
            for (int j=0 ; j<board.getSIZE() ; j++) {
                Symbol curr = board.getGrid()[i][j];
                if (curr == Symbol.X) {
                    System.out.print(" X ");
                } else if (curr == Symbol.O) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" _ ");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
