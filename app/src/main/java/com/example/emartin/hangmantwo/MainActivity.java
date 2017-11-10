package com.example.emartin.hangmantwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//https://developer.android.com/guide/topics/resources/drawable-resource.html
//https://developer.android.com/reference/android/graphics/drawable/ShapeDrawable.html
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen_layout);

    }

    public void startSinglePlayerGame(View view) {

        //create an intent, to start a new activity
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);

    }


}
