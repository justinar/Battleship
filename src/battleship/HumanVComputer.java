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
            self.reset();
            comp.reset();

            Board ownBoard = self.hideShips();
            Board computerBoard = comp.hideShips();
            
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
        }

        System.out.printf("You won %d games%nThe AI won %d games%n", human, ai);
    }
}
