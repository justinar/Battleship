package battleship.players;

import battleship.Board;
import java.util.Random;

public class dumb_BattleshipPlayer implements BattleshipPlayer {

    char[][] myBoard = new char[10][10];
    Random rng = new Random();
    
    public Board hideShips() {
        fill(myBoard);
        for (int i = 6; i < 9; i++) {
            myBoard[0][i] = 'D';
        }
        for (int i = 0; i < 5; i++) {
            myBoard[2][i] = 'A';
        }
        for (int i = 5; i < 7; i++) {
            myBoard[4][i] = 'P';
        }
        for (int i = 5; i < 9; i++) {
            myBoard[6][i] = 'B';
        }
        for (int i = 6; i < 9; i++) {
            myBoard[9][i] = 'S';
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

    public void go(Board opponentsBoard) {
        opponentsBoard.fireAt(rng.nextInt(10), rng.nextInt(10));
    }

    public void reset() {
    }

    private void fill(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ' ';
            }
        }
    }
}