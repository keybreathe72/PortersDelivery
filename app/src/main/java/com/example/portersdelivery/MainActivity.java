package com.example.portersdelivery;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;


public class MainActivity extends AppCompatActivity {

    private static int Change_screen = 5000;

    Animation loading_animator, loading2_animator;
    ImageView image;
    TextView slogan, title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        loading_animator = AnimationUtils.loadAnimation(this,R.anim.loading_animator);
        loading2_animator = AnimationUtils.loadAnimation(this, R.anim.loading2_animator);

        image = findViewById(R.id.loading_image);
        title = findViewById(R.id.loading_title);
        slogan = findViewById(R.id.loading_slogan);

        image.setAnimation(loading_animator);
        title.setAnimation(loading2_animator);
        slogan.setAnimation(loading2_animator);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        },Change_screen);


    }
}