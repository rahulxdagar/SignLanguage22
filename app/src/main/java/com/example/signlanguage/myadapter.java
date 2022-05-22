package com.example.signlanguage;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class myadapter extends FirebaseRecyclerAdapter<models,myadapter.myviewholder> {

    public myadapter(@NonNull FirebaseRecyclerOptions<models> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull models model) {


        holder.nametext1.setText(model.getName());
        holder.desctext1.setText(model.getDesc());
        Glide.with(holder.img1.getContext()).load(model.getPurl()).into(holder.img1);


        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new descfragment(model.getName(),model.getDesc(),model.getPurl())).addToBackStack(null).commit();

            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView img1;
        TextView nametext1,desctext1;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.img1);
            nametext1=(TextView) itemView.findViewById(R.id.nametext);
            desctext1=(TextView) itemView.findViewById(R.id.desctext);

        }
    }

}
