package com.example.logisticsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<ChatItem> chatList;

    public ChatAdapter(List<ChatItem> chatList) {
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_chat, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        ChatItem currentItem = chatList.get(position);

        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.nameUserTextView.setText(currentItem.getNameUser());
        holder.timeTextView.setText(currentItem.getTime());
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nameUserTextView;
        public TextView textChatInfoTextView;
        public TextView timeTextView;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.chat_image);
            nameUserTextView = itemView.findViewById(R.id.chat_nameUserText);
            textChatInfoTextView = itemView.findViewById(R.id.chat_textChatInfo);
            timeTextView = itemView.findViewById(R.id.chat_timeText);

            ConstraintLayout chatHist_idOpen = itemView.findViewById(R.id.chatHist_idOpen);
            chatHist_idOpen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    Intent intent = new Intent(context, ChatIdActivity.class);
                    context.startActivity(intent);
                    if (context instanceof Activity) {
                        ((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                    }
                }
            });
        }
    }
}
