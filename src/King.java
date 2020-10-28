public class King extends Piece {

  private static final int VALUE = 1000;

  public King(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move() {
    System.out.println("One square");
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♚";
    } else {
      return "♔";
    }
  }

}


