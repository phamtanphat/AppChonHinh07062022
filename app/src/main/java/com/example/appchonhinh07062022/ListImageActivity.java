package com.example.appchonhinh07062022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class ListImageActivity extends AppCompatActivity {

    String[] arrDrawable;
    TableLayout tbLayout;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);

        tbLayout = findViewById(R.id.table_layout);

        Intent intent = getIntent();
        if (intent != null) {
            arrDrawable = intent.getStringArrayExtra("arrDrawable");
            Collections.shuffle(Arrays.asList(arrDrawable));

            CountDownManager.setOnListenerCountDown(new CountDownManager.OnListenCountDown() {
                @Override
                public void onTick(long currentTime) {

                }

                @Override
                public void onFinish() {
                    Intent intentData = new Intent();
                    setResult(RESULT_CANCELED, intentData);
                    finish();
                }
            });

            if (arrDrawable != null) {
                for (int i = 0; i < 6; i++) {
                    TableRow tableRow = new TableRow(ListImageActivity.this);
                    for (int j = 0; j < 3; j++) {
                        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(300,300);
                        ImageView imageView = new ImageView(ListImageActivity.this);
                        imageView.setLayoutParams(layoutParams);
                        index = (i * 3) + j;
                        imageView.setImageResource(getResources().getIdentifier(arrDrawable[index], "drawable", getPackageName()));
                        imageView.setTag(getResources().getIdentifier(arrDrawable[index], "drawable", getPackageName()));
                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intentData = new Intent();
                                intentData.putExtra("drawable", (int) imageView.getTag());
                                setResult(RESULT_OK, intentData);
                                finish();
                            }
                        });
                        tableRow.addView(imageView);
                    }
                    tbLayout.addView(tableRow);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,20);
                    LinearLayout linearLayout = new LinearLayout(this);
                    linearLayout.setLayoutParams(layoutParams);
                    tbLayout.addView(linearLayout);
                }
            }
        }
    }
}
