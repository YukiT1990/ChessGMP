public class Driver {

  public static void main(String[] args) {
    Game.gameStarter();
    boolean isWhite = true;

    boolean hasKwMoved = false; //e1
    boolean hasKbMoved = false; //e8
    boolean hasRw1Moved = false; //a1
    boolean hasRw2Moved = false; //h1
    boolean hasRb1Moved = false; //a8
    boolean hasRb2Moved = false; //h8

    Game.printBoard();
    while (true) {

      if (Game.isCheckMate(isWhite)) {
        if (isWhite) {
          System.out.println("Check Mate! White Won!");
        } else {
          System.out.println("Check Mate! Black Won!");
        }
        System.exit(0);
      }

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

          GameController.moves(isWhite);
          break;

        default:
          if (userOptionInput.length() == 2) {
            Game.allPossibleMovesPerPosition(userOptionInput, isWhite);

            break;
          }

          if (userOptionInput.length() == 4) {
            boolean m = Game.move(userOptionInput, isWhite);
            if (m) {
              isWhite = !isWhite;
              Game.printBoard();
            } else {
              System.out.println("Invalid input, please try again");
            }
            break;
          }

          System.out.println("\nInvalid input, please try again.\n");
          break;

      }
    }

  }

}
