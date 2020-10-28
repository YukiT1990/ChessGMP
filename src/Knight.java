public class Knight extends Piece {

  private static final int VALUE = 3;

  public Knight(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move() {
    System.out.println("Like an L");
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♞";
    } else {
      return "♘";
    }
  }

}
