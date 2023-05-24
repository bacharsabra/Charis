package com.example.charis;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Charis.R;

public class LLB extends AppCompatActivity {
    ImageView imageView;
    TextView itemName, itemDate;

    String name, date, imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_love_beirut);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        date = intent.getStringExtra("date");;
        imageUrl = intent.getStringExtra("image");

        imageView = findViewById(R.id.imageView);
        itemName = findViewById(R.id.name);
        itemDate = findViewById(R.id.date);

        itemName.setText(name);
        itemDate.setText(date);

    }
}
