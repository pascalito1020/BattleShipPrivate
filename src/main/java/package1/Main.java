package package1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char mode;
        boolean modeRight=true;
        GameBoard game = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("----WELCOME TO BATTLESHIP----");
            System.out.println("Type 'P' for Player vs. Player Mode");
            System.out.println("Type 'C' for Player vs. Computer Mode");
            mode = scanner.next().charAt(0);
            if(mode=='p'||mode=='c')modeRight=false;
        }while(modeRight);

        switch (mode) {

            case 'p':

                System.out.println("You are playing against another Player. To begin, place your ships!");
                game.createGameBoard();
                game.showGameBoard(game.playerBoard);
                game.placeShips();
                System.out.println("Second Player should now place his ships!");
                game.showGameBoard(game.secondPlayerBoard);
                game.placeShips2();

                while (true) {

                    game.showConsoleBoard();
                    game.playerVsPlayer1();

                    if (game.getPlayerHit() == 17) {
                        System.out.println("Player1 won!!!");
                        System.exit(0);
                    }

                    game.showConsoleBoard2();
                    game.playerVsPlayer2();

                    if (game.getEnemyHit() == 17) {
                        System.out.println("Player2 won!!!");
                        System.exit(0);

                    }

                }


            case 'c':
                System.out.println("You are playing against a computer. To begin, place your ships!");
                game.createGameBoard();   /* Befüllt das leere Schlachtfeld mit 0ern */
                game.showGameBoard(game.playerBoard);     /* Zeigt das eigene Schlachtfeld an */
                game.placeShips();        /* Methode für das Platzieren der eignen Schiffe */
                game.createEnemyBoard();  /* Generiert das Computer-Schlachtfeld */
                //game.showEnemyBoard();  /* Zeigt das computer-generierte Schlachtfeld an */

                while (true) {

                    game.showConsoleBoard();
                    game.playerMove();

                    if (game.getPlayerHit() == 17) {
                        System.out.println("VICTORY!");
                        System.exit(0);
                    }

                    game.enemyMove();

                    if (game.getEnemyHit() == 17) {
                        System.out.println("DEFEAT!");
                        System.exit(0);

                    }

                }

            default:
                System.out.println("Not an option.");
                break;



        }


    }
}