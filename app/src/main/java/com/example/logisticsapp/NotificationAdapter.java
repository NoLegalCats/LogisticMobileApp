package com.example.logisticsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private List<NotificationItem> notificationList;

    public NotificationAdapter(List<NotificationItem> notificationList) {
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_notification, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        NotificationItem currentItem = notificationList.get(position);

        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.titleTextView.setText(currentItem.getTitle());
        holder.timeTextView.setText(currentItem.getTime());
        holder.descriptionTextView.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleTextView;
        public TextView timeTextView;
        public TextView descriptionTextView;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.notific_Image);
            titleTextView = itemView.findViewById(R.id.notific_TitleText);
            timeTextView = itemView.findViewById(R.id.notific_TimeText);
            descriptionTextView = itemView.findViewById(R.id.notific_DescrText);
        }
    }
}
