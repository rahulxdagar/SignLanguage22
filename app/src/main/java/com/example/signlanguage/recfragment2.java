package com.example.signlanguage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class recfragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recview2;
    myadapter2 adapter2;

    public recfragment2() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static recfragment2 newInstance(String param1, String param2) {
        recfragment2 fragment = new recfragment2();
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
        View view=inflater.inflate(R.layout.fragment_recfragment2, container, false);

        recview2=(RecyclerView)view.findViewById(R.id.recview2);
        recview2.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<models> options2 =
                new FirebaseRecyclerOptions.Builder<models>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("phrases"), models.class)
                        .build();
        adapter2 = new myadapter2(options2);
        recview2.setAdapter(adapter2);
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        adapter2.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter2.stopListening();
    }


}
