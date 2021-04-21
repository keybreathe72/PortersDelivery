package com.example.portersdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import java.util.ArrayList;



import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class HomePage extends AppCompatActivity implements Adapterfeatured.ListItemClickListener, Adaptercurrent.ListItemClickListener {

    RecyclerView featuredRecycler, mostViewedRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);

        //Functions will be executed automatically when this activity will be created
        featuredRecycler();
        mostViewedRecycler();

    }


    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.star_ocean, "Star Ocean","'luxury, seafood, excellent'"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.agatha, "Agatha","'The best of fine dining'"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.artiste_dessert, "Artiste Dessert","'Welcome 'Art lover''"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.field_restaurant, "Field Restaurant","'Gives you the best'"));

        adapter = new Adapterfeatured(featuredLocations, this);
        featuredRecycler.setAdapter(adapter);

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();

        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.hkrestaruant, "阿不列餐廳", "在旺角的特色茶餐廳"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.hkrestaurant33, "東日日本料理", "在旺角的日式料理"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.hkrestaurant4, "泰好食", "在旺角的泰式餐廳"));

        adapter = new Adaptercurrent(mostViewedLocations, this::oncurrentListClick);
        mostViewedRecycler.setAdapter(adapter);


    }

    @Override
    public void onfeaturedListClick(int clickedItemIndex) {

        Intent mIntent;
        switch (clickedItemIndex){
            case 0: //first item in Recycler view
                mIntent  = new Intent(HomePage.this, StarOcean.class);
                startActivity(mIntent);
                break;
            case 1: //second item in Recycler view
                mIntent = new Intent(HomePage.this, Agatha.class);
                startActivity(mIntent);
                break;
            case 2: //third item in Recycler view
                mIntent = new Intent(HomePage.this, Adessert.class);
                startActivity(mIntent);
                break;
            case 3: //third item in Recycler view
                mIntent = new Intent(HomePage.this, Frestaurant.class);
                startActivity(mIntent);
                break;


        }
    }

    @Override
    public void oncurrentListClick(int currentclickedItemIndex) {

        Intent cmIntent;
        switch (currentclickedItemIndex){
            case 0: //first item in Recycler view
                cmIntent  = new Intent(HomePage.this, HKrestaurant.class);
                startActivity(cmIntent);
                break;
            case 1: //second item in Recycler view
                cmIntent = new Intent(HomePage.this, HKrestaurant2.class);
                startActivity(cmIntent);
                break;
            case 2: //third item in Recycler view
                cmIntent = new Intent(HomePage.this, HKrestaurant3.class);
                startActivity(cmIntent);

    }

    }
}

