package com.example.signlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class ChooseActivity extends AppCompatActivity {

    private  LottieAnimationView scaning;
    private  LottieAnimationView learning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        getSupportActionBar().hide();
        scaning=findViewById(R.id.animation_scan);
        learning=findViewById(R.id.animation_learning);

        scaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseActivity.this,MainActivity.class));
            }
        });





    }
}