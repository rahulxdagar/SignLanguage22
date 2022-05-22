package com.example.signlanguage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class descfragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String name,desc,purl;

    public descfragment2() {
        // Required empty public constructor
    }

    public descfragment2(String name,String desc,String purl) {

        this.name=name;
        this.desc=desc;
        this.purl=purl;
    }


    // TODO: Rename and change types and number of parameters
    public static descfragment2 newInstance(String param1, String param2) {
        descfragment2 fragment = new descfragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_descfragment2, container, false);
        ImageView imageholder = view.findViewById(R.id.imagegholder2);
        TextView nameholder = view.findViewById(R.id.nameholder2);
        TextView descholder = view.findViewById(R.id.descholder2);

        nameholder.setText(name);
        descholder.setText(desc);
        Glide.with(getContext()).load(purl).into(imageholder);

        return view;

    }

    public void onBackPressed(){
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper1,new recfragment2()).addToBackStack(null).commit();

    }
}
