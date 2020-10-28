public class Queen extends Piece {

  private static final int VALUE = 9;

  public Queen(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move() {
    System.out.println("Like bishop and rook");
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♛";
    } else {
      return "♕";
    }
  }

}


