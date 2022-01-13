package package1;

import java.util.Random;
import java.util.Scanner;

public class GameBoard {

    public int[][] enemyBoard = new int[10][10];
    public int[][] playerBoard = new int[10][10];
    int playerHit=0;
    int enemyHit=0;


    int water = 0;
    int ship = 1;
    public int shipNumber = 5;

    /** PlayerBoard**/

    public int[][] createGameBoard() {


        for (int row = 0; row < playerBoard.length; row++) {

            System.out.println(" ");

            for (int col = 0; col < playerBoard.length; col++) {

                System.out.print(water + " ");
                playerBoard[row][col] = water;
            }

        }

        System.out.println("");

        return playerBoard;
    }

    public void placeShips(int[][] playerBoard) {

        int y1;
        int x1;
        this.playerBoard = playerBoard;
        int shipLength;
        char choose;
        int counter = 5;

        Scanner scanner = new Scanner(System.in);

        System.out.println("You are able to place 1x 5 SHIP, 1x 4 SHIP, 2x 3 SHIP and 1x 2 SHIP");

        while (counter > 0) {

            System.out.println("Ships left " + shipNumber);
            System.out.println("Choose your START POSITION! 10x10 FIELD");
            System.out.println("Put number! (y- position 0-9)");
            y1 = scanner.nextInt();
            System.out.println("Put next number!(x- position 0-9)");
            x1 = scanner.nextInt();
            playerBoard[y1][x1] = ship;
            showGameBoard();
            System.out.println("Choose Ship length (5,4,3,2)");
            shipLength = scanner.nextInt();

            System.out.println("Choose direction(u, d, l, r)");
            choose = scanner.next().charAt(0);

            switch (choose) {
                case 'u':
                    if (y1 + 1 - shipLength < 0) {
                        System.out.println("Cant be placed like that!");
                        playerBoard[y1][x1] = water;
                        break;
                    }
                    for (int i = 0; i < shipLength; i++) {
                        playerBoard[y1 - i][x1] = playerBoard[y1][x1];
                    }

                    showGameBoard();
                    shipNumber--;
                    counter--;
                    break;

                case 'd':

                    if (y1 - 1 + shipLength > 9) {
                        System.out.println("Cant be placed like that!");
                        playerBoard[y1][x1] = water;
                        break;
                    }
                    for (int i = 0; i < shipLength; i++) {
                        playerBoard[y1 + i][x1] = playerBoard[y1][x1];
                    }

                    showGameBoard();
                    shipNumber--;
                    counter--;
                    break;

                case 'l':

                    if (x1 + 1 - shipLength < 0) {
                        System.out.println("Cant be placed like that!");
                        playerBoard[y1][x1] = water;
                        break;
                    }
                    for (int i = 0; i < shipLength; i++) {
                        playerBoard[y1][x1 - i] = playerBoard[y1][x1];
                    }

                    showGameBoard();
                    shipNumber--;
                    counter--;
                    break;

                case 'r':

                    if (x1 - 1 + shipLength > 9) {
                        System.out.println("Cant be placed like that!");
                        playerBoard[y1][x1] = water;
                        break;
                    }

                    for (int i = 0; i < shipLength; i++) {
                        playerBoard[y1][x1 + i] = playerBoard[y1][x1];
                    }

                    showGameBoard();
                    shipNumber--;
                    counter--;
                    break;

                default:
                    break;
            }

        }

    }

    public void showGameBoard() {

        for (int row = 0; row < playerBoard.length; row++) {

            System.out.println(" ");

            for (int col = 0; col < playerBoard.length; col++) {

                System.out.print(playerBoard[row][col] + " ");

            }


        }
        System.out.println("");

    }

    /** EnemyBoard **/

