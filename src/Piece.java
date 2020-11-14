import java.util.ArrayList;
import java.util.Objects;

public abstract class Piece {

  //♚♛♜♝♞♟♔♕♖♗♘♙

  private int value;
  private boolean isWhite;
  protected Position position;
  String square;

  public Piece(int value, boolean isWhite, Position position) {
    this.value = value;
    this.isWhite = isWhite;
    this.position = position;
    square = position.getUci();
  }



  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public boolean isWhite() {
    return isWhite;
  }

  public void setWhite(boolean white) {
    isWhite = white;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  abstract boolean move(Position newPosition, Piece[][] board);

  public ArrayList<String> possibleMoves(Position[] positions, Piece[][] board) {
    ArrayList<String> possibleMoves =  new ArrayList<>();
    for (Position p : positions) {
      if (this.isValidMove(p, board)) {
        possibleMoves.add(p.getUci());
      }
    }
    return possibleMoves;
  }

  @Override
  public String toString() {
    return "Piece{" +
        "position=" + position +
        ", isWhite=" + isWhite +
        ", value=" + value +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Piece piece = (Piece) o;
    return isWhite == piece.isWhite &&
        value == piece.value &&
        Objects.equals(position, piece.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, isWhite, value);
  }

  public boolean isValidMove(Position newPosition, Piece[][] board){

    // check whether newPosition is within board's limit
    if(newPosition.getRow() < 0 && newPosition.getCol() < 0
        && newPosition.getRow() >= 8 && newPosition.getCol() >= 8) {
      return false;
    }
    return true;
  }


  public boolean isKingInCheck(Piece[][] board, King k) {
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        if(isValidMove(board[i][j].position, board)) {
          if(board[i][j].getValue() == 1000 && board[i][j].isWhite() != this.isWhite()) {
            return true;
          }
        }
      }
    }
    return false;
  }

}
