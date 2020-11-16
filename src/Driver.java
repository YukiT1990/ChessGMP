public class Driver {
  public static boolean hasKwMoved = false; //e1
  public static boolean hasKbMoved = false; //e8
  public static boolean hasRw1Moved = false; //a1
  public static boolean hasRw2Moved = false; //h1
  public static boolean hasRb1Moved = false; //a8
  public static boolean hasRb2Moved = false; //h8

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

              Game.checkPromotion();


              /**
               * below 6 conditional statements check whether the king and the rook have moved since the start of the game
               */
              if(hasKwMoved == false) {
                if(Game.hasKwMovedFromOriginalPosition() == true) {
                  hasKwMoved = true;
                }
              }

              if(hasKbMoved == false) {
                if(Game.hasKbMovedFromOriginalPosition() == true) {
                  hasKbMoved = true;
                }
              }

              if(hasRw1Moved == false) {
                if(Game.hasRw1MovedFromOriginalPosition() == true) {
                  hasRw1Moved = true;
                }
              }

              if(hasRw2Moved == false) {
                if(Game.hasRw2MovedFromOriginalPosition() == true) {
                  hasRw2Moved = true;
                }
              }

              if(hasRb1Moved == false) {
                if(Game.hasRb1MovedFromOriginalPosition() == true) {
                  hasRb1Moved = true;
                }
              }

              if(hasRb2Moved == false) {
                if(Game.hasRb2MovedFromOriginalPosition() == true) {
                  hasRb2Moved = true;
                }
              }

              if (Game.isCheckmate(isWhite, Game.allMoves(isWhite))) {
                if (isWhite) {
                  System.out.println("Checkmate! White Won!");
                } else {
                  System.out.println("Checkmate! Black Won!");
                }
                System.exit(0);
              }
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
