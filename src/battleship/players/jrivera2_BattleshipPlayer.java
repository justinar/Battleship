package battleship.players;

import battleship.Board;
import java.util.Random;
import java.util.ArrayList;

public class jrivera2_BattleshipPlayer implements BattleshipPlayer {

    private int[][] pastShot = {
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
    private int[][] oldBoards = {
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
    private int[][] currentBoard = {
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
    private int[][] lastBoard = {
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
    private int[][] lastestBoard = {
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
    private int[][] fallBack = {
        {1, 3, 5, 7, 9},
        {0, 2, 4, 6, 8},
        {1, 3, 5, 7, 9},
        {0, 2, 4, 6, 8},
        {1, 3, 5, 7, 9},
        {0, 2, 4, 6, 8},
        {1, 3, 5, 7, 9},
        {0, 2, 4, 6, 8},
        {1, 3, 5, 7, 9},
        {0, 2, 4, 6, 8}};

    private char[][] myBoard = new char[10][10];
    private char[][] currentCharBoard = new char[10][10];
    private Random rng = new Random();
    Board mien = null;
    private int rounds = 0;

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
        fill(currentCharBoard);
        fill(currentBoard);
        placeShip(setLoc(findRandLoc(), 2), false);
        placeShip(setLoc(findRandLoc(), 3), false);
        placeShip(setLoc(findRandLoc(), 3), true);
        placeShip(setLoc(findRandLoc(), 4), false);
        placeShip(setLoc(findRandLoc(), 5), false);

        try {
            mien = new Board(myBoard);
        } catch (Exception e) {
            System.out.printf("Oh poopy %n" + e);
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
        int[] shot;
        if (rounds < 1) {
            shot = randFire();
            while (currentCharBoard[shot[0]][shot[1]] == 42
                    && currentCharBoard[shot[0]][shot[1]] > 64) {
                shot = randFire();
            }
        } else {
            shot = fire();
            while (currentCharBoard[shot[0]][shot[1]] == 42
                    || currentCharBoard[shot[0]][shot[1]] > 64) {
                shot = fire();
            }
        }
        char temp = opponentsBoard.fireAt(shot[0], shot[1]);
        currentCharBoard[shot[0]][shot[1]] = (temp == 32 ? 46 : temp);
        if (currentCharBoard[shot[0]][shot[1]] != 46) {
            currentBoard[shot[0]][shot[1]] = 1;
        }

        sunk();
        rounds++;
        //print();
    }

    /**
     * reset - This method is called when a game has ended and a new game is
     * beginning. It gives you a chance to reset any instance variables you may
     * have created, so that your BattleshipPlayer starts fresh.
     */
    public void reset() {
        int count = 0;
        try {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    //move boards
                    if (lastestBoard[i][j] != 0) {
                        oldBoards[i][j]++;
                    }
                    //find where I was shot
                    if (mien.toString().charAt(count) == '\u25ae') {
                        pastShot[i][j]++;
                    } else if (mien.toString().charAt(count) == 10) {
                        count++;
                        if (mien.toString().charAt(count) == '\u25ae') {
                            pastShot[i][j]++;
                        }
                    }
                    count++;
                }
            }
        } catch (Exception e) {
        }
        copy(lastBoard, lastestBoard);
        copy(currentBoard, lastBoard);
        //print();
        rounds = 0;
    }
    //Diagnosticy thingy

    private void print() {
        System.out.println("Here's your board:\n" + mien);
        System.out.println("Here's its board, as far as you know:");
        System.out.println("X 0123456789");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(currentCharBoard[i][j]);
            }
            System.out.println();
        }
        System.out.println("Here are it's past shots");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(pastShot[i][j]);
            }
            System.out.println();
        }
        System.out.println("Here are it's old board");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(oldBoards[i][j]);
            }
            System.out.println();
        }
        System.out.println(rounds);
    }

    //Random burn
    private int[] randFire() {
        int[] shot = new int[2];
        int row = rng.nextInt(10);
        shot[0] = row;
        shot[1] =rng.nextInt(10);
        return shot;
    }

//Burn baby, burn
    private int[] fire() {
        ArrayList<int[]> bestShot = new ArrayList<>();

        bestShot.add(randFire());
        while (currentCharBoard[bestShot.get(0)[0]][bestShot.get(0)[1]] == 42
                && currentCharBoard[bestShot.get(0)[0]][bestShot.get(0)[1]] > 64) {
            bestShot.set(0, randFire());
        }

        int rnd[][] = findRandLoc();

        ArrayList<int[]> potentialShot = new ArrayList<>();

        for (int i = 0; i < rnd.length; i++) {
            if (currentCharBoard[rnd[i][0]][rnd[i][1]] < 35) {
                potentialShot.add(rnd[i]);
            }
        }

        while (potentialShot.isEmpty()) {
            rnd = findRandLoc();
            for (int i = 0; i < rnd.length; i++) {
                if (currentCharBoard[rnd[i][0]][rnd[i][1]] < 35) {
                    potentialShot.add(rnd[i]);
                }
            }
        }

        for (int i = 0; i < potentialShot.size(); i++) {
            int r = potentialShot.get(i)[0];
            int c = potentialShot.get(i)[1];
            int nr = bestShot.get(0)[0];
            int nc = bestShot.get(0)[0];
            if (lastestBoard[r][c]*2+oldBoards[r][c]>lastestBoard[nr][nc]*2+oldBoards[nr][nc]) {
                bestShot.add(0,potentialShot.get(i));
            }
        }
        return bestShot.get(0);
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
//deep copy

    private void copy(int[][] arr1, int[][] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            System.arraycopy(arr1[i], 0, arr2[i], 0, arr1.length);
        }
    }

    //find 5 random locations
    private int[][] findRandLoc() {
        int r1 = rng.nextInt(10);
        int r2 = rng.nextInt(10);
        int r3 = rng.nextInt(10);
        int r4 = rng.nextInt(10);
        int r5 = rng.nextInt(10);
        int c1 = rng.nextInt(10);
        int c2 = rng.nextInt(10);
        int c3 = rng.nextInt(10);
        int c4 = rng.nextInt(10);
        int c5 = rng.nextInt(10);

        int[][] loc = {
            {r1, r2, r3, r4, r5},
            {c1, c2, c3, c4, c5}};
        return loc;
    }
