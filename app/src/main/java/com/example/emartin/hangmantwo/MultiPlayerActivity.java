package com.example.emartin.hangmantwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MultiPlayerActivity extends AppCompatActivity {

    private String wordToGuess;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer_layout);
    }

    public void startMultiGame(View view) {

        EditText editText = (EditText) findViewById(R.id.editTextWord);
        wordToGuess = editText.getText().toString();

        Intent myIntent = new Intent(this, MultiPlayerGameActivity.class);
        myIntent.putExtra("WORD_SENT", wordToGuess);
        startActivity(myIntent);

    }

}
