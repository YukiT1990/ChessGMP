public class Bishop extends Piece {

  private static final int VALUE = 3;

  public Bishop(boolean isWhite, Position position) {
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
      return "♗";
    } else {
      return "♝";
    }
  }

  @Override
  public boolean isValidMove(Position newPosition, Piece[][] board) {

    int newColumn = newPosition.getCol();
    int newRow = newPosition.getRow();
    int column = position.getCol();
    int row = position.getRow();
    int difRow = Math.abs(newRow - row);
    int difColumn = Math.abs(newColumn - column);

    if (!super.isValidMove(newPosition, board)) {
      return false;
    }

    return (difRow == difColumn);
  }

}
