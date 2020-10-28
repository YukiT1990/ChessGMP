public class Game {

  private Piece[][] board;
  private final String empty = ". ";

  public Game() {
    board = new Piece[8][8];

  }

  public static void main(String[] args) {

    Game game = new Game();

    Pawn pw1 = new Pawn(true, new Position(1, 0), false);
    Pawn pw2 = new Pawn(true, new Position(1, 1), false);
    Pawn pw3 = new Pawn(true, new Position(1, 2), false);
    Pawn pw4 = new Pawn(true, new Position(1, 3), false);
    Pawn pw5 = new Pawn(true, new Position(1, 4), false);
    Pawn pw6 = new Pawn(true, new Position(1, 5), false);
    Pawn pw7 = new Pawn(true, new Position(1, 6), false);
    Pawn pw8 = new Pawn(true, new Position(1, 7), false);
    Pawn pb1 = new Pawn(false, new Position(6, 0), false);
    Pawn pb2 = new Pawn(false, new Position(6, 1), false);
    Pawn pb3 = new Pawn(false, new Position(6, 2), false);
    Pawn pb4 = new Pawn(false, new Position(6, 3), false);
    Pawn pb5 = new Pawn(false, new Position(6, 4), false);
    Pawn pb6 = new Pawn(false, new Position(6, 5), false);
    Pawn pb7 = new Pawn(false, new Position(6, 6), false);
    Pawn pb8 = new Pawn(false, new Position(6, 7), false);

    King kw = new King(true, new Position(0, 5));
    King kb = new King(false, new Position(7, 5));

    Queen qw = new Queen(true, new Position(0, 3));
    Queen qb = new Queen(false, new Position(7, 3));

    Rook rw1 = new Rook(true, new Position(0, 0));
    Rook rw2 = new Rook(true, new Position(0, 7));
    Rook rb1 = new Rook(false, new Position(7, 0));
    Rook rb2 = new Rook(false, new Position(7, 7));

    Bishop bw1 = new Bishop(true, new Position(0, 2));
    Bishop bw2 = new Bishop(true, new Position(0, 5));
    Bishop bb1 = new Bishop(false, new Position(7, 2));
    Bishop bb2 = new Bishop(false, new Position(7, 5));

    Knight kw1 = new Knight(true, new Position(0, 1));
    Knight kw2 = new Knight(true, new Position(0, 6));
    Knight kb1 = new Knight(false, new Position(7, 1));
    Knight kb2 = new Knight(false, new Position(7, 6));

    game.board[0][0] = rw1;
    game.board[0][1] = kw1;
    game.board[0][2] = bw1;
    game.board[0][3] = qw;
    game.board[0][4] = kw;
    game.board[0][5] = bw2;
    game.board[0][6] = kw2;
    game.board[0][7] = rw2;
    game.board[1][0] = pw1;
    game.board[1][1] = pw2;
    game.board[1][2] = pw3;
    game.board[1][3] = pw4;
    game.board[1][4] = pw5;
    game.board[1][5] = pw6;
    game.board[1][6] = pw7;
    game.board[1][7] = pw8;

    game.board[7][0] = rb1;
    game.board[7][1] = kb1;
    game.board[7][2] = bb1;
    game.board[7][3] = qb;
    game.board[7][4] = kb;
    game.board[7][5] = bb2;
    game.board[7][6] = kb2;
    game.board[7][7] = rb2;
    game.board[6][0] = pb1;
    game.board[6][1] = pb2;
    game.board[6][2] = pb3;
    game.board[6][3] = pb4;
    game.board[6][4] = pb5;
    game.board[6][5] = pb6;
    game.board[6][6] = pb7;
    game.board[6][7] = pb8;

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (game.board[i][j] != null) {
          System.out.print(game.board[i][j] + " ");
        } else {
          System.out.print(game.empty);
        }
      }
      System.out.println();
    }

  }

}
