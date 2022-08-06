package com.example.appchonhinh07062022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

        randomImage();
    }

    private void randomImage() {
        int indexRandom = new Random().nextInt(arrDrawable.length);
        resourceRandom = getResources().getIdentifier(arrDrawable[indexRandom], "drawable", getPackageName());
        imgRandom.setImageResource(resourceRandom);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_refresh:
                randomImage();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
