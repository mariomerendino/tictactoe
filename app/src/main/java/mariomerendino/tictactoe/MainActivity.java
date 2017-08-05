package mariomerendino.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    Button playButton;
    Button optionsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.button);
        optionsButton = (Button) findViewById(R.id.button2);

    }

    protected void playButtonClicked(View V){
        Intent intent = new Intent(MainActivity.this, setup.class);
        startActivity(intent);
    }
}
