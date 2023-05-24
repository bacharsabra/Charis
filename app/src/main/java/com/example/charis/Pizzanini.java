package com.example.charis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.Charis.R;

public class Pizzanini extends AppCompatActivity {

    CheckBox checkBox, checkBox1, checkBox2;
    String choices = "";
    Double price = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzanini);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);

        Button button = findViewById(R.id.btnOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placeorder();

            }
        });
    }

    public void add_to_list(View view) {
        if (view == findViewById(R.id.checkBox)) {
            choices = choices + "Pepperoni Pizza" + "\n";
            price = price + 30000;

        } else if (view == findViewById(R.id.checkBox1)) {
            choices = choices + "Vegetarian Pizza" + "\n";
            price = price + 30000;

        } else if (view == findViewById(R.id.checkBox2)) {
            choices = choices + "Tawouk Pizza" + "\n";
            price = price + 30000;

        }
    }

    private void placeorder() {
        Intent placeorder = new Intent(getApplicationContext(), CartActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("choices", choices);
        bundle.putDouble("price", price);
        placeorder.putExtras(bundle);
        startActivity(placeorder);

    }
}