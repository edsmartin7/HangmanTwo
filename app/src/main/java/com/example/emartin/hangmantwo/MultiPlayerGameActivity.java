package com.example.emartin.hangmantwo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MultiPlayerGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //createTextViews();

    }

    /*
    //create textviews dynamically (for a word)
    public void createTextViews(String word) {

        LinearLayout layoutletters = (LinearLayout) findViewById(R.id.layoutletters);

        //for each letter in the word, create a text view
        for(int x=0; x<word.length(); x++) {
            //create new xml textview file
            TextView newTextView = (TextView) getLayoutInflater().inflate(R.layout.single_text_view);
            layoutletters.addView(newTextView);
        }

    }
    */

    //add a game over intent

}
