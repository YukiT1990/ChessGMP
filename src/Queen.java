public class Queen extends Piece {

  private static final int VALUE = 9;

  public Queen(boolean isWhite, Position position) {
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
      return "♕";
    } else {
      return "♛";
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
    // If we passed the first test then check for the specific queen movement
    // queen's move
    // move diagonally like bishop
    // (Math.abs(newPosition.getCol() - this.position.getCol()) == Math.abs(newPosition.getRow() - this.position.getRow())
    // move in straight lines like rook
    // (newPosition.getCol() == this.position.getCol() || newPosition.getRow() == this.position.getRow())

    // move diagonally like bishop
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
      }else if(newPosition.getRow() <= this.position.getRow() && newPosition.getCol() > this.position.getCol()){
        int r = newPosition.getRow() + 1;
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
      // move in straight lines like rook
    }else if(newPosition.getCol() == this.position.getCol()) {
      int minOfRow = 0;
      int maxOfRow = 0;
      if(newPosition.getRow() >= this.position.getRow()) {
        minOfRow = this.position.getRow();
        maxOfRow = newPosition.getRow();
      }else{
        minOfRow = newPosition.getRow();
        maxOfRow = this.position.getRow();
      }
      for(int r = minOfRow + 1; r < maxOfRow; r++) {
        if(board[r][this.position.getCol()] != null) {
          return false;
        }
      }
      return true;
      // move in straight lines like rook
    }else if(newPosition.getRow() == this.position.getRow()){
      int minOfCol = 0;
      int maxOfCol = 0;
      if(newPosition.getCol() >= this.position.getCol()) {
        minOfCol = this.position.getCol();
        maxOfCol = newPosition.getCol();
      }else{
        minOfCol = newPosition.getCol();
        maxOfCol = this.position.getCol();
      }
      for(int c = minOfCol + 1; c < maxOfCol; c++) {
        if(board[this.position.getRow()][c] != null) {
          return false;
        }
      }
      return true;
      // none of queen's move
    }else{
      return false;
    }
  }
}


