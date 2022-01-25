package package1;

import java.util.Random;
import java.util.Scanner;

public class GameBoard {

    public int[][] enemyBoard = new int[10][10];

    public int[][] playerBoard = new int[10][10];

    public int[][] secondPlayerBoard = new int[10][10];

    public int[][] consoleBoard = new int[10][10]; /** Array für die Anzeige der getroffenen Treffer **/
    public int[][] consoleBoard2 = new int[10][10]; /** Array für die Anzeige der getroffenen Treffer **/


    int playerHit=0;
    int enemyHit=0;
    int water = 0;
    int ship = 1;

    public int shipNumber = 5;

    public void showConsoleBoard() {
        int c0 = 0;

        System.out.print("Y/X 0 1 2 3 4 5 6 7 8 9");

        for (int row = 0; row < consoleBoard.length; row++) {

            System.out.println(" ");
            System.out.print(c0+":  ");
            c0++;
            for (int col = 0; col < consoleBoard.length; col++) {

                System.out.print(consoleBoard[row][col] + " ");

            }

        }
        System.out.println("");

    }

    public void showConsoleBoard2() {
        int c0 = 0;

        System.out.print("Y/X 0 1 2 3 4 5 6 7 8 9");

        for (int row = 0; row < consoleBoard2.length; row++) {

            System.out.println(" ");
            System.out.print(c0+":  ");
            c0++;
            for (int col = 0; col < consoleBoard2.length; col++) {

                System.out.print(consoleBoard2[row][col] + " ");

            }

        }
        System.out.println("");

    }

    /** PlayerBoard**/

    public void createGameBoard() {


        for (int row = 0; row < playerBoard.length; row++) {

            for (int col = 0; col < playerBoard.length; col++) {

                playerBoard[row][col] = water;
            }

        }

        System.out.println("");

    } /** Methode um PlayerBoard zu befüllen **/

