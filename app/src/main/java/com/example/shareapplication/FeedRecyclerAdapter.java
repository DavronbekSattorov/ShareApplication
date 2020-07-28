package com.example.shareapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder> {

    private ArrayList<String> userEmaiList;
    private ArrayList<String> userCommentList;
    private ArrayList<String> userImageList;

    public FeedRecyclerAdapter(ArrayList<String> userEmaiList, ArrayList<String> userCommentList, ArrayList<String> userImageList) {
        this.userEmaiList = userEmaiList;
        this.userCommentList = userCommentList;
        this.userImageList = userImageList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row,parent,false);

        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        holder.userEmailText.setText(userEmaiList.get(position));
        holder.userCommentText.setText(userCommentList.get(position));
        Picasso.get().load(userImageList.get(position)).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return userEmaiList.size();
    }

    class PostHolder extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView userEmailText;
        TextView userCommentText;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.recycler_row_imageview);
            userEmailText = itemView.findViewById(R.id.recycler_row_useremail_text);
            userCommentText = itemView.findViewById(R.id.recycler_row_usercomment_text);
        }
    }
}

