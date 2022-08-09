package com.example.appchonhinh07062022;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgRandom, imgPick;
    String[] arrDrawable;
    int resourceRandom;
    int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        event();
    }

    private void initData() {
        arrDrawable = getResources().getStringArray(R.array.arrays_drawable);
        randomImage();
    }

    private void initView() {
        imgRandom = findViewById(R.id.imgRandom);
        imgPick = findViewById(R.id.imgPick);
    }

    private void event() {
        imgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListImageActivity.class);
                intent.putExtra("arrDrawable", arrDrawable);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            int drawableReceive = data.getIntExtra("drawable", -1);
            Log.d("BBB", drawableReceive + "");
        }
    }
}
