public class Queen extends Piece {


  public Queen(int value, boolean isWhite, Position position) {
    super(value, isWhite, position);
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


