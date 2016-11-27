package battleship;

import battleship.players.*;
import java.util.Scanner;

public class HumanVComputer {

    public static void main(String args[]) {

        //java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Welcome to Battleship!");

        BattleshipPlayer self = new jrivera2_BattleshipPlayer();
        BattleshipPlayer comp = new dumb_BattleshipPlayer();

        int human = 0;
        int ai = 0;

        for (int z = 0; z < 2; z++) {

            Board ownBoard = self.hideShips();

            Board computerBoard = comp.hideShips();

            char[][] computerMap = new char[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    computerMap[i][j] = '.';
                }
            }

            while (!ownBoard.isComplete() && !computerBoard.isComplete()) {
                computerBoard.firedAtThisRound = false;
                ownBoard.firedAtThisRound = false;
                self.go(computerBoard);
                comp.go(ownBoard);
            }
            if (ownBoard.isComplete()) {
                System.out.println(++ai);
            } else {
                System.out.println(++human);
            }
            self.reset();
        }
        System.out.printf("You won %d games%nThe AI won %d games%n",human,ai);
    }
}
