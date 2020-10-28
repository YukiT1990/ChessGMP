public class Rook extends Piece {

  private static final int VALUE = 5;

  public Rook(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move() {
    System.out.println("Horizontally or vertically");
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♜";
    } else {
      return "♖";
    }
  }

}
