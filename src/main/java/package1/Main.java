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

                System.out.println("You are playing against another Player. Firstly, place your ships!");
                game.createGameBoard();
                game.showGameBoard();
                game.placeShips();

                /* WEITERES NOCH IN BEARBEITUNG */

                break;

            case 'c':
                System.out.println("You are playing against a computer. Firstly, place your ships!");
                game.createGameBoard();   /* Befüllt das leere Schlachtfeld mit 0ern */
                game.showGameBoard();     /* Zeigt das eigene Schlachtfeld an */
                game.placeShips();        /* Methode für das Platzieren der eignen Schiffe */
                game.createEnemyBoard();  /* Generiert das Computer-Schlachtfeld */
                //game.showEnemyBoard();  /* Zeigt das computer-generierte Schlachtfeld an */

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