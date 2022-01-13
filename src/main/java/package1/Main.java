package package1;

public class Main {


    public static void main(String[] args) {

        GameBoard game = new GameBoard();

     //   game.createGameBoard();

      //  game.placeShips(game.playerBoard);

        game.createEnemyBoard();

        game.showEnemyBoard();

    while(true) {
    game.playerMove();
    if(game.getPlayerHit()==3){
        System.out.println("You won!!!");
        System.exit(0);
    }
    game.enemyMove();
    if(game.getEnemyHit()==3){
        System.out.println("You lost!!!");
        System.exit(0);
    }
}
    }
}