package com.example.emartin.hangmantwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen_layout);
        TextView customTextview = (TextView) findViewById(R.id.custom_text_view);

    }

    public void startSinglePlayerGame(View view) {

        //create an intent, to start a new activity
        Intent myIntent = new Intent(this, SinglePlayerGameActivity.class);
        startActivity(myIntent);

    }

    public void startMultiPlayerGame(View view) {

        Intent intent = new Intent(this, MultiPlayerActivity.class);
        startActivity(intent);

    }

}
