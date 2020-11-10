public class Rook extends Piece {

  private static final int VALUE = 5;

  public Rook(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move(Position newPosition, Piece[][] board) {
    System.out.println("Horizontally or vertically");
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♖";
    } else {
      return "♜";
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
    // If we passed the first test then check for the specific rook movement
    if(newPosition.getCol() == this.position.getCol() || newPosition.getRow() == this.position.getRow()){
      return true;
    }else{
      return false;
    }

  }
}
