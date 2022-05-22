package com.example.signlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class ChooseActivity extends AppCompatActivity {

    private  LottieAnimationView scaning;
    private  LottieAnimationView learning;

    private FloatingActionButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        getSupportActionBar().hide();
        scaning=findViewById(R.id.animation_scan);
        learning=findViewById(R.id.animation_learning);
        logout=findViewById(R.id.fab_logout);

        scaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sign-language-gesture.herokuapp.com"));
                startActivity(intent);

                //startActivity(new Intent(ChooseActivity.this,MainActivity.class));
            }
        });

        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ChooseActivity.this,MainActivity.class));

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Toast.makeText(ChooseActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ChooseActivity.this,LoginActivity.class));

            }
        });






    }
}