//Parent class representing the game board
class Board
{
    protected char[][] board;

    public Board()
    {
        board = new char[3][3];
        initializeBoard();
    }
    private void initializeBoard()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    public void printBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean isBoardFull()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }
    public boolean isValidMove(int row, int col)
    {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    public void makeMove(int row, int col)
    {

    }
}

