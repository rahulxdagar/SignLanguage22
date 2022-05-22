package com.example.signlanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    ImageView logo,splashImg;
    LottieAnimationView lottieAnimationView;

    private  static final int NUM_PAGES=3;
    private ViewPager2 viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;


    Animation anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        logo=findViewById(R.id.imageLogo);
        splashImg=findViewById(R.id.imageSplashBackg);

        lottieAnimationView=findViewById(R.id.animation_splash);



        splashImg.animate().translationY(-2200).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(2000).setDuration(1000).setStartDelay(4000);

        /* Thread t1=new Thread(){
         public void run(){
             try{
                 sleep(4000);
             }
             catch(Exception e){
                 e.printStackTrace();
             }

             finally{
                 FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                 if(currentUser != null){
                     startActivity(new Intent(SplashActivity.this,MainActivity.class));
                 }
                 finish();
             }
         }
        };
        t1.start();*/





        viewPager=findViewById(R.id.pager);
        pagerAdapter=new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        anim= AnimationUtils.loadAnimation(this,R.anim.ob_anim);
        viewPager.setAnimation(anim);


    }

   private class ScreenSlidePagerAdapter extends FragmentStateAdapter{


       public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
           super(fragmentActivity);
       }

       @NonNull
       @Override
       public Fragment createFragment(int position) {
           switch (position){
               case 0:
                   return  new OnBoardingFragment1();
               case 1:
                   return new OnBoardingFragment2();
               case 2:
                   return new OnBoardingFragment3();
           }
           return null;
       }

       @Override
       public int getItemCount() {
           return NUM_PAGES;
       }
   }


}