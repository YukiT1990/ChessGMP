public class Rook extends Piece {


  public Rook(int value, boolean isWhite, Position position) {
    super(value, isWhite, position);
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
