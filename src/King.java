public class King extends Piece {


  public King(int value, boolean isWhite, Position position) {
    super(value, isWhite, position);
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


