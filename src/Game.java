import com.sun.org.apache.xerces.internal.xs.StringList;
import java.util.ArrayList;

public class Game {

  private static Piece[][] board;
  private static Position[] positions;

  public Game() {
    board = new Piece[8][8];

    Position a1 = new Position(0, 0);
    Position a2 = new Position(1, 0);
    Position a3 = new Position(2, 0);
    Position a4 = new Position(3, 0);
    Position a5 = new Position(4, 0);
    Position a6 = new Position(5, 0);
    Position a7 = new Position(6, 0);
    Position a8 = new Position(7, 0);
    Position b1 = new Position(0, 1);
    Position b2 = new Position(1, 1);
    Position b3 = new Position(2, 1);
    Position b4 = new Position(3, 1);
    Position b5 = new Position(4, 1);
    Position b6 = new Position(5, 1);
    Position b7 = new Position(6, 1);
    Position b8 = new Position(7, 1);
    Position c1 = new Position(0, 2);
    Position c2 = new Position(1, 2);
    Position c3 = new Position(2, 2);
    Position c4 = new Position(3, 2);
    Position c5 = new Position(4, 2);
    Position c6 = new Position(5, 2);
    Position c7 = new Position(6, 2);
    Position c8 = new Position(7, 2);
    Position d1 = new Position(0, 3);
    Position d2 = new Position(1, 3);
    Position d3 = new Position(2, 3);
    Position d4 = new Position(3, 3);
    Position d5 = new Position(4, 3);
    Position d6 = new Position(5, 3);
    Position d7 = new Position(6, 3);
    Position d8 = new Position(7, 3);
    Position e1 = new Position(0, 4);
    Position e2 = new Position(1, 4);
    Position e3 = new Position(2, 4);
    Position e4 = new Position(3, 4);
    Position e5 = new Position(4, 4);
    Position e6 = new Position(5, 4);
    Position e7 = new Position(6, 4);
    Position e8 = new Position(7, 4);
    Position f1 = new Position(0, 5);
    Position f2 = new Position(1, 5);
    Position f3 = new Position(2, 5);
    Position f4 = new Position(3, 5);
    Position f5 = new Position(4, 5);
    Position f6 = new Position(5, 5);
    Position f7 = new Position(6, 5);
    Position f8 = new Position(7, 5);
    Position g1 = new Position(0, 6);
    Position g2 = new Position(1, 6);
    Position g3 = new Position(2, 6);
    Position g4 = new Position(3, 6);
    Position g5 = new Position(4, 6);
    Position g6 = new Position(5, 6);
    Position g7 = new Position(6, 6);
    Position g8 = new Position(7, 6);
    Position h1 = new Position(0, 7);
    Position h2 = new Position(1, 7);
    Position h3 = new Position(2, 7);
    Position h4 = new Position(3, 7);
    Position h5 = new Position(4, 7);
    Position h6 = new Position(5, 7);
    Position h7 = new Position(6, 7);
    Position h8 = new Position(7, 7);

    positions = new Position[]{a1, a2, a3, a4, a5, a6, a7, a8,
        b1, b2, b3, b4, b5, b6, b7, b8,
        c1, c2, c3, c4, c5, c6, c7, c8,
        d1, d2, d3, d4, d5, d6, d7, d8,
        e1, e2, e3, e4, e5, e6, e7, e8,
        f1, f2, f3, f4, f5, f6, f7, f8,
        g1, g2, g3, g4, g5, g6, g7, g8,
        h1, h2, h3, h4, h5, h6, h7, h8};

    Pawn pw1 = new Pawn(true, a2, false);
    Pawn pw2 = new Pawn(true, b2, false);
    Pawn pw3 = new Pawn(true, c2, false);
    Pawn pw4 = new Pawn(true, d2, false);
    Pawn pw5 = new Pawn(true, e2, false);
    Pawn pw6 = new Pawn(true, f2, false);
    Pawn pw7 = new Pawn(true, g2, false);
    Pawn pw8 = new Pawn(true, h2, false);
    Pawn pb1 = new Pawn(false, a7, false);
    Pawn pb2 = new Pawn(false, b7, false);
    Pawn pb3 = new Pawn(false, c7, false);
    Pawn pb4 = new Pawn(false, d7, false);
    Pawn pb5 = new Pawn(false, e7, false);
    Pawn pb6 = new Pawn(false, f7, false);
    Pawn pb7 = new Pawn(false, g7, false);
    Pawn pb8 = new Pawn(false, h7, false);
    King kw = new King(true, e1);
    King kb = new King(false, e8);
    Queen qw = new Queen(true, d1);
    Queen qb = new Queen(false, d8);
    Rook rw1 = new Rook(true, a1);
    Rook rw2 = new Rook(true, h1);
    Rook rb1 = new Rook(false, a8);
    Rook rb2 = new Rook(false, h8);
    Bishop bw1 = new Bishop(true, c1);
    Bishop bw2 = new Bishop(true, f1);
    Bishop bb1 = new Bishop(false, c8);
    Bishop bb2 = new Bishop(false, f8);
    Knight kw1 = new Knight(true, b1);
    Knight kw2 = new Knight(true, g1);
    Knight kb1 = new Knight(false, b8);
    Knight kb2 = new Knight(false, g8);
    board[0][0] = rw1;
    board[0][1] = kw1;
    board[0][2] = bw1;
    board[0][3] = qw;
    board[0][4] = kw;
    board[0][5] = bw2;
    board[0][6] = kw2;
    board[0][7] = rw2;
    board[1][0] = pw1;
    board[1][1] = pw2;
    board[1][2] = pw3;
    board[1][3] = pw4;
    board[1][4] = pw5;
    board[1][5] = pw6;
    board[1][6] = pw7;
    board[1][7] = pw8;
    board[6][0] = pb1;
    board[6][1] = pb2;
    board[6][2] = pb3;
    board[6][3] = pb4;
    board[6][4] = pb5;
    board[6][5] = pb6;
    board[6][6] = pb7;
    board[6][7] = pb8;
    board[7][0] = rb1;
    board[7][1] = kb1;
    board[7][2] = bb1;
    board[7][3] = qb;
    board[7][4] = kb;
    board[7][5] = bb2;
    board[7][6] = kb2;
    board[7][7] = rb2;

  }


