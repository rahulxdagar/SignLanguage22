package com.example.signlanguage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginTabFragment extends Fragment {

    private EditText emails,pass;
    private AppCompatButton login;
    private TextView forgetpass;
    private ProgressBar progressBar1;
    private FirebaseAuth mAuths;
    float v=0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);

        emails=root.findViewById(R.id.email_login);
        pass=root.findViewById(R.id.pass_login);
        forgetpass=root.findViewById(R.id.forgetpass_login);
        login=root.findViewById(R.id.button_login);
        progressBar1=root.findViewById(R.id.progress_bar_login);
        mAuths = FirebaseAuth.getInstance();


        emails.setTranslationX(800);
        pass.setTranslationX(800);
        forgetpass.setTranslationX(800);
        login.setTranslationX(800);

        emails.setAlpha(v);
        pass.setAlpha(v);
        forgetpass.setAlpha(v);
        login.setAlpha(v);

        emails.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        forgetpass.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(700).start();

        Log.v("check","Error: Before login ");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String l_email=emails.getText().toString().trim();
                String l_pass=pass.getText().toString().trim();


                if(l_email.isEmpty()){
                    emails.setError("Email is required !");
                    emails.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(l_email).matches()){
                    emails.setError("Please provide a valid email !");
                    emails.requestFocus();
                    return;
                }
                if(l_pass.isEmpty()){
                    pass.setError("Password is required !");
                    pass.requestFocus();
                    return;
                }

                if(l_pass.length()<6){
                    pass.setError("Password must be atleast 6 characters long!");
                    pass.requestFocus();
                    return;
                }
                Log.v("check","Error: After Login ");

                progressBar1.setVisibility(view.VISIBLE);

                mAuths.signInWithEmailAndPassword(l_email,l_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.v("check","Error: After Login ");

                            progressBar1.setVisibility(view.GONE);
                            Toast.makeText(getContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getActivity(),ChooseActivity.class));


                        }
                        else{
                            progressBar1.setVisibility(view.GONE);
                            Toast.makeText(getContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),ForgetPassword.class));
            }
        });

        return root;
    }


}
