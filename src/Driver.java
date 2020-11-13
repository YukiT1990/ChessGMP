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
            System.out.println("..");

            break;
          }

          if (userOptionInput.length() == 4) {
            System.out.println("*** implement UCI function ***");
            isWhite = !isWhite;
            Game.printBoard();
            break;
          }

          System.out.println("\nInvalid input.\n");
          break;

      }
    }

  }

}
