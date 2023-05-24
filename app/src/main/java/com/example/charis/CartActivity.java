package com.example.charis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Charis.R;

public class CartActivity extends AppCompatActivity {

    TextView listView, priceView;
    String list_choice;
    Double price_ll, price_donate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        listView = (TextView) findViewById(R.id.orderDetailstextView);
        priceView = (TextView) findViewById(R.id.showprice);

        Bundle bundle = getIntent().getExtras();
        list_choice = bundle.getString("choices");
        price_ll = bundle.getDouble("price");

        price_donate = price_ll * (1.1);
        listView.setText(list_choice);
        priceView.setText(price_donate.toString() + " L.L");

        Button button = findViewById(R.id.btnCheckout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkout();

            }
        });
    }
    private void checkout () {
        Toast.makeText(getApplicationContext(), "Transaction Completed!", Toast.LENGTH_SHORT).show();

    }
}