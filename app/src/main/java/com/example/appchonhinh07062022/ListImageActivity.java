package com.example.appchonhinh07062022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ListImageActivity extends AppCompatActivity {

    String[] arrDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);

        Intent intent = getIntent();
        if (intent != null) {
            arrDrawable = intent.getStringArrayExtra("arrDrawable");
            Animal animal = (Animal) intent.getParcelableExtra("animal");
            Log.d("BBB", animal.weight + "");
        }
    }
}
