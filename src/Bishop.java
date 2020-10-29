public class Bishop extends Piece {

  private static final int VALUE = 3;

  public Bishop(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move(Position newPosition, Piece[][] board) {
    System.out.println("Diagonally");
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
    return super.isValidMove(newPosition, board);
  }
}
