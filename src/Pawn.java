public class Pawn extends Piece {


  private boolean promoted;
  private static final int VALUE = 1;

  public Pawn(boolean isWhite, Position position, boolean promoted) {
    super(VALUE, isWhite, position);
    this.promoted = promoted;
  }

  @Override
  void move(Position newPosition, Piece[][] board) {
    int newColumn = newPosition.getCol();
    int newRow = newPosition.getRow();
    int column = position.getCol();
    int row = position.getRow();

    if (isValidMove(newPosition, board)) {
      board[row][column] = null;
      this.position = newPosition;
      board[newRow][newColumn] = this;
    } else {
      System.out.println("Invalid move!");
    }
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♙";
    } else {
      return "♟";
    }
  }

  @Override
  public boolean isValidMove(Position newPosition, Piece[][] board) {

    final int PAWN_MOVE_1 = 1;
    final int PAWN_MOVE_2 = 2;
    final int FIRST_WHITE = 1;
    final int FIRST_BLACK = 6;
    int newColumn = newPosition.getCol();
    int newRow = newPosition.getRow();
    int column = position.getCol();
    int row = position.getRow();


    if (!super.isValidMove(newPosition, board)) {
      return false;
    }


    if (isWhite()) {

      // Checking move if the pawn is in the first position
      if (row == FIRST_WHITE) {
        if ((newRow == row + PAWN_MOVE_2 || newRow == row + PAWN_MOVE_1) &&
            newColumn == column && board[newRow][newColumn] == null) {
          return true;
        }
        // Checking the move if the pawn is not in the first position
      } else if (newRow == row + PAWN_MOVE_1 &&
          newColumn == column &&
          board[newRow][newColumn] == null) {
        return true;
        // Checking if the Pawn is capturing another piece
      } else if (!board[newRow][newColumn].isWhite() &&
          (newColumn == column + PAWN_MOVE_1 &&
              newRow == row + PAWN_MOVE_1) ||
          (newColumn == column - PAWN_MOVE_1 &&
              newRow == row + PAWN_MOVE_1)) {
        return true;
      }
    } else {
      // Checking move if the pawn is in the first position
      if (row == FIRST_BLACK) {
        if ((newRow == row - PAWN_MOVE_2 ||
            newRow == row - PAWN_MOVE_1) &&
            newColumn == column &&
            board[newRow][newColumn] == null) {
          return true;
        }
        // Checking the move if the pawn is not in the first position
      } else if (newRow == row - PAWN_MOVE_1 &&
          newColumn == column &&
          board[newRow][newColumn] == null) {
        return true;
        // Checking if the Pawn is capturing another piece
      } else if (board[newRow][newColumn].isWhite() &&
          (newColumn == column + PAWN_MOVE_1 &&
              newRow == row - PAWN_MOVE_1) ||
          (newColumn == column - PAWN_MOVE_1 &&
              newRow == row - PAWN_MOVE_1)) {
        return true;
      }
    }
    return false;
  }

}

