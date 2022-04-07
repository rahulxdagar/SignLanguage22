package com.example.signlanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    private EditText email;
    private AppCompatButton reset;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email=findViewById(R.id.email_forget);
        reset=findViewById(R.id.button_resetpass);
        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progress_bar_forget);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f_email=email.getText().toString().trim();

                Log.v("check","Error : Before reset");
                if(f_email.isEmpty()){
                    email.setError("Email is required !");
                    email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(f_email).matches()){
                    email.setError("Please provide a valid email !");
                    email.requestFocus();
                    return;
                }


               progressBar.setVisibility(view.VISIBLE);
                mAuth.sendPasswordResetEmail(f_email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Log.v("check","Error : After reset"+f_email);

                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Check you email to reset password", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(view.GONE);

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Something worng happened. Try again later !", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(view.GONE);
                        }

                    }
                });



            }
        });


    }
}