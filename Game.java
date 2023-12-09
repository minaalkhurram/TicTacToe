public class Game {

    public static final int ROWS = 3, COLS = 3;
    public static char[][] board = new char[ROWS][COLS];

    boolean check=false;

    Game()
    {
        for(int i=0;i<ROWS;i++)
        {
            for(int j=0;j<COLS;j++)
            {
             board[i][j]=' ';
            }
        }
        loadBoard();
    }
    private void loadBoard()
    {

        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                System.out.print(board[row][col]); // print each of the cells
                if (col != COLS - 1) {
                    System.out.print("|");   // print vertical partition
                }
            }
            System.out.println();
            if (row != ROWS - 1) {
                System.out.println("-----------"); // print horizontal partition
            }
        }

    }
}
