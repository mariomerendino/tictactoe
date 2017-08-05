package mariomerendino.tictactoe.logic;

/**
 * Created by mariomerendino on 5/8/17.
 */

public class Board {
    public Player[] p;
    public int currentPlayer;
    public Cell[] grid;
    public int turns;
    public Board(String name1, String name2){
        p = new Player[2];
        p[0] = new Player(name1, "X");
        p[1] = new Player(name2, "O");

        grid = new Cell[9];
        for(int i=0; i < 9; i++){
            grid[i] = new Cell();
        }
        currentPlayer = 0;
    }
    public Boolean makeMove(int location){
        boolean validMove = false;
            if (grid[location].changeState(p[currentPlayer].letter)) {
                validMove = true;
                turns++;
            }
        return validMove;
    }
    public void swapPlayer(){
        if(currentPlayer == 1) {
            currentPlayer = 0;
        }
        else {
            currentPlayer = 1;
        }
    }
    public boolean checkWinner(){
        boolean winner = false;
        if(turns > 4){
            //ALL HORIZONTALS
            if(grid[0].state == grid[1].state && grid[0].state == grid[2].state && grid[0].state != 0){
                winner = true;
            }
            if(grid[3].state == grid[4].state && grid[3].state == grid[5].state && grid[3].state != 0){
                winner = true;
            }
            if(grid[6].state == grid[7].state && grid[6].state == grid[8].state && grid[6].state != 0){
                winner = true;
            }
            //ALL VERTICALS
            if(grid[0].state == grid[3].state && grid[0].state == grid[6].state && grid[0].state != 0){
                winner = true;
            }
            if(grid[1].state == grid[4].state && grid[1].state == grid[7].state && grid[0].state != 0){
                winner = true;
            }
            if(grid[2].state == grid[5].state && grid[2].state == grid[8].state && grid[0].state != 0){
                winner = true;
            }
            //BOTH DIAGONALS
            if(grid[0].state == grid[4].state && grid[0].state == grid[8].state && grid[0].state != 0){
                winner = true;
            }
            if(grid[2].state == grid[4].state && grid[2].state == grid[6].state && grid[2].state != 0){
                winner = true;
            }
        }
        if(winner){
            p[currentPlayer].wins++;
        }
        return winner;
    }
}