    public void placeShips() {

        int y1;
        int x1;
        int shipLength;
        char choose;
        int counter = 5;
        boolean chooseRight=true;
        boolean shipLengthRight=true;

        int []counterArray = new int[]{1, 1, 2, 1};

        Scanner scanner = new Scanner(System.in);

        while (counter > 0) {

            System.out.println("You are able to place "+ counterArray[0] +"x 5 SHIP, " + counterArray[1] +"x 4 SHIP, "+ counterArray[2] +"x 3 SHIP and " + counterArray[3] +"x 2 SHIP");

            System.out.println("Ships left " + shipNumber);
            System.out.println("Choose your START POSITION! 10x10 FIELD");

            do {
                System.out.println("Put number! (y- position 0-9)");
                y1 = getInput();
            } while( !isValidCoordinate(y1));

            do {
                System.out.println("Put number! (x- position 0-9)");
                x1 = getInput();
            } while( !isValidCoordinate(x1));

            playerBoard[y1][x1] = ship;
            showGameBoard(playerBoard);
            do {
                System.out.println("Choose Ship length (5,4,3,2)");
                shipLength = getInput();
                if(shipLength<=5&&shipLength>2) shipLengthRight=false;
            }while(shipLengthRight);

            if(shipLength == 5){    /** Counter für den Anzeige, welche Schiffe man noch platzieren kann und welche nicht (siehe 1. System.out.println **/
                counterArray[0]--;
            }else if(shipLength == 4) {
                counterArray[1]--;
            }else if(shipLength == 3) {
                counterArray[2]--;
            }else if(shipLength == 2) {
                counterArray[3]--;
            }
            do {
                System.out.println("Choose direction(u (up), d (down), l (left), r (right)");
                choose = scanner.next().charAt(0);
                if(choose=='u'||choose=='d'||choose=='l'||choose=='r') chooseRight=false;
            }while(chooseRight);

            switch (choose) {
                case 'u':
                    if (y1 + 1 - shipLength < 0) {
                        System.out.println("Cant be placed like that!");
                        playerBoard[y1][x1] = water;
                        if(shipLength == 5){
                            counterArray[0]++;
                        }else if(shipLength == 4) {
                            counterArray[1]++;
                        }else if(shipLength == 3) {
                            counterArray[2]++;
                        }else if(shipLength == 2) {
                            counterArray[3]++;
                        }
                        break;
                    }
                    for (int i = 0; i < shipLength; i++) {
                        playerBoard[y1 - i][x1] = playerBoard[y1][x1];
                    }

                    showGameBoard(playerBoard);
                    shipNumber--;
                    counter--;
                    break;

                case 'd':

                    if (y1 - 1 + shipLength > 9) {
                        System.out.println("Cant be placed like that!");
                        playerBoard[y1][x1] = water;
                        if(shipLength == 5){
                            counterArray[0]++;
                        }else if(shipLength == 4) {
                            counterArray[1]++;
                        }else if(shipLength == 3) {
                            counterArray[2]++;
                        }else if(shipLength == 2) {
                            counterArray[3]++;
                        }
                        break;
                    }
                    for (int i = 0; i < shipLength; i++) {
                        playerBoard[y1 + i][x1] = playerBoard[y1][x1];
                    }

                    showGameBoard(playerBoard);
                    shipNumber--;
                    counter--;
                    break;

                case 'l':

                    if (x1 + 1 - shipLength < 0) {
                        System.out.println("Cant be placed like that!");
                        playerBoard[y1][x1] = water;
                        if(shipLength == 5){
                            counterArray[0]++;
                        }else if(shipLength == 4) {
                            counterArray[1]++;
                        }else if(shipLength == 3) {
                            counterArray[2]++;
                        }else if(shipLength == 2) {
                            counterArray[3]++;
                        }
                        break;
                    }
                    for (int i = 0; i < shipLength; i++) {
                        playerBoard[y1][x1 - i] = playerBoard[y1][x1];
                    }

                    showGameBoard(playerBoard);
                    shipNumber--;
                    counter--;
                    break;

                case 'r':

                    if (x1 - 1 + shipLength > 9) {
                        System.out.println("Cant be placed like that!");
                        playerBoard[y1][x1] = water;
                        if(shipLength == 5){
                            counterArray[0]++;
                        }else if(shipLength == 4) {
                            counterArray[1]++;
                        }else if(shipLength == 3) {
                            counterArray[2]++;
                        }else if(shipLength == 2) {
                            counterArray[3]++;
                        }
                        break;
                    }

                    for (int i = 0; i < shipLength; i++) {
                        playerBoard[y1][x1 + i] = playerBoard[y1][x1];
                    }

                    showGameBoard(playerBoard);
                    shipNumber--;
                    counter--;
                    break;

                default:
                    break;
            }

        }

    } /** Methode für das Befüllen des PlayerBoard Arrays mit eigenen Schiffen **/

    public void showGameBoard(int[][] arrayP) {

        int c = 0;

        System.out.print("Y/X 0 1 2 3 4 5 6 7 8 9");

        for (int row = 0; row < arrayP.length; row++) {

            System.out.println(" ");
            System.out.print(c+":  ");
            c++;
            for (int col = 0; col < arrayP.length; col++) {

                System.out.print(arrayP[row][col] + " ");

            }


        }
        System.out.println("");

    } /** Gibt das GameBoard aus **/

