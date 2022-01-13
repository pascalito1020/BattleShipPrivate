package package1;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        char mode;
        GameBoard game = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("----WELCOME TO BATTLESHIP----");
        System.out.println("Choose (p) for Player vs. Player Mode");
        System.out.println("Choose (c) for Player vs. Computer Mode");
        mode = scanner.next().charAt(0);

        switch (mode) {

            case 'p':
                System.out.println("Not available");
                break;

            case 'c':

                //  game.createGameBoard();
                game.showGameBoard();
                game.placeShips();
                game.createEnemyBoard();
                // game.showEnemyBoard();

                while (true) {

                    game.showConsoleBoard();
                    game.playerMove();

                    if (game.getPlayerHit() == 3) {
                        System.out.println("You won!!!");
                        System.exit(0);
                    }

                    game.enemyMove();

                    if (game.getEnemyHit() == 3) {
                        System.out.println("You lost!!!");
                        System.exit(0);

                    }

                }

            default:
                break;


        }


    }
}