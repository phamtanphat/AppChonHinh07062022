package com.example.appchonhinh07062022;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgRandom, imgPick;
    String[] arrDrawable;
    int resourceRandom;
    int REQUEST_CODE = 1;
    TextView tvTime;
    CountDownManager countDownManager;
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
        startCountDown();
    }

    private void startCountDown() {
        countDownManager = new CountDownManager(10000, 1000);
        countDownManager.start();
    }

    private void stopCountDown() {
        if (countDownManager != null) {
            countDownManager.cancel();
        }
    }
    private void initView() {
        imgRandom = findViewById(R.id.imgRandom);
        imgPick = findViewById(R.id.imgPick);
        tvTime = findViewById(R.id.text_view_time);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CountDownManager.setOnListenerCountDown(new CountDownManager.OnListenCountDown() {
            @Override
            public void onTick(long currentTime) {
                tvTime.setText(String.valueOf((int) (currentTime / 1000)));
            }

            @Override
            public void onFinish() {
                tvTime.setText("0");
                Toast.makeText(MainActivity.this, "Hết giờ", Toast.LENGTH_SHORT).show();
            }
        });

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
                stopCountDown();
                startCountDown();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            int resourceReceive = data.getIntExtra("drawable", -1);
            imgPick.setImageResource(resourceReceive);
            if (resourceReceive == resourceRandom) {
                Toast.makeText(this, "Chọn chính xác", Toast.LENGTH_SHORT).show();
                randomImage();
            } else {
                Toast.makeText(this, "Sai rồi", Toast.LENGTH_SHORT).show();
            }
            stopCountDown();
            startCountDown();
        } else {
            Toast.makeText(this, "Hết giờ", Toast.LENGTH_SHORT).show();
            tvTime.setText("0");
        }
    }
}
