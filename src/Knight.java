public class Knight extends Piece {

  private static final int VALUE = 3;

  public Knight(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move(Position newPosition, Piece[][] board) {
    System.out.println("Like an L");
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
  public boolean isValidMove(Position newPosition) {
    return super.isValidMove(newPosition);
  }
}
