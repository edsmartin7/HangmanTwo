package com.example.emartin.hangmantwo;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MultiPlayerGameActivity extends AppCompatActivity {

    private String word;
    int failCounter = 0;
    int guessedLetters = 0;
    private static int points = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer_game_screen);

        Intent intent = getIntent();
        word = intent.getStringExtra("WORD_SENT");
        Log.d("NEW GAMES WORD IS ", word);
        //word = setRandomWord();
        createTextViews(word);

    }

    //create textviews dynamically (for a word)
    public void createTextViews(String word) {

        LinearLayout layoutletters = (LinearLayout) findViewById(R.id.word_view);

        //for each letter in the word, create a text view
        for(int x=0; x<word.length(); x++) {
            //create new xml textview file
            TextView newTextView = (TextView) getLayoutInflater().inflate(R.layout.single_text_view, null);
            //TextView newTextView = (TextView) findViewById(R.id.blank_text_view);
            layoutletters.addView(newTextView);
        }

    }

    public void introduceLetter(View v) {

        EditText myEditText = (EditText) findViewById(R.id.guessed_letter);
        String guessedLetter = myEditText.getText().toString();

        //if user does not enter anything
        if(guessedLetter.length() != 1) {
            Toast.makeText(this, "Please introduce a letter", Toast.LENGTH_SHORT).show();
        } else {
            checkLetter(guessedLetter);
        }

    }

    public void checkLetter(String givenLetter) {

        boolean found = false;
        char charIntroduced = givenLetter.charAt(0);

        for (int letter = 0; letter < word.length(); letter++) {
            char charFromTheWord = word.charAt(letter);
            if (charFromTheWord  == charIntroduced) {
                //String send = "" + guessedLetter.charAt(letter);
                correctGuessDisplay(letter, charIntroduced);
                found = true;
                guessedLetters++;
            }
        }

        if (found == false) {
            incorrectGuess(charIntroduced);
        }

        //game won, score one point, change screen
        if (guessedLetters == word.length()) {
            Toast.makeText(this, "YOU WIN!!!", Toast.LENGTH_LONG).show();
            finish();
        }


    }

    public void correctGuessDisplay(int position, char letterGuessed) {

        LinearLayout wordAnswer = (LinearLayout) findViewById(R.id.word_view);
        TextView textView = (TextView) wordAnswer.getChildAt(position);
        textView.setText(""+letterGuessed);
        ((EditText) findViewById(R.id.guessed_letter)).setText("");

    }

    public void incorrectGuess(char letterFailed) {

        //TextView textViewFailed = (TextView) findViewById(R.id.textView6);
        //textViewFailed.setText(""+letterFailed);

        failCounter++;
        ImageView imageView = (ImageView) findViewById(R.id.hangman);

        if (failCounter == 1) {
            imageView.setImageResource(R.drawable.hangdroid_1);
        } else if (failCounter == 2) {
            imageView.setImageResource(R.drawable.hangdroid_2);
        } else if (failCounter == 3) {
            imageView.setImageResource(R.drawable.hangdroid_3);
        } else if (failCounter == 4) {
            imageView.setImageResource(R.drawable.hangdroid_4);
        } else if (failCounter == 5) {
            imageView.setImageResource(R.drawable.hangdroid_5);
        } else if (failCounter == 6) {
            //game over
            //Intent gameOverIntent = new Intent(this, GameOverActivity.class);
            //gameOverIntent.putExtra("Points_Sent", points);
            //startActivity(gameOverIntent);
            Toast.makeText(this, "YOU LOSE!!!", Toast.LENGTH_LONG).show();
            finish();
        }

    }

    //add a game over intent

}