    public void placeShips2() {

        shipNumber = 5;

        int y1;
        int x1;
        int shipLength;
        char choose;
        int counter = 5;
        boolean chooseRight=true;
        boolean shipLengthRight=true;

        int []counterArray = new int[]{1, 1, 2, 1};

        Scanner scanner = new Scanner(System.in);

        while (counter > 0) {

            System.out.println("You are able to place "+ counterArray[0] +"x 5 SHIP, " + counterArray[1] +"x 4 SHIP, "+ counterArray[2] +"x 3 SHIP and " + counterArray[3] +"x 2 SHIP");

            System.out.println("Ships left " + shipNumber);
            System.out.println("Choose your START POSITION! 10x10 FIELD");

            do {
                System.out.println("Put number! (y- position 0-9)");
                y1 = getInput();
            } while( !isValidCoordinate(y1));

            do {
                System.out.println("Put number! (x- position 0-9)");
                x1 = getInput();
            } while( !isValidCoordinate(x1));

            secondPlayerBoard[y1][x1] = ship;
            showGameBoard(secondPlayerBoard);
            do {
                System.out.println("Choose Ship length (5,4,3,2)");
                shipLength = getInput();
                if(shipLength<=5&&shipLength>2) shipLengthRight=false;
            }while(shipLengthRight);

            if(shipLength == 5){    /** Counter für den Anzeige, welche Schiffe man noch platzieren kann und welche nicht (siehe 1. System.out.println **/
                counterArray[0]--;
            }else if(shipLength == 4) {
                counterArray[1]--;
            }else if(shipLength == 3) {
                counterArray[2]--;
            }else if(shipLength == 2) {
                counterArray[3]--;
            }

            do {
                System.out.println("Choose direction(u (up), d (down), l (left), r (right)");
                choose = scanner.next().charAt(0);
                if(choose=='u'||choose=='d'||choose=='l'||choose=='r') chooseRight=false;
            }while(chooseRight);

            switch (choose) {
                case 'u':
                    if (y1 + 1 - shipLength < 0) {
                        System.out.println("Cant be placed like that!");
                        secondPlayerBoard[y1][x1] = water;
                        if(shipLength == 5){
                            counterArray[0]++;
                        }else if(shipLength == 4) {
                            counterArray[1]++;
                        }else if(shipLength == 3) {
                            counterArray[2]++;
                        }else if(shipLength == 2) {
                            counterArray[3]++;
                        }
                        break;
                    }
                    for (int i = 0; i < shipLength; i++) {
                        secondPlayerBoard[y1 - i][x1] = secondPlayerBoard[y1][x1];
                    }

                    showGameBoard(secondPlayerBoard);
                    shipNumber--;
                    counter--;
                    break;

                case 'd':

                    if (y1 - 1 + shipLength > 9) {
                        System.out.println("Cant be placed like that!");
                        secondPlayerBoard[y1][x1] = water;
                        if(shipLength == 5){
                            counterArray[0]++;
                        }else if(shipLength == 4) {
                            counterArray[1]++;
                        }else if(shipLength == 3) {
                            counterArray[2]++;
                        }else if(shipLength == 2) {
                            counterArray[3]++;
                        }
                        break;
                    }
                    for (int i = 0; i < shipLength; i++) {
                        secondPlayerBoard[y1 + i][x1] = secondPlayerBoard[y1][x1];
                    }

                    showGameBoard(secondPlayerBoard);
                    shipNumber--;
                    counter--;
                    break;

                case 'l':

                    if (x1 + 1 - shipLength < 0) {
                        System.out.println("Cant be placed like that!");
                        secondPlayerBoard[y1][x1] = water;
                        if(shipLength == 5){
                            counterArray[0]++;
                        }else if(shipLength == 4) {
                            counterArray[1]++;
                        }else if(shipLength == 3) {
                            counterArray[2]++;
                        }else if(shipLength == 2) {
                            counterArray[3]++;
                        }
                        break;
                    }
                    for (int i = 0; i < shipLength; i++) {
                        secondPlayerBoard[y1][x1 - i] = secondPlayerBoard[y1][x1];
                    }

                    showGameBoard(secondPlayerBoard);
                    shipNumber--;
                    counter--;
                    break;

                case 'r':

                    if (x1 - 1 + shipLength > 9) {
                        System.out.println("Cant be placed like that!");
                        secondPlayerBoard[y1][x1] = water;
                        if(shipLength == 5){
                            counterArray[0]++;
                        }else if(shipLength == 4) {
                            counterArray[1]++;
                        }else if(shipLength == 3) {
                            counterArray[2]++;
                        }else if(shipLength == 2) {
                            counterArray[3]++;
                        }
                        break;
                    }

                    for (int i = 0; i < shipLength; i++) {
                        secondPlayerBoard[y1][x1 + i] = secondPlayerBoard[y1][x1];
                    }

                    showGameBoard(secondPlayerBoard);
                    shipNumber--;
                    counter--;
                    break;

                default:
                    break;
            }

        }


    }

