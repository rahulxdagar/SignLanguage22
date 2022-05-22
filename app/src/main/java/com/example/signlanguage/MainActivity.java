package com.example.signlanguage;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
//    private WebView webView;
     Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Learn ASL");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





      /*  webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://sign-language-gesture.herokuapp.com");


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);*/
       // FirebaseAuth.getInstance().signOut();






        button=findViewById(R.id.charbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CharList.class);
                startActivity(intent);
            }
        });
        button=findViewById(R.id.phrasebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PhraseList.class);
                startActivity(intent);
            }
        });







    }
    /*@Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }*/



}