//place ships based on where they havn't shot

    private int[][] setLoc(int[][] rand, int length) {
        ArrayList<int[][]> valid = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            //check ability to go right
            try {
                if (pastShot[rand[0][j] + length - 1][rand[1][j]] != -1) {
                    int[][] v = new int[2][length];
                    for (int i = 0; i < length; i++) {
                        v[0][i] = rand[0][j] + i;
                        v[1][i] = rand[1][j];
                        if (myBoard[v[0][i]][v[1][i]] != ' ') {
                            throw new Exception();
                        }
                    }
                    valid.add(v);
                }
            } catch (Exception e) {
            }
            //check ability to go down
            try {
                if (pastShot[rand[0][j]][rand[1][j] + length - 1] != -1) {
                    int[][] v = new int[2][length];
                    for (int i = 0; i < length; i++) {
                        v[0][i] = rand[0][j];
                        v[1][i] = rand[1][j] + i;
                        if (myBoard[v[0][i]][v[1][i]] != ' ') {
                            throw new Exception();
                        }
                    }
                    valid.add(v);
                }
            } catch (Exception e) {
            }
            //check ability to go left
            try {
                if (pastShot[rand[0][j] - length + 1][rand[1][j]] != -1) {
                    int[][] v = new int[2][length];
                    for (int i = 0; i < length; i++) {
                        v[0][i] = rand[0][j] - i;
                        v[1][i] = rand[1][j];
                        if (myBoard[v[0][i]][v[1][i]] != ' ') {
                            throw new Exception();
                        }
                    }
                    valid.add(v);
                }
            } catch (Exception e) {
            }
            //check ability to go up
            try {
                if (pastShot[rand[0][j]][rand[1][j] - length + 1] != -1) {
                    int[][] v = new int[2][length];
                    for (int i = 0; i < length; i++) {
                        v[0][i] = rand[0][j];
                        v[1][i] = rand[1][j] - i;
                        if (myBoard[v[0][i]][v[1][i]] != ' ') {
                            throw new Exception();
                        }
                    }
                    valid.add(v);
                }
            } catch (Exception e) {
            }
        }
        //find set with lowest shot density
        int best = valid.size() - 1;
        for (int i = 0; i < valid.size() - 1; i++) {
            if (sum(valid.get(best)) > sum(valid.get(i))) {
                best = i;
            }
        }
        try {
            int[][] loc = valid.get(best);
            return loc;
        } catch (Exception e) {
            return setLoc(findRandLoc(), length);
        }
    }

    private int sum(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr[0].length; i++) {
            sum += pastShot[arr[0][i]][arr[1][i]];
        }
        return sum;
    }
//put ship at said location

    private void placeShip(int[][] loc, boolean sub) {
        char ship = ' ';
        switch (loc[0].length) {
            case 2:
                ship = 'P';
                break;
            case 3:
                if (sub) {
                    ship = 'S';
                } else {
                    ship = 'D';
                }
                break;
            case 4:
                ship = 'B';
                break;
            case 5:
                ship = 'A';
                break;
            default:
                System.out.println("Nice job numb nuts");
                break;
        }
        for (int i = 0; i < loc[0].length; i++) {
            myBoard[loc[0][i]][loc[1][i]] = ship;
        }
    }
//block out sunken ships to avoid confusing the program

    private void sunk() {
        int a = 0;
        int b = 0;
        int s = 0;
        int d = 0;
        int p = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                switch (currentCharBoard[i][j]) {
                    case 'P':
                        p++;
                        break;
                    case 'S':
                        s++;
                        break;
                    case 'D':
                        d++;
                        break;
                    case 'B':
                        b++;
                        break;
                    case 'A':
                        a++;
                        break;
                    default:
                        break;
                }
            }
        }
        if (a == 5) {
            replace('A');
        }
        if (b == 4) {
            replace('B');
        }
        if (d == 3) {
            replace('D');
        }
        if (s == 3) {
            replace('S');
        }
        if (p == 2) {
            replace('P');
        }
    }

    private void replace(char c) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (currentCharBoard[i][j] == c) {
                    currentCharBoard[i][j] = '*';
                }
            }
        }
    }
}
