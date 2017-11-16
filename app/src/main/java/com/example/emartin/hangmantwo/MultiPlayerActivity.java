package com.example.emartin.hangmantwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MultiPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer_game_screen);

    }

    public void startMultiGame(View view) {

        EditText editText = (EditText) findViewById(R.id.editTextWord);
        String wordToGuess = editText.getText().toString();

        Intent myIntent = new Intent(this, GameActivity.class);
        myIntent.putExtra("WORD_SENT", wordToGuess);
        startActivity(myIntent);


    }

}
