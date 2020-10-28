public class Rook extends Piece {

  private static final int VALUE = 5;

  public Rook(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move(Position newPosition, Piece[][] board) {
    System.out.println("Horizontally or vertically");
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♖";
    } else {
      return "♜";
    }
  }

  @Override
  public boolean isValidMove(Position newPosition) {
    return super.isValidMove(newPosition);
  }
}
