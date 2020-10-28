public class Game {

  private Piece[][] board;


  public Game() {
    board = new Piece[8][8];

  }

  public static void printBoard(Piece[][] board) {

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

  public static void main(String[] args) {

    Game game = new Game();

    Position a1 = new Position(0, 0);
    Position a2 = new Position(1, 0);
    Position a3 = new Position(2, 0);
    Position a4 = new Position(3, 0);
    Position a5 = new Position(4, 0);
    Position a6 = new Position(5, 0);
    Position a7 = new Position(6, 0);
    Position a8 = new Position(7, 0);
    Position b1 = new Position(0, 0);
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


    Pawn pw1 = new Pawn(true, a2,false);
    Pawn pw2 = new Pawn(true, b2,false);
    Pawn pw3 = new Pawn(true, c2,false);
    Pawn pw4 = new Pawn(true, d2,false);
    Pawn pw5 = new Pawn(true, e2,false);
    Pawn pw6 = new Pawn(true, f2,false);
    Pawn pw7 = new Pawn(true, g2,false);
    Pawn pw8 = new Pawn(true, h2,false);
    Pawn pb1 = new Pawn(false, a7,false);
    Pawn pb2 = new Pawn(false, b7,false);
    Pawn pb3 = new Pawn(false, c7,false);
    Pawn pb4 = new Pawn(false, d7,false);
    Pawn pb5 = new Pawn(false, e7,false);
    Pawn pb6 = new Pawn(false, f7,false);
    Pawn pb7 = new Pawn(false, g7,false);
    Pawn pb8 = new Pawn(false, h7,false);
    King kw = new King(true, d1);
    King kb = new King(false, d8);
    Queen qw = new Queen(true, e1);
    Queen qb = new Queen(false, e8);
    Rook rw1 = new Rook(true, a1);
    Rook rw2 = new Rook(true, h1);
    Rook rb1 = new Rook(false, a8);
    Rook rb2 = new Rook(false, h8);
    Bishop bw1 = new Bishop(true, c1);
    Bishop bw2 = new Bishop(true, f1);
    Bishop bb1 = new Bishop(false, c8);
    Bishop bb2 = new Bishop(false, c8);
    Knight kw1 = new Knight(true, b1);
    Knight kw2 = new Knight(true, g1);
    Knight kb1 = new Knight(false, b8);
    Knight kb2 = new Knight(false, g8);

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

    game.board[6][0] = pb1;
    game.board[6][1] = pb2;
    game.board[6][2] = pb3;
    game.board[6][3] = pb4;
    game.board[6][4] = pb5;
    game.board[6][5] = pb6;
    game.board[6][6] = pb7;
    game.board[6][7] = pb8;
    game.board[7][0] = rb1;
    game.board[7][1] = kb1;
    game.board[7][2] = bb1;
    game.board[7][3] = qb;
    game.board[7][4] = kb;
    game.board[7][5] = bb2;
    game.board[7][6] = kb2;
    game.board[7][7] = rb2;

    printBoard(game.board);

    pw1.move(a3, game.board);

    printBoard(game.board);

    pb3.move(c5, game.board);

    printBoard(game.board);

    game.board[1][5].move(f3, game.board);

    printBoard(game.board);

  }

}
