package com.example.signlanguage;

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

public class myadapter2 extends FirebaseRecyclerAdapter<models,myadapter2.myviewholder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public myadapter2(@NonNull FirebaseRecyclerOptions<models> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull models model) {
        holder.nametext.setText(model.getName());
        holder.desctext.setText(model.getDesc());
        Glide.with(holder.img1.getContext()).load(model.getPurl()).into(holder.img1);

        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper1,new descfragment2(model.getName(),model.getDesc(),model.getPurl())).addToBackStack(null).commit();

            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myadapter2.myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView img1;
        TextView nametext,desctext;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.img1);
            nametext=itemView.findViewById(R.id.nametext);
            desctext=itemView.findViewById(R.id.desctext);

        }
    }
}
