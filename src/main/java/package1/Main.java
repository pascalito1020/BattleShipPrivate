package package1;

public class Main {


    public static void main(String[] args) {

        GameBoard game = new GameBoard();
/**

     game.createGameBoard();

     System.out.println("");

        game.placeShips(game.playerBoard);



 for (int row = 0; row < game.playerBoard.length; row++) {

 System.out.println(" ");

 for (int col = 0; col < game.playerBoard.length; col++) {

 System.out.print(game.playerBoard[row][col] + " ");

 }

 }
 **/

        game.createEnemyBoard();
        game.showEnemyBoard();


    }
}