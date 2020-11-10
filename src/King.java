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
  public boolean isValidMove(Position newPosition, Piece[][] board) {
    /**
     * Yuki added here
     */
    // First call the parent's method to check for the board bounds
    if(!super.isValidMove(position, board)){
      return false;
    }
    // If we passed the first test then check for the specific king movement
    if((Math.abs(newPosition.getCol() - this.position.getCol()) <= 1) && (Math.abs(newPosition.getRow() - this.position.getRow()) <= 1)){
      return true;
    }else{
      return false;
    }
  }
}


