package com.example.signlanguage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;


public class SignupTabFragment extends Fragment{
    private FirebaseAuth mAuth;
    private EditText email,mobile,password,confirm_pass;
    private AppCompatButton signUp;
    private ProgressBar progressBar;
    Users users;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.signup_tab_fragment,container,false);

        mAuth = FirebaseAuth.getInstance();

        email=root.findViewById(R.id.email_signup);
        mobile=root.findViewById((R.id.phonno_signup));
        password=root.findViewById(R.id.pass_signup);
        confirm_pass=root.findViewById((R.id.confirm_pass_signup));
        progressBar=root.findViewById(R.id.progress_bar_signup);
        signUp=root.findViewById(R.id.button_signup);
        users = new Users();

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("Users");

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                 String r_email=email.getText().toString().trim();
                 String r_mobile=mobile.getText().toString().trim();
                 String r_password=password.getText().toString().trim();
                 String r_confirm_pass=confirm_pass.getText().toString().trim();



                /*Users users=new Users(r_email,r_mobile,r_password);

                FirebaseDatabase.getInstance().getReference("Users").child(r_email).push().setValue(users);*/



                if(r_email.isEmpty()){
                    email.setError("Email is required !");
                    email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(r_email).matches()){
                    email.setError("Please provide a valid email !");
                    email.requestFocus();
                    return;
                }
                if(r_mobile.isEmpty()){
                    mobile.setError("Mobile number is required !");
                    mobile.requestFocus();
                    return;
                }

                if(!Pattern.matches("^[0-9]{10}$", r_mobile)){
                    mobile.setError("Provide a 10 digit phone number !");
                    mobile.requestFocus();
                    return;
                }
                if(r_password.isEmpty()){
                    password.setError("Password is required !");
                    password.requestFocus();
                    return;
                }

                if(r_password.length()<6){
                    password.setError("Password must be atleast 6 characters long!");
                    password.requestFocus();
                    return;
                }

                if(r_confirm_pass.isEmpty()){
                    confirm_pass.setError("Confirm password is required !");
                    confirm_pass.requestFocus();
                    return;
                }

                if(!r_password.equalsIgnoreCase(r_confirm_pass)){
                    confirm_pass.setError("Confirm password must be same as password");
                    confirm_pass.requestFocus();
                    return;
                }

                progressBar.setVisibility(view.VISIBLE);
                mAuth.createUserWithEmailAndPassword(r_email,r_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Log.v("check","Error: Cannot come under this block ");




                            progressBar.setVisibility(view.GONE);

                             addDatatoFirebase(r_email,r_mobile,r_password);


                           /* Users users=new Users(r_email,r_mobile,r_password);

                            FirebaseDatabase.getInstance().getReference("Users").child(r_email).push().setValue(users);*/
                                   /* .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {


                                            if(task.isSuccessful()){

                                                Toast.makeText(getContext(), "User registeration successfull", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(view.GONE);


                                            }
                                            else{
                                                Toast.makeText(getContext(), "Failed to register user. Try Again Later!", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(view.GONE);


                                            }

                                }
                            });*/
                        }
                        /*else{
//                            Toast.makeText(getContext(), "Failed to register user. Try Again Later!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(view.GONE);


                        }*/
                    }
                });


            }
        });



        return root;


    }

    private void addDatatoFirebase(String r_email,String r_mobile,String r_password){
        users.setEmail(r_email);
        users.setMobile(r_mobile);
        users.setPassword(r_password);

        databaseReference.push().setValue(users)
                 .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {


                                            if(task.isSuccessful()){


                                                Toast.makeText(getContext(), "User registeration successfull", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(getView().GONE);


                                            }
                                            else{
                                                Toast.makeText(getContext(), "Failed to register user. Try Again Later!", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(getView().GONE);


                                            }

                                }
                            });


    }




}
