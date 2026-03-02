public class C4 {
    private static final int P1 = 1;
    private static final int P2 = -1;
    private static final String T1 = "R";
    private static final String T2 = "Y";
    public static final int MAX_TURNS = 42;
    public static final int TIE = 713;
    private int[][] board;
    private int winner;
    private int turnCount;
    private int turn;
    
    public C4() {
        board = new int[6][7];
        winner = 0;
        turnCount = 0;
        turn = P1;
    }
    
    public String getTurn() {
        if (turn == P1)
            return T1;
        return T2;
    }
    
    //return a string representing the board
    public String getBoard() {
        String b = "+---+---+---+---+---+---+---+\n";
        for (int[] row : board) {
            b += "| ";
            for (int space : row) {
                if (space == P1)
                    b += T1 + " | ";
                else if (space == P2)
                    b += T2 + " | ";
                else
                    b += "  | ";
            }
            b += "\n+---+---+---+---+---+---+---+\n";
        }
        return b;
    }
    
    //take in a column number and place a token and return success status
    public boolean takeTurn(int c) {
        if (c < 1 || c > 7)
            return false;
        c -= 1; //indices start at 0 instead of 1
        //start at the last row and work our way up.
        for (int r = board.length - 1; r > -1; r--) {
            if (board[r][c] == 0) {
                board[r][c] = turn;
                turn *= -1;
                turnCount++;
                return true;
            }
        }
        return false;
    }
    
    public int getWinner() {
        //check for a tie
        if (turnCount == MAX_TURNS)
            winner = TIE;
        //check for a win
        //horizontal
        for (int[] row : board) {
            for (int c = 0; c < 4; c++) {
                int total = row[c] + row[c+1] + row[c+2] + row[c+3];
                if (total == 4)
                    winner = P1;
                if (total == -4)
                    winner = P2;
            }
        }
        //vertical
        for (int c = 0; c < board[0].length; c++) {
            for (int r = 0; r < 3; r++) {
                int total = board[r][c] + board[r+1][c] + board[r+2][c] + board[r+3][c];
                if (total == 4)
                    winner = P1;
                if (total == -4)
                    winner = P2;
            }
        }
        //diagonal down and right
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 4; c++) {
                int total = board[r][c] + board[r+1][c+1] + board[r+2][c+2] + board[r+3][c+3];
                if (total == 4)
                    winner = P1;
                if (total == -4)
                    winner = P2;
            }
        }
        //diagonal up and right
        for (int r = 3; r < board.length; r++) {
            for (int c = 0; c < 4; c++) {
                int total = board[r][c] + board[r-1][c+1] + board[r-2][c+2] + board[r-3][c+3];
                if (total == 4)
                    winner = P1;
                if (total == -4)
                    winner = P2;
            }
        }
        return winner;
    }
    
}