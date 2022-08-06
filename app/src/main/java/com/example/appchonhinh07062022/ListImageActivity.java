package com.example.appchonhinh07062022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class ListImageActivity extends AppCompatActivity {

    String[] arrDrawable;
    TableLayout tbLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);

        tbLayout = findViewById(R.id.table_layout);

        Intent intent = getIntent();
        if (intent != null) {
            arrDrawable = intent.getStringArrayExtra("arrDrawable");
            if (arrDrawable != null) {

                for (int i = 0; i < 6; i++) {
                    TableRow tableRow = new TableRow(ListImageActivity.this);
                    for (int j = 0; j < 3; j++) {
                        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(300,300);
                        ImageView imageView = new ImageView(ListImageActivity.this);
                        imageView.setLayoutParams(layoutParams);
                        imageView.setImageResource(R.drawable.bo);
                        tableRow.addView(imageView);
                    }
                    tbLayout.addView(tableRow);
                }
            }
        }
    }
}
