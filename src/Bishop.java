public class Bishop extends Piece {

  private static final int VALUE = 3;

  public Bishop(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  boolean move(Position newPosition, Piece[][] board) {
    int newColumn = newPosition.getCol();
    int newRow = newPosition.getRow();
    int column = this.position.getCol();
    int row = this.position.getRow();

    if (this.isValidMove(newPosition, board)) {
      board[row][column] = null;
      this.position = newPosition;
      board[newRow][newColumn] = this;
      return true;
    } else {
      System.out.println("Invalid move!");
      System.out.println("Diagonally");
      return false;
    }
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♗";
    } else {
      return "♝";
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
    // If we passed the first test then check for the specific bishop movement
    if(Math.abs(newPosition.getCol() - this.position.getCol()) == Math.abs(newPosition.getRow() - this.position.getRow())){
      int positionsBetween = Math.abs(newPosition.getCol() - this.position.getCol()) - 1;
      if(newPosition.getRow() > this.position.getRow() && newPosition.getCol() > this.position.getCol()) {
        int r = this.position.getRow() + 1;
        int c = this.position.getCol() + 1;
        while(positionsBetween > 0) {
          if(board[r][c] != null) {
            return false;
          }
          r += 1;
          c += 1;
          positionsBetween -= 1;
        }
        return true;
      }else if(newPosition.getRow() > this.position.getRow() && newPosition.getCol() <= this.position.getCol()){
        int r = this.position.getRow() + 1;
        int c = this.position.getCol() - 1;
        while(positionsBetween > 0) {
          if(board[r][c] != null) {
            return false;
          }
          r += 1;
          c -= 1;
          positionsBetween -= 1;
        }
        return true;
      }else if(newPosition.getRow() <= this.position.getRow() && newPosition.getCol() > this.position.getCol()){
        int r = this.position.getRow() - 1;
        int c = this.position.getCol() + 1;
        while(positionsBetween > 0) {
          if(board[r][c] != null) {
            return false;
          }
          r -= 1;
          c += 1;
          positionsBetween -= 1;
        }
        return true;
        // else -> newPosition.getRow() <= this.position.getRow() && newPosition.getCol() <= this.position.getCol()
      }else{
        int r = newPosition.getRow() + 1;
        int c = newPosition.getCol() + 1;
        while(positionsBetween > 0) {
          if(board[r][c] != null) {
            return false;
          }
          r += 1;
          c += 1;
          positionsBetween -= 1;
        }
        return true;
      }
    }else{
      return false;
    }
  }
}
