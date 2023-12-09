package TicTacToe;

import java.util.Scanner;

public class Game {

    public static final int ROWS = 3, COLS = 3;
    public static char[][] board = new char[ROWS][COLS];

    boolean check=false;
    char player=' ';

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
    public void startGame()
    {
        int ans=0;
        while(ans==0)
        {

            play();
            ans=checkGame();

        }

        if(ans==1)
        {
            System.out.println("Congrats "+player+" WON!!!");
        }
        else if(ans==2)
        {
            System.out.println(" DRAW ");
        }
    }
    public void setBoard(char b[][])
    {
        for(int i=0;i<ROWS;i++)
        {
            for(int j=0;j<COLS;j++)
            {
                board[i][j]=b[i][j];
            }
        }
    }
    private void loadBoard()
    {

        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                System.out.print(board[row][col]); // print each of the cells
                if (col != COLS - 1) {
                    System.out.print("  |");   // print vertical partition
                }
            }
            System.out.println();
            if (row != ROWS - 1) {
                System.out.println("-----------"); // print horizontal partition
            }
        }

    }
    public char[][] play()
    {
        int row,col;
        Scanner in=new Scanner(System.in);

        if(check==false)
        {
            player='X';//player1

            check=true;

        }
        else if(check==true)
        {
            player='O';//player1
            check=false;

        }

        System.out.println(" Enter Row for "+player+" : ");
        row=in.nextInt();
        System.out.println(" Enter column for "+player+" ");
        col=in.nextInt();

        board[row][col]=player;
        loadBoard();
        return board;
    }
    protected int checkGame()
    {

        //checking row wise
        for(int i=0;i<ROWS;i++){
            if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]&&board[i][0]==board[i][2]&&board[i][0]!=' ')
            {
                return 1;
            }
        }
        //checking col wise
        for(int i=0;i<COLS;i++){
            if(board[0][i]==board[1][i]&&board[1][i]==board[2][i]&&board[0][i]==board[2][i]&&board[0][i]!=' ')
            {
                return 1;
            }
        }
        //checking diagnol
        if(board[0][0]==board[1][1]&&board[2][2]==board[1][1]&&board[0][0]!=' ')
        {
            return 1;
        }
        if(board[0][2]==board[1][1]&&board[2][0]==board[1][1]&&board[1][1]!=' ')
        {
            return 1;
        }
        //checking draw case
        boolean draw=true;
        for(int i=0;i<ROWS;i++)
        {
            for(int j=0;j<COLS;j++)
                if(board[i][j]==' '){
                    draw=false;
                    return 0;
                }
        }
        if(draw==true)
        {
            return 2;
        }


        //continue playing
        return 0;
    }

    public char[][] getBoard() {
        return board;
    }
}