public class PlayerX extends Board
{
    //Child class representing Player X
    public PlayerX()
    {
        super();
    }
    public void makeMove(int row, int col)
    {
        board[row][col] = 'X';
    }
}

