package mariomerendino.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class setup extends AppCompatActivity {
    EditText field1;
    EditText field2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        Intent intent = getIntent();
        field1 = (EditText) findViewById(R.id.playerName1);
        field2 = (EditText) findViewById(R.id.playerName2);
    }
    protected void playButton2Clicked(View V){

        Intent intent = new Intent(setup.this, Game.class);
        intent.putExtra("name1", field1.getText().toString());
        intent.putExtra("name2", field2.getText().toString());
        startActivity(intent);
    }
}
