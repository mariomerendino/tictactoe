package mariomerendino.tictactoe.logic;

/**
 * Created by mariomerendino on 5/8/17.
 */

public class Player {
    //Players name
    public String name;
    //X or O
    public String letter;
    //Num of wins
    public int wins;
    //Player Constructor
    Player(String n, String l){
        name = n;
        letter = l;
    }

}
