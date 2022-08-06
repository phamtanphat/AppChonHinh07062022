package com.example.appchonhinh07062022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgRandom, imgPick;
    String[] arrDrawable;
    int resourceRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgRandom = findViewById(R.id.imgRandom);
        imgPick = findViewById(R.id.imgPick);
        arrDrawable = getResources().getStringArray(R.array.arrays_drawable);

        int indexRandom = new Random().nextInt(arrDrawable.length);
        resourceRandom = getResources().getIdentifier(arrDrawable[indexRandom], "drawable", getPackageName());
        imgRandom.setImageResource(resourceRandom);
    }
}
