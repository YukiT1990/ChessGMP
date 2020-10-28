public class Pawn extends Piece {


  private boolean promoted;

  public Pawn(int value, boolean isWhite, Position position, boolean promoted) {
    super(value, isWhite, position);
    this.promoted = promoted;
  }

  @Override
  void move() {
    System.out.println("Forward 1");
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♟";
    } else {
      return "♙";
    }
  }

  @Override
  public boolean isValidMove(Position newPosition) {

    int firstWhite = 1;
    int firstBlack = 6;

//    if (!super.isValidMove(newPosition)) {
//      return false;
//    }
//
//    if (isWhite()) {
//      if (position.getRow() == firstWhite) {
//
//      }
//    } else {
//
//    }

    return true;

  }
}

