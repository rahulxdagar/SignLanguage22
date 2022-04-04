package com.example.signlanguage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;


public class LoginTabFragment extends Fragment {

    EditText emails,pass;
    AppCompatButton login;
    TextView forgetpass;
    float v=0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);

        emails=root.findViewById(R.id.email_login);
        pass=root.findViewById(R.id.pass_login);
        forgetpass=root.findViewById(R.id.forgetpass_login);
        login=root.findViewById(R.id.button_login);


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



        return root;
    }


}
