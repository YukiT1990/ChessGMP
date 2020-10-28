public class Knight extends Piece {


  public Knight(int value, boolean isWhite, Position position) {
    super(value, isWhite, position);
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
