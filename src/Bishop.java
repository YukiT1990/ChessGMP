public class Bishop extends Piece {

  private static final int VALUE = 3;

  public Bishop(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move() {
    System.out.println("Diagonally");
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♝";
    } else {
      return "♗";
    }
  }

}
