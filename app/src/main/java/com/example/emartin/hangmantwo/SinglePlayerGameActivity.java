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


public class SinglePlayerGameActivity extends AppCompatActivity {

    //String word = "WORD";
    private String word;
    int failCounter = 0;
    int guessedLetters = 0;
    private static int points = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleplayer_game_layout);

        word = setRandomWord();

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

    /*
    //check if letter is in word or not
    public void checkLetter(View v) {

        EditText myEditText = (EditText) findViewById(R.id.guessed_letter);
        String guessedLetter = myEditText.getText().toString();

        //if user does not enter anything
        if(guessedLetter.length() != 1) {
            Toast.makeText(this, "Please introduce a letter", Toast.LENGTH_SHORT).show();
        } else {

            boolean found = false;
            for (int letter = 0; letter < word.length(); letter++) {
                char charFromTheWord = word.charAt(letter);
                if (charFromTheWord  == guessedLetter.charAt(0)) {
                    //String send = "" + guessedLetter.charAt(letter);
                    correctGuessDisplay(letter, ""+guessedLetter.charAt(letter));
                    found = true;
                    guessedLetters++;
                }
            }

            if (found == false) {
                incorrectGuess(guessedLetter);
            }

            //game won, score one point, change screen
            if (guessedLetters == word.length()) {

            }

        }
    }
    */

    /*
    public void clearScreen() {
        //side text view of guessed letters
        //TextView textViewFailed = (TextView) findViewById(R.id.textView6);
        //textViewFailed.setText("");

        //reset settings
        guessedLetters = 0;
        failCounter = 0;

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutletters);

        for(int x=0; x<layoutLetters.getChildCount(); x++) {
            TextView currentTextView = (TextView) layoutLetters.getChildCount();
            //

        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.hangdroid_0);

    }
    */

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

    public String setRandomWord() {

        String[] words = {"hello", "word", "funk", "help",  "this", "that"};

        //int randomNumber = (int)Math.random() * words.length;
        Random rand = new Random();
        int randomNumber = rand.nextInt(words.length)+1;

        String randomWord = words[randomNumber];
        Log.d("Correct word", randomWord);

        return randomWord;

    }

    /*
    //displaying a letter guessed correctly by the user
    public void correctGuessDisplay(int position, String letterGuessed) {

        LinearLayout wordAnswer = (LinearLayout) findViewById(R.id.word_view);
        TextView textView = (TextView) wordAnswer.getChildAt(position);
        textView.setText(letterGuessed);
        ((EditText) findViewById(R.id.guessed_letter)).setText("");

    }
    */

    public void correctGuessDisplay(int position, char letterGuessed) {

        LinearLayout wordAnswer = (LinearLayout) findViewById(R.id.word_view);
        TextView textView = (TextView) wordAnswer.getChildAt(position);
        textView.setText(""+letterGuessed);
        ((EditText) findViewById(R.id.guessed_letter)).setText("");

    }

}
