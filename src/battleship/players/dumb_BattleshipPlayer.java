package battleship.players;

import battleship.Board;
import java.util.Random;

public class dumb_BattleshipPlayer implements BattleshipPlayer {

    int[][] pastShot = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    char[][] myBoard = new char[10][10];
    Random rng = new Random();

    /**
     * hideShips - This method is called once at the beginning of each game when
     * you need to hide your ships.
     *
     * You must return a valid Board object. See that class for details. Note
     * carefully: under *no* circumstances should you return the same board
     * twice in a row; i.e., two successive calls to your hideShips() method
     * must always return *different* answers!
     */
    public Board hideShips() {
        fill(myBoard);
        for (int i = 0; i < 3; i++) {
            myBoard[0][i] = 'D';
        }
        for (int i = 0; i < 5; i++) {
            myBoard[2][i] = 'A';
        }
        for (int i = 5; i < 7; i++) {
            myBoard[4][i] = 'P';
        }
        for (int i = 0; i < 4; i++) {
            myBoard[6][i] = 'B';
        }
        for (int i = 6; i < 9; i++) {
            myBoard[8][i] = 'S';
        }
        Board mien = null;
        try {
            mien = new Board(myBoard);
        } catch (Exception e) {
            System.out.println("Oh poopy %n" + e);
            System.exit(1);
        }
        return mien;
    }

    /**
     * go - This method is called repeatedly throughout the game, every time
     * it's your turn.
     *
     * When it's your turn, and go() is called, you must call fireAt() on the
     * Board object which is passed as a parameter. You must do this exactly
     * *once*: trying to fire more than once during your turn will be detected
     * as cheating.
     */
    public void go(Board opponentsBoard) {
        opponentsBoard.fireAt(rng.nextInt(10), rng.nextInt(10));
    }

    /**
     * reset - This method is called when a game has ended and a new game is
     * beginning. It gives you a chance to reset any instance variables you may
     * have created, so that your BattleshipPlayer starts fresh.
     */
    public void reset() {
        // RESET YOUR OBJECT HERE
    }

    private void fill(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 0;
            }
        }
    }

    private void fill(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ' ';
            }
        }
    }
}