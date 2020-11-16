public class GameController {


  protected static void help() {
    System.out.println("* type 'help' for help");
    System.out.println("* type 'board' to see the board again");
    System.out.println("* type 'resign' to resign");
    System.out.println("* type 'moves' to list all possible moves");
    System.out.println("* type 'draw' to offer a draw");
    System.out.println("* type a square (e.g. b1, e2) to list possible moves for that square");
    System.out.println("* type UCI (e.g. b1c3, e7e8) to make a move\n");
  }

  protected static void board() {
    Game.printBoard();
  }

  protected static void resign(boolean isWhite) {
    if (isWhite) {
      System.out.println("\nWhite resigned. Black Won!");
    } else {
      System.out.println("\nBlack resigned. White Won!");
    }
    System.exit(0);
  }

  protected static void moves(boolean isWhite) {
    Game.allPossibleMovesPerPlayer(isWhite);
  }

  protected static void draw(boolean isWhite) {

    String userOptionInput = "";
    boolean flag = true;

    while (flag) {
      if (isWhite) {
        userOptionInput = InputCollector.getUserInput("White offered a draw. Do you accept? (Y/N)");
      } else {
        userOptionInput = InputCollector.getUserInput("Black offered a draw. Do you accept? (Y/N)");
      }

      switch (userOptionInput) {
        case ("Y"):
          System.out.println("It's a draw!");
          System.exit(0);
          break;

        case ("N"):
          System.out.println("Draw not accepted!");
          flag = false;
          break;

        default:
          System.out.println("Invalid input");

      }
    }


  }

}
