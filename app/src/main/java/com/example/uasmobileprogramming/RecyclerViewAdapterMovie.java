package com.example.uasmobileprogramming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterMovie extends RecyclerView.Adapter<RecyclerViewAdapterMovie.MyViewHolder>{
    Context context;
    List<Result> movieList;
    RecyclerViewInterface recyclerViewInterface;

    public RecyclerViewAdapterMovie(Context context, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public void setDataset(List<Result> movieList){
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterMovie.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_movie, parent, false);

        return new RecyclerViewAdapterMovie.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterMovie.MyViewHolder holder, int position) {
        holder.textView_title.setText(movieList.get(position).getOriginalTitle());

        Picasso.get().load("https://image.tmdb.org/t/p/w185" + movieList.get(position).getPosterPath()).into(holder.imageView_poster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView_poster;
        TextView textView_title;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView_poster = itemView.findViewById(R.id.imageView_poster);
            textView_title = itemView.findViewById(R.id.textView_title);
            cardView = itemView.findViewById(R.id.cardView_rowMovie);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}