    public void createEnemyBoard() {

        int random1;
        int random2;

        char doneRight = 0;
        Random zufall = new Random();

        while (doneRight == 0) {

            String aString = "";
            int column2;
            int row2;

            for (int row1 = 0; row1 < enemyBoard.length; row1++) {

                for (int col1 = 0; col1 < enemyBoard.length; col1++) {

                    enemyBoard[row1][col1] = water;
                }

            }

            random1 = zufall.nextInt(9); /** Erstellung des 2er Schiffs**/
            random2 = zufall.nextInt(9);


            if (random1 + 2 > 9) {

                random1 = random1 - 2;
            }

            for (int i = 0; i < 2; i++) {

                enemyBoard[random1 + i][random2] = ship;

            }


            random1 = zufall.nextInt(9); /** Erstellung des 5er Schiff **/
            random2 = zufall.nextInt(9);

            if (random1 + 5 > 9) {

                random1 = random1 - 5;

            }

            for (int i4 = 0; i4 < 5; i4++) {

                enemyBoard[random1 + i4][random2] = ship;

            }

            for (int u = 0; u < 2; u++) { /** Schleife für die Erstellung von 2 3er Schiffe **/


                random1 = zufall.nextInt(9);
                random2 = zufall.nextInt(9);

                if (random2 - 3 < 0) {

                    random2 = random2 + 3;
                }


                for (int i2 = 0; i2 < 3; i2++) {


                    enemyBoard[random1][random2 - i2] = ship;

                }

            }

            random1 = zufall.nextInt(9); /** Erstellung von 4er Schiff **/
            random2 = zufall.nextInt(9);

            if (random2 - 4 < 0) {

                random2 = random2 + 4;
            }
            for (int i3 = 0; i3 < 4; i3++) {

                enemyBoard[random1][random2 - i3] = ship;

            }

            for (row2 = 0; row2 < enemyBoard.length; row2++) {
                for (column2 = 0; column2 < enemyBoard[0].length; column2++) {
                    aString = aString + "" + enemyBoard[row2][column2];
                }
            }

            aString = aString.replace("0", "");
            if (aString.length() == 17) doneRight = 1;


        }
    }

    public void showEnemyBoard() {

        for (int row = 0; row < enemyBoard.length; row++) {

            System.out.println("");

            for (int col = 0; col < enemyBoard.length; col++) {

                System.out.print(enemyBoard[row][col] + " ");

            }

        }
        System.out.println("");


    }

    public void playerMove() {
        int playerMoveY;
        for (int tryagain = 0; tryagain < 1; tryagain++) {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Make your move! Enter y coordinate 0-9.");
                playerMoveY = scanner.nextInt();
            } while( !isValidCoordinate(playerMoveY));
            System.out.println("Make your move! Enter X coordinate 0-9.");
            int playerMoveX = scanner.nextInt();
            if (enemyBoard[playerMoveY][playerMoveX] == 1) {
                System.out.println("HIT!!!");
                playerHit++;
                if(playerHit==3)break;
                tryagain--;
            }
            if (enemyBoard[playerMoveY][playerMoveX] == 0) {
                System.out.println("No hit.");
            }
        }
    }
    private boolean isValidCoordinate(int playerMoveY){
        if (playerMoveY > 9 || playerMoveY < 0){
            System.out.println("Try again");
            return false;
        }
        else return true;
    }

    public void enemyMove(){
        for (int tryagain = 0; tryagain < 1; tryagain++) {
            Random enemyTry = new Random();
            int enemyMoveY = enemyTry.nextInt(9);
            int enemyMoveX = enemyTry.nextInt(9);
            if (playerBoard[enemyMoveY][enemyMoveX] == 1) {
                System.out.println("You got hit!");
                enemyHit++;
                if(enemyHit==3)break;
                tryagain--;
            }
            if (playerBoard[enemyMoveY][enemyMoveX] == 0) {
                System.out.println("You did not get hit.");
            }

        }
    }

    public int getPlayerHit() {
        return playerHit;
    }

    public int getEnemyHit() {
        return enemyHit;
    }
}
