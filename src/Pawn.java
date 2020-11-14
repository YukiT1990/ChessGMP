public class Pawn extends Piece {


  private boolean promoted;
  private static final int VALUE = 1;

  public Pawn(boolean isWhite, Position position, boolean promoted) {
    super(VALUE, isWhite, position);
    this.promoted = promoted;
  }

  @Override
  boolean move(Position newPosition, Piece[][] board) {
    int newColumn = newPosition.getCol();
    int newRow = newPosition.getRow();
    int column = this.position.getCol();
    int row = this.position.getRow();

    if (isValidMove(newPosition, board)) {
      board[row][column] = null;
      this.position = newPosition;
      board[newRow][newColumn] = this;
      return true;
    } else {
      System.out.println("Invalid move!");
      System.out.println("Forward 1");
      return false;
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
    int column = this.position.getCol();
    int row = this.position.getRow();
    Piece p = board[newRow][newColumn];

    if (p != null) {
      if (p.isWhite() == this.isWhite()) {
        return false;
      }
    }

    if (p == null) {
      if (this.isWhite()) {
        if (column == newColumn && ((newRow == row + PAWN_MOVE_1) ||
            (row == 1 && newRow == row + PAWN_MOVE_2))) {
          return true;
        }

      } else {
        if (column == newColumn && ((newRow == row - PAWN_MOVE_1) ||
            (row == 6 && newRow == row - PAWN_MOVE_2))) {
          return true;
        }
      }
    } else {

      boolean b = (newColumn == column + PAWN_MOVE_1) || (newColumn == column - PAWN_MOVE_1);

      if (this.isWhite()) {
        if (newRow == row + PAWN_MOVE_1 && b) {
          return true;
        }

      } else {
        if (newRow == row - PAWN_MOVE_1 && b) {
          return true;
        }
      }

    }
    return false;
  }

}

