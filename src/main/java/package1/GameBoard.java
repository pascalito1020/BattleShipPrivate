package package1;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;


public class GameBoard {

    public char[][] enemyBoard = new char[10][10];

    public char[][] playerBoard = new char[10][10];
    char water = 'o';
    char ship = 'X';
    public int shipNumber = 5;

    public char[][] createGameBoard() {


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

    public void placeShips(char[][] playerBoard) {

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
                    if (y1+1 - shipLength < 0) {
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

                    if (y1-1 + shipLength > 9) {
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

                    if (x1+1 - shipLength < 0) {
                        System.out.println("Cant be placed like that!");
                        playerBoard[y1][x1] = water;
                        break;
                    }
                    for (int i = 0; i < shipLength; i++) {
                        playerBoard[y1][x1-i] = playerBoard[y1][x1];
                    }

                    showGameBoard();
                    shipNumber--;
                    counter--;
                    break;

                case 'r':

                    if (x1-1 + shipLength > 9) {
                        System.out.println("Cant be placed like that!");
                        playerBoard[y1][x1] = water;
                        break;
                    }

                    for (int i = 0; i < shipLength; i++) {
                        playerBoard[y1][x1+i] = playerBoard[y1][x1];
                    }

                    showGameBoard();
                    shipNumber--;
                    counter--;
                    break;

                default:
                    break;
            }

        }

        System.out.println("All ships placed!");

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



}
