public class Driver {

  public static void main(String[] args) {
    Game.gameStarter();
    boolean isWhite = true;

    Game.printBoard();
    while (true) {


      if (isWhite) {
        System.out.println("White to move");
      } else {
        System.out.println("Black to move");
      }

      String userOptionInput = InputCollector.getUserInput("Enter UCI (type help for help):");
      switch (userOptionInput) {

        case ("help"):

          GameController.help();
          break;

        case ("board"):

          GameController.board();
          break;

        case ("resign"):

          GameController.resign(isWhite);
          break;

        case ("moves"):

          GameController.moves();
          break;

        default:
          if (userOptionInput.length() == 2) {
            Game.allPossibleMoves();

            break;
          }

          if (userOptionInput.length() == 4) {
            boolean m = Game.move(userOptionInput, isWhite);
            if (m) {
              isWhite = !isWhite;
            } else {
              System.out.println("Invalid input!");
            }
            Game.printBoard();
            break;
          }

          System.out.println("\nInvalid input.\n");
          Game.printBoard();
          break;

      }
    }

  }

}
