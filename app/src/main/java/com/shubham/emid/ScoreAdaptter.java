package com.shubham.emid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ScoreAdaptter extends RecyclerView.Adapter <ScoreAdaptter.ScoreViewAdapte>{

   List<Scoredata> list;
   Context context;
   int i=1;


    public ScoreAdaptter(List<Scoredata> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ScoreViewAdapte onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.score_list_items,parent,false);
        return new ScoreViewAdapte(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewAdapte holder, int position) {
      Scoredata currentitems = list.get(position);
      holder.name.setText(currentitems.getName());
      holder.score.setText(Math.toIntExact(currentitems.getScore()));
      holder.rank.setText(String.valueOf(i));
        Glide.with(context).load(currentitems.getImage()).into(holder.imageView);
        i++;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ScoreViewAdapte extends RecyclerView.ViewHolder {
       ImageView imageView;
       TextView name,score,rank;

        public ScoreViewAdapte(@NonNull View itemView) {
            super(itemView);
            imageView =  itemView.findViewById(R.id.user_imag);
            name = itemView.findViewById(R.id.score_user_name);
            score =  itemView.findViewById(R.id.score_user_result);
            rank = itemView.findViewById(R.id.score_user_rank);
        }
    }

}
