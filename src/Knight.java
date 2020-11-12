public class Knight extends Piece {

  private static final int VALUE = 3;

  public Knight(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move(Position newPosition, Piece[][] board) {
    int newColumn = newPosition.getCol();
    int newRow = newPosition.getRow();
    int column = position.getCol();
    int row = position.getRow();

    if (isValidMove(newPosition, board)) {
      board[row][column] = null;
      this.position = newPosition;
      board[newRow][newColumn] = this;
    } else {
      System.out.println("Invalid move!");
    }
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♘";
    } else {
      return "♞";
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
    // If we passed the first test then check for the specific knight movement
    // Knight can jump over other pieces
    // so don't need to check whether there are other pieces in the way
    if(((Math.abs(newPosition.getCol() - this.position.getCol()) == 1) && (Math.abs(newPosition.getRow() - this.position.getRow()) == 2))
            || ((Math.abs(newPosition.getRow() - this.position.getRow()) == 1) && (Math.abs(newPosition.getCol() - this.position.getCol()) == 2))){
      return true;
    }
    else{
      return false;
    }
  }
}
