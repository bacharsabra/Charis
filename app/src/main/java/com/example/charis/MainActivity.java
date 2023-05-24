package com.example.charis;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Charis.R;
import com.example.charis.adapter.CharityAdapter;
import com.example.charis.adapter.RestaurantAdapter;
import com.example.charis.model.Charities;
import com.example.charis.model.Restaurants;
import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView charityRecyclerView, restaurantRecyclerView;
    boolean visible = true;
    CharityAdapter charityAdapter;
    RestaurantAdapter restaurantAdapter;
    DrawerLayout drawerLayout;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.contact);
        getCharityData();
        getRestaurantData();
        drawerLayout = findViewById(R.id.drawerlayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);

        navigationView.getMenu().findItem(R.id.menuLogout).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                logout();
                return true;
            }
        });

        navigationView.getMenu().findItem(R.id.menuLocation).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                mylocation();
                return true;
            }
        });

        navigationView.getMenu().findItem(R.id.menuAboutUs).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                aboutus();
                return true;
            }
        });

        navigationView.getMenu().findItem(R.id.menuContactUs).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if (visible) {
                    constraintLayout.setVisibility(View.VISIBLE);
                    visible = false;
                } else {
                    constraintLayout.setVisibility(View.INVISIBLE);
                    visible = true;
                }
                return true;
            }
        });

        navigationView.setItemIconTintList(null);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }

    private void logout() {
        Intent logout = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(logout);

    }

    private void mylocation() {
        Intent mylocation = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(mylocation);

    }

    private void aboutus() {
        Intent aboutus = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(aboutus);

    }

    private void getCharityData() {
        ArrayList<Charities> charitiesArrayList = new ArrayList<>();

        charitiesArrayList.add(new Charities("Lebanese Food Bank", R.drawable.lfb, "Est. 2012"));
        charitiesArrayList.add(new Charities("Food Blessed", R.drawable.fb, "Est. 2012"));
        charitiesArrayList.add(new Charities("Caritas", R.drawable.caritas, "Est. 1897"));
        charitiesArrayList.add(new Charities("Live Love Beirut", R.drawable.llb, "Est. 2012"));
        charitiesArrayList.add(new Charities("World Food Programme", R.drawable.wfp, "Est. 1961"));
        charityRecyclerView = findViewById(R.id.charity_recycler);
        charityAdapter = new CharityAdapter(this, charitiesArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        charityRecyclerView.setLayoutManager(layoutManager);
        charityRecyclerView.setAdapter(charityAdapter);

    }

    private void getRestaurantData() {

        ArrayList<Restaurants> restaurantsArrayList = new ArrayList<>();

        restaurantsArrayList.add(new Restaurants("Hani's Snack", R.drawable.hanis, "5", "Hamra"));
        restaurantsArrayList.add(new Restaurants("Simit Sarayi", R.drawable.simitlogo, "4.75", "Hazmieh"));
        restaurantsArrayList.add(new Restaurants("Crackers", R.drawable.crackers, "4", "Hamra"));
        restaurantsArrayList.add(new Restaurants("Pizanini", R.drawable.pizzanini, "3.75", "Dekwaneh"));
        restaurantRecyclerView = findViewById(R.id.restaurant_recycler);
        restaurantAdapter = new RestaurantAdapter(this, restaurantsArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        restaurantRecyclerView.setLayoutManager(layoutManager);
        restaurantRecyclerView.setAdapter(restaurantAdapter);

    }
}