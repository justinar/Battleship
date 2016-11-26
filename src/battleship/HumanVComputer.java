package battleship;

import battleship.players.*;
import java.util.Scanner;

public class HumanVComputer {

    public static void main(String args[]) {

        //java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Welcome to Battleship!");

        BattleshipPlayer self = new jrivera2_BattleshipPlayer();
        BattleshipPlayer comp = new dumb_BattleshipPlayer();

        Board ownBoard = self.hideShips();

        Board computerBoard = comp.hideShips();

        char[][] computerMap = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                computerMap[i][j] = '.';
            }
        }

        while (!ownBoard.isComplete() && !computerBoard.isComplete()) {

            //System.out.print("Where to fire? ");
            //int firedRow = input.nextInt();
            //int firedCol = input.nextInt();
            computerBoard.firedAtThisRound = false;
            ownBoard.firedAtThisRound = false;
            //computerMap[firedRow][firedCol] =
            //computerBoard.fireAt(firedRow, firedCol);
            self.go(computerBoard);
            comp.go(ownBoard);
            /*
            System.out.println("Here's your board, human:\n" + ownBoard);
            /*
            System.out.println("Here's its board, as far as you know:");
            System.out.println("  0123456789");
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 10; j++) {
                    System.out.print(computerMap[i][j]);
                }
                System.out.println();
            }
             */
        }
        self.reset();

    }
    /*
    static void placeShip(String shipName, char humanMap[][]) {

        java.util.Scanner input = new java.util.Scanner(System.in);

        char shipChar = shipName.charAt(0);
        int numSpaces = 0;
        switch (shipChar) {
            case 'A':
                numSpaces = 5;
                break;
            case 'B':
                numSpaces = 4;
                break;
            case 'D':
                numSpaces = 3;
                break;
            case 'S':
                numSpaces = 3;
                break;
            case 'P':
                numSpaces = 2;
                break;
            default:
                System.out.println("BLOW CHUNKS.");
                System.exit(1);
        }

        boolean validShipPlacement = false;

        while (!validShipPlacement) {
            System.out.print("Where do you want place your " + shipName
                    + "? ");
            int startingRow = input.nextInt();
            int startingCol = input.nextInt();

            System.out.print("(L)eft, (R)ight, (U)p, or (D)own? ");
            String direction = input.next();

            try {
                for (int i = 0; i < numSpaces; i++) {
                    switch (direction) {
                        case "L":
                            if (humanMap[startingRow][startingCol - i] != ' ') {
                                throw new Exception();
                            }
                            humanMap[startingRow][startingCol - i] = shipChar;
                            break;
                        case "R":
                            if (humanMap[startingRow][startingCol + i] != ' ') {
                                throw new Exception();
                            }
                            humanMap[startingRow][startingCol + i] = shipChar;
                            break;
                        case "U":
                            if (humanMap[startingRow - i][startingCol] != ' ') {
                                throw new Exception();
                            }
                            humanMap[startingRow - i][startingCol] = shipChar;
                            break;
                        case "D":
                            if (humanMap[startingRow + i][startingCol] != ' ') {
                                throw new Exception();
                            }
                            humanMap[startingRow + i][startingCol] = shipChar;
                            break;
                        default:
                            System.out.println("BLOW CHUNKS.");
                            System.exit(1);
                    }
                }
                validShipPlacement = true;
            } catch (Exception e) {
                System.out.println("WHOA. That does not fit there bub.");
                System.out.println("Try again!!");
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (humanMap[i][j] == shipChar) {
                            humanMap[i][j] = ' ';
                        }
                    }
                }
            }
        }

        System.out.println("So far, your board is like this: ");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(
                        humanMap[i][j] == ' ' ? '.' : humanMap[i][j]);
            }
            System.out.println();
        }
    }
     */
}
