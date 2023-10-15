package com.example.logisticsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private List<ReviewItem> reviewList;

    public ReviewAdapter(List<ReviewItem> reviewList) {
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_review, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        ReviewItem currentItem = reviewList.get(position);

        holder.userNameTextView.setText(currentItem.getUserName());
        holder.userDescriptionTextView.setText(currentItem.getUserDescription());
        holder.ratingBar.setRating(currentItem.getRating());
        holder.userImageView.setImageResource(currentItem.getUserImageResId());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public static class ReviewViewHolder extends RecyclerView.ViewHolder {
        public ImageView userImageView;
        public TextView userNameTextView;
        public TextView userDescriptionTextView;
        public RatingBar ratingBar;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            userImageView = itemView.findViewById(R.id.review_imageUser);
            userNameTextView = itemView.findViewById(R.id.review_userNameText);
            userDescriptionTextView = itemView.findViewById(R.id.review_userDescText);
            ratingBar = itemView.findViewById(R.id.review_ratingBar);
        }
    }
}
