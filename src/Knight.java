public class Knight extends Piece {

  private static final int VALUE = 3;

  public Knight(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
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
      return "♘";
    } else {
      return "♞";
    }
  }

  @Override
  public boolean isValidMove(Position newPosition, Piece[][] board) {

    final int KNIGHT_MOVE_1 = 1;
    final int KNIGHT_MOVE_2 = 2;
    int newColumn = newPosition.getCol();
    int newRow = newPosition.getRow();
    int column = position.getCol();
    int row = position.getRow();

    if (!super.isValidMove(newPosition, board)) {
      return false;
    }

    boolean validKnightMove = (
        (newColumn == column + KNIGHT_MOVE_1 && newRow == row + KNIGHT_MOVE_2) ||
        (newColumn == column + KNIGHT_MOVE_1 && newRow == row - KNIGHT_MOVE_2) ||
        (newColumn == column + KNIGHT_MOVE_2 && newRow == row + KNIGHT_MOVE_1) ||
        (newColumn == column + KNIGHT_MOVE_2 && newRow == row - KNIGHT_MOVE_1) ||
        (newColumn == column - KNIGHT_MOVE_1 && newRow == row - KNIGHT_MOVE_2) ||
        (newColumn == column - KNIGHT_MOVE_1 && newRow == row + KNIGHT_MOVE_2) ||
        (newColumn == column - KNIGHT_MOVE_2 && newRow == row - KNIGHT_MOVE_1) ||
        (newColumn == column - KNIGHT_MOVE_2 && newRow == row + KNIGHT_MOVE_1)
    );

    if (this.isWhite()) {
      if (board[newRow][newColumn] == null && validKnightMove) {
        return true;
      } else if (!board[newRow][newColumn].isWhite() && validKnightMove) {
        return true;
      }
    } else if (board[newRow][newColumn] == null && validKnightMove) {
      return true;
    } else if (board[newRow][newColumn].isWhite() && validKnightMove) {
      return true;
    }
    return false;
  }

}