  public static void printBoard() {

    final String empty = ". ";

    for (int i = 7; i >= 0; i--) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j] != null) {
          System.out.print(board[i][j] + " ");
        } else {
          System.out.print(empty);
        }
        if (j == 7) {
          System.out.print(" " + (i + 1));
        }
      }
      System.out.println();
    }
    System.out.println("\na b c d e f g h\n");

  }

  public static boolean move(String move, boolean isWhite) {
    boolean flag = false;
    Piece piece = null;
    Position newPosition = null;

    // Finds the Position instance for the UCI code given.
    for (Position p : positions) {
      if (move.substring(2, 4).equals(p.getUci())) {
        newPosition = p;
      }
    }

    // Finds the Piece instance for the UCI code given.
    if (newPosition != null) {
      for (int i = 7; i >= 0; i--) {
        for (int j = 0; j < 8; j++) {
          if (board[i][j] != null) {
            if (board[i][j].getPosition().getUci().equals(move.substring(0, 2))) {
              piece = board[i][j];
            }
          }
        }
      }
    }

    // Checks if attempt to move the piece is in the correct color.
    if (piece != null) {
      if (piece.isWhite() != isWhite) {
        return false;
      } else {
        //check whether newPosition is null or with a piece with a different color
        if (board[newPosition.getRow()][newPosition.getCol()] == null ||
            (board[newPosition.getRow()][newPosition.getCol()].isWhite() != piece.isWhite())) {
          flag = piece.move(newPosition, board);
        }
      }
    }
    // Returns true if the move was successfully completed.
    return flag;
  }


  public static void allPossibleMovesPerPosition(String position, boolean isWhite) {
    Position pos = null;
    Piece piece;
    ArrayList<String> possibleMoves = new ArrayList<>();

    // Find the Position instance for the UCI code given.
    for (Position p : positions) {
      if (position.equals(p.getUci())) {
        pos = p;
      }
    }
    // Find the Piece instance for the UCI code given.
    if (pos == null) {
      System.out.println("There's no such position, please try again");
    } else {
      piece = board[pos.getRow()][pos.getCol()];
        if (piece == null) {
          System.out.println("There's no piece in such position, please try again");
        } else {

          for (Position p : positions) {
            if (piece.isValidMove(p, board)) {

              if (piece.isWhite() != isWhite) {
                System.out.println("You can't move the piece of this color.");
                break;

              } else {
                //check whether newPosition is null or with a piece with a different color
                if (board[p.getRow()][p.getCol()] == null ||
                    board[p.getRow()][p.getCol()].isWhite() != piece.isWhite()) {
                  possibleMoves.add(p.getUci());
                }
              }
            }
          }
          System.out.println(possibleMoves);
        }
    }
  }


  public static void allPossibleMovesPerPlayer(boolean isWhite) {

    for (int i = 7; i >= 0; i--) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j] != null && board[i][j].isWhite() == isWhite) {
          System.out.print(board[i][j].toString());
          System.out.print("[" + board[i][j].position.getUci() + "] -> ");
          allPossibleMovesPerPosition(board[i][j].position.getUci(), isWhite);
        }
      }
    }
  }

  public static boolean isKingInCheck(boolean isWhite) {

    Piece king = null;
    Piece piece = null;

    for (int i = 7; i >= 0; i--) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j] != null) {
          if (board[i][j].getValue() == 1000 && board[i][j].isWhite() == isWhite) {
            king = board[i][j];
          }
        }
      }
    }

    for (int i = 7; i >= 0; i--) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j] != null && king != null) {
          piece = board[i][j];
          if (piece.isWhite() != king.isWhite() && piece.isValidMove(king.position, board)) {
            return true;
          }
        }
      }
    }
    return false;

  }

  public static boolean isCheckMate(boolean isWhite) {
    Piece piece;
    ArrayList<String> possibleMoves = new ArrayList<>();

    for (Position p : positions) {
      if (p != null) {
        piece = board[p.getRow()][p.getCol()];
        if (piece != null) {
          for (Position np : positions) {
            if (piece.isValidMove(np, board)) {
                  possibleMoves.add(np.getUci());
                }
              }
            }
          }
        }
    if (possibleMoves.size() < 1) {
      return true;
    }
    return false;
  }


  static void gameStarter() {

    Game game = new Game();
  }

}
