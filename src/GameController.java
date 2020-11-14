public class GameController {


  protected static void help() {
    System.out.println("* type 'help' for help");
    System.out.println("* type 'board' to see the board again");
    System.out.println("* type 'resign' to resign");
    System.out.println("* type 'moves' to list all possible moves ");
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

  protected static void moves() {
    Game.allPossibleMovesPerPlayer();
  }

}
