public class GameController {

  protected static boolean move(Piece[][] board, String input) {
    char positionRow;
    char positionColumn;
    char newPositionRow;
    char newPositionColumn;

    if (input.length() != 4) {
      System.out.println("Invalid move!");
      return false;
    } else {
      positionRow = input.charAt(0);
      positionColumn = input.charAt(1);
      newPositionRow = input.charAt(2);
      newPositionColumn = input.charAt(3);
      System.out.println(positionRow + " " + positionColumn + " " + newPositionRow + " " + newPositionColumn);
    }
    return true;

  }



}
