public class King extends Piece {

  private static final int VALUE = 1000;

  public King(boolean isWhite, Position position) {
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
      System.out.println("One square");
      return false;
    }
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
    // King can only move one cell and there is no other pieces in the way between newPosition and current position
    // so don't need to check whether there are other pieces in the way
    if((Math.abs(newPosition.getCol() - this.position.getCol()) <= 1) && (Math.abs(newPosition.getRow() - this.position.getRow()) <= 1)){
      return true;
    }else{
      return false;
    }
  }

  /**
   * Conditions of castling
   * 1. you may only castle if all the squares between the king and rook are open.
   * 2. you may only castle if your king, and the rook you want to castle with,
   * have not moved since the start of the game.
   * 3. you may not do the move if your king is in check.
   * 4. you may not do this move if your king moves over a square where he would be in check.
   * (the squares of king's way must not be in the attack range of the opponent)
   * @return
   */

  // condition 2 hasn't written yet
  public boolean canCastling(boolean isWhite, Position newPosition, Piece[][] board) {
    if (isWhite) {
      // the king is white
      // king(e1), rook(a1, h1)

      // check whether newPosition is the cell for castling
      if(!(newPosition.getRow() == 0 && newPosition.getCol() == 1) && !(newPosition.getRow() == 0 && newPosition.getCol() == 6)) {
        return false;
      }

      // condition 3
      if(Game.isKingInCheck(true) == true){
        return false;
      }

      // rook is a1
      if(newPosition.getRow() == 0 && newPosition.getCol() == 1){
        if(board[0][4].getValue() == 1000 && board[0][4].isWhite() == true
                && board[0][0].getValue() == 5 && board[0][0].isWhite() == true){
          // condition 1
          if(board[0][1] != null || board[0][2] != null || board[0][3] != null) {
            return false;
          }
          // condition 4
          if(board[0][1].isUnderAttack(board) == true || board[0][2].isUnderAttack(board) == true || board[0][3].isUnderAttack(board) == true) {
            return false;
          }
        }else{
          return false;
        }
      }
      // rook is h1
      if(newPosition.getRow() == 0 && newPosition.getCol() == 6){
        if(board[0][4].getValue() == 1000 && board[0][4].isWhite() == true
                && board[0][7].getValue() == 5 && board[0][7].isWhite() == true){
          // condition 1
          if(board[0][5] != null || board[0][6] != null) {
            return false;
          }
          // condition 4
          if(board[0][5].isUnderAttack(board) == true || board[0][6].isUnderAttack(board) == true) {
            return false;
          }
        }else{
          return false;
        }
      }
      // meet all the conditions
      return true;

    }else{
      // the king is black
      // king(e8), rook(a8, h8)

      // check whether newPosition is the cell for castling
      if(!(newPosition.getRow() == 7 && newPosition.getCol() == 1) && !(newPosition.getRow() == 7 && newPosition.getCol() == 6)) {
        return false;
      }

      // condition 3
      if(Game.isKingInCheck(false) == true){
        return false;
      }

      // rook is a8
      if(newPosition.getRow() == 7 && newPosition.getCol() == 1){
        if(board[7][4].getValue() == 1000 && board[7][4].isWhite() == true
                && board[7][0].getValue() == 5 && board[7][0].isWhite() == true){
          // condition 1
          if(board[7][1] != null || board[7][2] != null || board[7][3] != null) {
            return false;
          }
          // condition 4
          if(board[7][1].isUnderAttack(board) == true || board[7][2].isUnderAttack(board) == true || board[7][3].isUnderAttack(board) == true) {
            return false;
          }
        }else{
          return false;
        }
      }
      // rook is h8
      if(newPosition.getRow() == 7 && newPosition.getCol() == 6){
        if(board[7][4].getValue() == 1000 && board[7][4].isWhite() == true
                && board[7][7].getValue() == 5 && board[7][7].isWhite() == true){
          // condition 1
          if(board[7][5] != null || board[7][6] != null) {
            return false;
          }
          // condition 4
          if(board[7][5].isUnderAttack(board) == true || board[7][6].isUnderAttack(board) == true) {
            return false;
          }
        }else{
          return false;
        }
      }

      // meet all the conditions
      return true;
    }
  }

  // use this after canCastling
  public void kingEntersCastle(Position newPosition, Piece[][] board){
    if(newPosition.getRow() == 0 && newPosition.getCol() == 1) {
      board[this.position.getRow()][this.position.getCol()] = null;
      this.position = newPosition;
      board[newPosition.getRow()][newPosition.getCol()] = this;
      Piece rw1 = board[0][0];
      rw1.position = new Position(0, 2);
      board[0][0] = null;
      board[0][2] = rw1;
    } else if(newPosition.getRow() == 0 && newPosition.getCol() == 6) {
      board[this.position.getRow()][this.position.getCol()] = null;
      this.position = newPosition;
      board[newPosition.getRow()][newPosition.getCol()] = this;
      Piece rw2 = board[0][7];
      rw2.position = new Position(0, 5);
      board[0][7] = null;
      board[0][5] = rw2;
    } else if(newPosition.getRow() == 7 && newPosition.getCol() == 1) {
      board[this.position.getRow()][this.position.getCol()] = null;
      this.position = newPosition;
      board[newPosition.getRow()][newPosition.getCol()] = this;
      Piece rb1 = board[7][0];
      rb1.position = new Position(7, 2);
      board[7][0] = null;
      board[7][2] = rb1;
    } else if(newPosition.getRow() == 7 && newPosition.getCol() == 6) {
      board[this.position.getRow()][this.position.getCol()] = null;
      this.position = newPosition;
      board[newPosition.getRow()][newPosition.getCol()] = this;
      Piece rb2 = board[7][7];
      rb2.position = new Position(7, 5);
      board[7][7] = null;
      board[7][5] = rb2;
    }
  }
}


