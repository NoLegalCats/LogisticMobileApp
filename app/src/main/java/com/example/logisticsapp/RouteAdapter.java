package com.example.logisticsapp;

import static com.yandex.runtime.Runtime.getApplicationContext;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder> {
    private List<RouteItem> routeList;

    public RouteAdapter(List<RouteItem> routeList) {
        this.routeList = routeList;
    }

    @NonNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_routes, parent, false);
        return new RouteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteViewHolder holder, int position) {
        RouteItem currentItem = routeList.get(position);

        holder.startLocTextView.setText(currentItem.getStartLocText());
        holder.endLocTextView.setText(currentItem.getEndLocText());
        holder.endLocDescTextView.setText(currentItem.getEndLocDescText());
        holder.massTextView.setText(currentItem.getMassText());
        holder.loadTextView.setText(currentItem.getLoadText());
        holder.distantTextView.setText(currentItem.getDistantText());
        holder.costTextView.setText(currentItem.getCostText());
        holder.descrTextView.setText(currentItem.getDescrText());
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.userNameTextView.setText(currentItem.getUserNameText());
        holder.userLocTextView.setText(currentItem.getUserLocText());
        holder.userRegTextView.setText(currentItem.getUserRegText());
    }

    @Override
    public int getItemCount() {
        return routeList.size();
    }

    public static class RouteViewHolder extends RecyclerView.ViewHolder {
        public TextView startLocTextView;
        public TextView endLocTextView;
        public TextView endLocDescTextView;
        public TextView massTextView;
        public TextView loadTextView;
        public TextView distantTextView;
        public TextView costTextView;
        public TextView descrTextView;
        public ImageView imageView;
        public TextView userNameTextView;
        public TextView userLocTextView;
        public TextView userRegTextView;
        public ConstraintLayout constraintLayout;
        public ConstraintLayout subConstraintLayout;

        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);
            startLocTextView = itemView.findViewById(R.id.route_startLocText);
            endLocTextView = itemView.findViewById(R.id.route_endLocText);
            endLocDescTextView = itemView.findViewById(R.id.route_endLocDescText);
            massTextView = itemView.findViewById(R.id.route_massText);
            loadTextView = itemView.findViewById(R.id.route_loadText);
            distantTextView = itemView.findViewById(R.id.route_distantText);
            costTextView = itemView.findViewById(R.id.route_costText);
            descrTextView = itemView.findViewById(R.id.route_descrText);
            imageView = itemView.findViewById(R.id.route_imageUser);
            userNameTextView = itemView.findViewById(R.id.route_userNameText);
            userLocTextView = itemView.findViewById(R.id.route_userLocText);
            userRegTextView = itemView.findViewById(R.id.route_userRegText);

            constraintLayout = itemView.findViewById(R.id.route_ConstraintLayout);
            subConstraintLayout = itemView.findViewById(R.id.route_SubConstraintLayout);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) subConstraintLayout.getLayoutParams();
                    if (params.height == ConstraintLayout.LayoutParams.WRAP_CONTENT) {
                        Context context = getApplicationContext();
                        float scale = context.getResources().getDisplayMetrics().density;
                        int heightInPixels = (int) (24 * scale + 0.5f);
                        params.height = heightInPixels;
                    } else {
                        params.height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
                    }
                    subConstraintLayout.setLayoutParams(params);
                }
            });
        }
    }
}

