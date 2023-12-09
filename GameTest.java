package TicTacToe;

import TicTacToe.Game;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game gameInstance;

    @Before
    public void setUp() {
        gameInstance = new Game(); // Instantiate your Game class here
    }

    @Test
    public void testCheckGame_Win() {
        char[][] board=new char[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=' ';
            }
        }
        // Set up a winning scenario in the board
        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';

        gameInstance.setBoard(board);

        // Call checkGame() to check for a win
        int result = gameInstance.checkGame();

        // Assert that the game returns 1 (win)
        assertEquals(1, result);
    }

    @Test
    public void testCheckGame_Draw() {
        char[][] board=new char[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=' ';
            }
        }

        // Set up a draw scenario in the board
        board[0][0] = 'X';
        board[0][1] = 'O';
        board[0][2] = 'X';
        board[1][0] = 'X';
        board[1][1] = 'X';
        board[1][2] = 'O';
        board[2][0] = 'O';
        board[2][1] = 'X';
        board[2][2] = 'O';

        gameInstance.setBoard(board);
        // Call checkGame() to check for a draw
        int result = gameInstance.checkGame();

        // Assert that the game returns 2 (draw)
        assertEquals(2, result);
    }

    @Test
    public void testPlayMethod() {
        String input = "0\n0\n"; // Simulated user input
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        // Backup original System.in and replace it with the custom input stream
        InputStream originalSystemIn = System.in;
        System.setIn(inputStream);

        char[][] board=new char[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=' ';
            }
        }
        board[0][0]='X';
        gameInstance.play(); // Perform the method call

        // Restore original System.in
        System.setIn(originalSystemIn);

      //  assertEquals(board, gameInstance.play());
    }
}
