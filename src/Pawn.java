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
    int newColumn = newPosition.getCol();
    int newRow = newPosition.getRow();
    int column = position.getCol();
    int row = position.getRow();
    boolean isFirstRowWhite = (row == 1);
    boolean isFirstRowBlack = (row == 6);
    boolean isValidWhitePawnAnyMove = (newRow == row + PAWN_MOVE_1 &&
        board[newRow][newColumn] == null);
    boolean isValidWhitePawnFirstMove = ((newRow == row + PAWN_MOVE_2 ||
        newRow == row + PAWN_MOVE_1) & board[newRow][newColumn] == null);
    boolean isValidWhitePawnMoveCapturing = (newRow == row + PAWN_MOVE_1 &&
        newColumn == column + PAWN_MOVE_1) || (newRow == row + PAWN_MOVE_1 &&
        newColumn == column - PAWN_MOVE_1);
    boolean isValidBlackPawnAnyMove = (newRow == row - PAWN_MOVE_1 &&
        board[newRow][newColumn] == null);
    boolean isValidBlackPawnFirstMove = ((newRow == row - PAWN_MOVE_2 ||
        newRow == row - PAWN_MOVE_1) && board[newRow][newColumn] == null);

    boolean isValidBlackPawnMoveCapturing = (newRow == row - PAWN_MOVE_1 &&
        newColumn == column + PAWN_MOVE_1) ||
        (newRow == row - PAWN_MOVE_1 && newColumn == column - PAWN_MOVE_1);

    if (!super.isValidMove(newPosition, board)) {
      return false;
    }

    if (this.isWhite()) {

      if (isFirstRowWhite) {
        if (isValidWhitePawnFirstMove) {
          if (board[newRow][newColumn] != null) {
            if (!board[newRow][newColumn].isWhite() && isValidWhitePawnMoveCapturing) {
              return true;
            }
          }
          return true;
        }
      } else if (isValidWhitePawnAnyMove || isValidWhitePawnMoveCapturing) {
        if (board[newRow][newColumn] != null) {
          if (!board[newRow][newColumn].isWhite()) {
            return true;
          }
        }
          return true;
        }
      } else if (isFirstRowBlack) {
      if (isValidBlackPawnFirstMove) {
        if (board[newRow][newColumn] != null) {
          if (board[newRow][newColumn].isWhite() && isValidBlackPawnMoveCapturing) {
            return true;
          }
        }
        return true;
      }
    } else if (isValidBlackPawnAnyMove || isValidBlackPawnMoveCapturing) {
      if (board[newRow][newColumn] != null) {
        if (board[newRow][newColumn].isWhite()) {
          return true;
        }
      }
      return true;
    }

    return false;
  }

}

