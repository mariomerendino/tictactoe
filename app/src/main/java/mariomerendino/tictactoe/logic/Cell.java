package mariomerendino.tictactoe.logic;

/**
 * Created by mariomerendino on 5/8/17.
 */

public class Cell {
    //Cells state: 0 = Empty, 1 = X, 2 = 0;
    public int state;

    public Cell() {
        state = 0;
    }

    public boolean changeState(String playerLetter){
        Boolean stateChanged = false;
        if(state == 0){
            if (playerLetter == "X")
                state = 1;
            if (playerLetter == "O")
                state = 2;
            stateChanged= true;
        }
        return stateChanged;
    }


}
