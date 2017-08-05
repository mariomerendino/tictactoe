package mariomerendino.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.*;
import android.widget.*;
import mariomerendino.tictactoe.logic.*;
import android.content.Intent;

public class Game extends AppCompatActivity {

    TextView mainLabel;
    Button[] buttonArray;
    Button playAgain;
    Board gameBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mainLabel = (TextView) findViewById(R.id.label);
        buttonArray = new Button[9];
        buttonArray[0] = (Button) findViewById(R.id.grid0);
        buttonArray[1] = (Button) findViewById(R.id.grid1);
        buttonArray[2] = (Button) findViewById(R.id.grid2);
        buttonArray[3] = (Button) findViewById(R.id.grid3);
        buttonArray[4] = (Button) findViewById(R.id.grid4);
        buttonArray[5] = (Button) findViewById(R.id.grid5);
        buttonArray[6] = (Button) findViewById(R.id.grid6);
        buttonArray[7] = (Button) findViewById(R.id.grid7);
        buttonArray[8] = (Button) findViewById(R.id.grid8);
        playAgain = (Button)findViewById(R.id.playAgain);
        Intent intent = getIntent();
        gameBoard = new Board(intent.getStringExtra("name1"), intent.getStringExtra("name2"));
        mainLabel.setText(gameBoard.p[gameBoard.currentPlayer].name + "'s turn");
    }
    protected void grid0ButtonClicked(View V){
        move(0);

    }
    protected void grid1ButtonClicked(View V){
        move(1);
    }
    protected void grid2ButtonClicked(View V){
        move(2);
    }
    protected void grid3ButtonClicked(View V){
        move(3);
    }
    protected void grid4ButtonClicked(View V){
        move(4);
    }
    protected void grid5ButtonClicked(View V){
        move(5);
    }
    protected void grid6ButtonClicked(View V){
        move(6);
    }
    protected void grid7ButtonClicked(View V){
        move(7);
    }
    protected void grid8ButtonClicked(View V){
        move(8);
    }
    protected void move(int location){
        if(gameBoard.makeMove(location)){
            buttonArray[location].setText(gameBoard.p[gameBoard.currentPlayer].letter);
            if(gameBoard.checkWinner()) {
                mainLabel.setText("WINNER: " + gameBoard.p[gameBoard.currentPlayer].name);
                playAgain.setVisibility(View.VISIBLE);
                disableGrid();
            }
            else if(gameBoard.turns == 9){
                mainLabel.setText("There is a Draw");
                playAgain.setVisibility(View.VISIBLE);
                disableGrid();
            }
            else{
                gameBoard.swapPlayer();
                mainLabel.setText(gameBoard.p[gameBoard.currentPlayer].name + "'s turn");

            }
        }
        else{
            mainLabel.setText("Error: That spot is taken\n" + gameBoard.p[gameBoard.currentPlayer].name + "'s turn");
        }
    }
    protected void disableGrid(){
        for(int i =0; i < 9; i++){
            buttonArray[i].setEnabled(false);
        }
    }
    protected void replay(View V){
        Intent intent = new Intent(Game.this, Game.class);
        intent.putExtra("name1", gameBoard.p[0].name);
        intent.putExtra("name2", gameBoard.p[1].name);

        startActivity(intent);
        finish();
    }


}
