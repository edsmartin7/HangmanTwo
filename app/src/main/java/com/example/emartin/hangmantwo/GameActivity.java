package com.example.emartin.hangmantwo;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends AppCompatActivity {

    String word = "WORD";
    int failCounter = 0;
    int guessedLetters = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen_layout);
    }

    //check if letter is in word or not
    public void checkLetter(View v) {

        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);
        String guessedLetter = myEditText.getText().toString();

        //if user does not enter anything
        if(guessedLetter.length() != 1) {
            Toast.makeText(this, "Please introduce a letter", Toast.LENGTH_SHORT).show();
        } else {

            //char charIntroduced = introduceLetter.charAt(0);
            boolean found = false;
            for (int letter = 0; letter < word.length(); letter++) {
                char charFromTheWord = word.charAt(letter);

                if (charFromTheWord  == guessedLetter.charAt(0)) {
                    showLettersAtIndex(letter, guessedLetter.charAt(letter));
                    found = true;
                    guessedLetters++;
                }
            }

            if (found == false) {
                letterFailed(guessedLetter);
            }

            //game won, score one point, change screen
            if (guessedLetters == word.length()) {

            }

        }
    }

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

    public void letterFailed(String letterFailed) {

        //TextView textViewFailed = (TextView) findViewById(R.id.textView6);
        //textViewFailed.setText(letterFailed);

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
            Intent gameOverIntent = new Intent(this, GameOverActivity.class);
            startActivity(gameOverIntent);
        }


    }

    //displaying a letter guessed correctly by the user
    public void showLettersAtIndex(int position, char letterGuessed) {
        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.word_view);
        TextView textView = (TextView) layoutLetter.getChildAt(position);
        textView.setText(letterGuessed);
    }

}
