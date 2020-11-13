public class Position {
  private int row;
  private int col;
  private String uci = "";

  public Position(int row, int col) {
    this.row = row;
    this.col = col;
    this.uci = setUci(this.row, this.col);
  }

  private String setUci(int row, int col) {
    switch (col) {
      case (0):
        this.uci = this.uci.concat("a");
        break;
      case (1):
        this.uci = this.uci.concat("b");
        break;
      case (2):
        this.uci = this.uci.concat("c");
        break;
      case (3):
        this.uci = this.uci.concat("d");
        break;
      case (4):
        this.uci = this.uci.concat("e");
        break;
      case (5):
        this.uci = this.uci.concat("f");
        break;
      case (6):
        this.uci = this.uci.concat("g");
        break;
      case (7):
        this.uci = this.uci.concat("h");
        break;
    }

    switch (row) {
      case (0):
        this.uci = this.uci.concat("1");
        break;
      case (1):
        this.uci = this.uci.concat("2");
        break;
      case (2):
        this.uci = this.uci.concat("3");
        break;
      case (3):
        this.uci = this.uci.concat("4");
        break;
      case (4):
        this.uci = this.uci.concat("5");
        break;
      case (5):
        this.uci = this.uci.concat("6");
        break;
      case (6):
        this.uci = this.uci.concat("7");
        break;
      case (7):
        this.uci = this.uci.concat("8");
        break;
    }
    return this.uci;
  }

  public int getCol() {
    return col;
  }

  public int getRow() {
    return row;
  }

  public String getUci() {
    return uci;
  }

  @Override
  public String toString() {
    return "Row: " + row + " " +  "Col: " + col;
  }
}
