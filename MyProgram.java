import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args) {
        C4 game = new C4();
        Scanner scanny = new Scanner(System.in);
        //game loop
        while (true) {
            //print the board
            System.out.println(game.getBoard());
            //get player input
            System.out.println(game.getTurn() + "'s turn, pick a column (1-7)");
            int col = 0;
            while (col == 0) {
                String input = scanny.nextLine();
                if (input.length() == 1 && input.compareTo("1") >= 0 && input.compareTo("7") <= 0) 
                    col = Integer.parseInt(input);
                //try to take the turn
                game.takeTurn(col);
                //try again if invalid
            }
            //check for game over
            System.out.println(game.getWinner());
            
            
        }
    }
}