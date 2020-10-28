public class King extends Piece {

  private static final int VALUE = 1000;

  public King(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move(Position newPosition, Piece[][] board) {
    System.out.println("One square");
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♔";
    } else {
      return "♚";
    }
  }

  @Override
  public boolean isValidMove(Position newPosition) {
    return super.isValidMove(newPosition);
  }
}


