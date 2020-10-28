import java.util.Objects;

public abstract class Piece {

  //♚♛♜♝♞♟♔♕♖♗♘♙

  private int value;
  private boolean isWhite;
  protected Position position;

  public Piece(int value, boolean isWhite, Position position) {
    this.value = value;
    this.isWhite = isWhite;
    this.position = position;
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

  abstract void move(Position newPosition, Piece[][] board);

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

  public boolean isValidMove(Position newPosition){
    if (newPosition.getRow() > 0 && newPosition.getCol() > 0
        && newPosition.getRow() < 8 && newPosition.getCol() < 8) {
      return true;
    } else {
      return false;
    }
  }

}
