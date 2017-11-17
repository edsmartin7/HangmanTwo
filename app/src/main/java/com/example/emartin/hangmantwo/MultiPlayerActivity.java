package com.example.emartin.hangmantwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MultiPlayerActivity extends AppCompatActivity {

    private String word;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer_game_screen);

    }

    public void startMultiGame(View view) {

        EditText editText = (EditText) findViewById(R.id.editTextWord);
        String wordToGuess = editText.getText().toString();
        editText.setText("");

        Intent myIntent = new Intent(this, SinglePlayerGameActivity.class);
        myIntent.putExtra("WORD_SENT", wordToGuess);
        startActivity(myIntent);

    }

    public void someMethod() {

        int guessedLetters = 0; //?
        //to deal with stack of activities
        if(guessedLetters == word.length()) {
            finish();
        }

    }



}
