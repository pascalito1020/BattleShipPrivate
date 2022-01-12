package package1;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class BattleshipGame {

    public static void main(String[] args) {

        GameBoard game = new GameBoard();

        game.createGameBoard();

        game.placeShips(game.playerBoard);


/**
        for (int row = 0; row < game.playerBoard.length; row++) {

            System.out.println(" ");

            for (int col = 0; col < game.playerBoard.length; col++) {

                System.out.print(game.playerBoard[row][col] + " ");

            }

        }

**/




    }
}
