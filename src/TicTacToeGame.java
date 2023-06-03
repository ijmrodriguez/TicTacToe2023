import javax.swing.JOptionPane;

// Game class to handle the overall game logic
class TicTacToeGame
{
    private final PlayerX playerX;
    private final PlayerO playerO;
    private Board currentBoard;

    public TicTacToeGame()
    {
        playerX = new PlayerX();
        playerO = new PlayerO();
        currentBoard = playerX;
    }

    public void playGame()
    {
        while (true)
        {
            currentBoard.printBoard();

            int row, col;
            do
            {
                String input = JOptionPane.showInputDialog("Enter row and column (e.g., 1 2):");
                String[] inputArr = input.split(" ");
                row = Integer.parseInt(inputArr[0]) - 1;
                col = Integer.parseInt(inputArr[1]) - 1;
            } while (!currentBoard.isValidMove(row, col));

            currentBoard.makeMove(row, col);

            if (checkWin())
            {
                currentBoard.printBoard();
                System.out.println("Player " + (currentBoard instanceof PlayerX ? "X" : "O") + " wins!");
                break;
            }

            if (currentBoard.isBoardFull())
            {
                currentBoard.printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Switch turns between players
            currentBoard = (currentBoard instanceof PlayerX) ? playerO : playerX;
        }
    }

    private boolean checkWin()
    {
        char symbol = currentBoard instanceof PlayerX ? 'X' : 'O';

        // Check rows and columns
        for (int i = 0; i < 3; i++)
        {
            if (currentBoard.board[i][0] == symbol && currentBoard.board[i][1] == symbol && currentBoard.board[i][2] == symbol)
                return true;
            if (currentBoard.board[0][i] == symbol && currentBoard.board[1][i] == symbol && currentBoard.board[2][i] == symbol)
                return true;
        }

        // Check diagonals
        if (currentBoard.board[0][0] == symbol && currentBoard.board[1][1] == symbol && currentBoard.board[2][2] == symbol)
            return true;
        return currentBoard.board[0][2] == symbol && currentBoard.board[1][1] == symbol && currentBoard.board[2][0] == symbol;
    }
}

