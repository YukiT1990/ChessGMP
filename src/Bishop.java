public class Bishop extends Piece {


  public Bishop(int value, boolean isWhite, Position position) {
    super(value, isWhite, position);
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
