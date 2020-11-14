import java.util.ArrayList;

public class Rook extends Piece {

  private static final int VALUE = 5;

  public Rook(boolean isWhite, Position position) {
    super(VALUE, isWhite, position);
  }

  @Override
  void move(Position newPosition, Piece[][] board) {
    int newColumn = newPosition.getCol();
    int newRow = newPosition.getRow();
    int column = this.position.getCol();
    int row = this.position.getRow();

    if (this.isValidMove(newPosition, board)) {
      board[row][column] = null;
      this.position = newPosition;
      board[newRow][newColumn] = this;
    } else {
      System.out.println("Invalid move!");
      System.out.println("Horizontally or vertically");
    }
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
    if(newPosition.getCol() == this.position.getCol()) {
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
    }else{
      return false;
    }

  }
}
