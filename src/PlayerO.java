//Child class representing Player O
class PlayerO extends Board
{
    public PlayerO()
    {
        super();
    }
    public void makeMove(int row, int col)
    {
        board[row][col] = 'O';
    }
}