    public void playerVsPlayer1() {

        int playerMoveY;
        int playerMoveX;

        for(int tryagain = 0; tryagain < 1; tryagain++) {

            do {
                System.out.println("Player 1 should make his move ! (Y coordinate 0-9)");
                playerMoveY = getInput();
            } while( !isValidCoordinate(playerMoveY));

            do {
                System.out.println("Player 1 should make his move ! (X coordinate 0-9)");
                playerMoveX = getInput();
            } while( !isValidCoordinate(playerMoveX));

            if (secondPlayerBoard[playerMoveY][playerMoveX] == 1) {

                consoleBoard[playerMoveY][playerMoveX] = 1;
                showConsoleBoard();

                System.out.println("");

                System.out.println("HIT!!!");

                playerHit++;

                System.out.println("Player1 hits: " +playerHit+ " | Player2 Hits: " +enemyHit);

                if(playerHit==17)break;

                tryagain--;

            }

            if (secondPlayerBoard[playerMoveY][playerMoveX] == 0) {
                System.out.println("No hit.");

            }

        }


    }

    public void playerVsPlayer2() {

        int playerMoveY;
        int playerMoveX;

        for(int tryagain = 0; tryagain < 1; tryagain++) {

            do {
                System.out.println("Player 2 should make his move ! (Y coordinate 0-9)");
                playerMoveY = getInput();
            } while( !isValidCoordinate(playerMoveY));

            do {
                System.out.println("Player 2 should make his move ! (X coordinate 0-9)");
                playerMoveX = getInput();
            } while( !isValidCoordinate(playerMoveX));

            if (playerBoard[playerMoveY][playerMoveX] == 1) {

                consoleBoard2[playerMoveY][playerMoveX] = 1;
                showConsoleBoard2();

                System.out.println("");

                System.out.println("HIT!!!");

                enemyHit++;

                System.out.println("Player hits: " +playerHit+ " | Enemy Hits: " +enemyHit);

                if(enemyHit==17)break;

                tryagain--;

            }

            if (playerBoard[playerMoveY][playerMoveX] == 0) {
                System.out.println("No hit.");

            }

        }


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
    }  /** Methode für die zufällige Befüllung des EnemyBoard (Schiffe werden zufällig verteilt in das Array geschrieben **/

    public void showEnemyBoard() {

        for (int row = 0; row < enemyBoard.length; row++) {

            System.out.println("");

            for (int col = 0; col < enemyBoard.length; col++) {

                System.out.print(enemyBoard[row][col] + " ");

            }

        }
        System.out.println("");


    } /** Gibt EnemyBoard aus **/

    /** game move methods **/

    public void playerMove() {

        int playerMoveY;
        int playerMoveX;

        for (int tryagain = 0; tryagain < 1; tryagain++) {


            do {
                System.out.println("Make your move! Enter Y coordinate 0-9.");
                playerMoveY = getInput();
            } while( !isValidCoordinate(playerMoveY));

            do {
                System.out.println("Make your move! Enter X coordinate 0-9.");
                playerMoveX = getInput();
            } while( !isValidCoordinate(playerMoveX));

            if (enemyBoard[playerMoveY][playerMoveX] == 1) {

                consoleBoard[playerMoveY][playerMoveX] = 1;
                showConsoleBoard();

                System.out.println("");

                System.out.println("HIT!!!");

                playerHit++;

                System.out.println("Player hits: " +playerHit+ " | Enemy Hits: " +enemyHit);

                if(playerHit==17)break;

                tryagain--;

            }

            if (enemyBoard[playerMoveY][playerMoveX] == 0) {
                System.out.println("No hit.");

            }
        }
    }

    public void enemyMove(){

        for (int tryagain = 0; tryagain < 1; tryagain++) {
            Random enemyTry = new Random();
            int enemyMoveY = enemyTry.nextInt(9);
            int enemyMoveX = enemyTry.nextInt(9);

            if (playerBoard[enemyMoveY][enemyMoveX] == 1) {
                System.out.println("You got hit!");
                enemyHit++;
                System.out.println("Player hits: " +playerHit+ " | Enemy Hits: " +enemyHit);
                if(enemyHit==17)break;
                tryagain--;
            }
            if (playerBoard[enemyMoveY][enemyMoveX] == 0) {
                System.out.println("You did not get hit.");
            }

        }

    }

    /** Getter **/

    private boolean isValidCoordinate(int userInput){
        if (userInput > 9 || userInput < 0){
            System.out.println("Try again");
            return false;
        }
        else return true;
    }

    public int getInput() {
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            num = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input, please try again.\n" + e);

            getInput();
        }
        return num;
    }

    public int getPlayerHit() {
        return playerHit;
    }

    public int getEnemyHit() {
        return enemyHit;
    }

}
