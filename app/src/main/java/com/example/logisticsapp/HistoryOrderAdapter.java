package com.example.logisticsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryOrderAdapter extends RecyclerView.Adapter<HistoryOrderAdapter.HistoryOrderViewHolder> {
    private List<HistoryOrderItem> historyOrderList;
    private Context context;

    public HistoryOrderAdapter(Context context, List<HistoryOrderItem> historyOrderList) {
        this.context = context;
        this.historyOrderList = historyOrderList;
    }

    @NonNull
    @Override
    public HistoryOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_history_orders, parent, false);
        return new HistoryOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryOrderViewHolder holder, int position) {
        HistoryOrderItem currentItem = historyOrderList.get(position);

        holder.startPointText.setText(currentItem.getStartPoint());
        holder.endPointText.setText(currentItem.getEndPoint());
        holder.dateText.setText(currentItem.getDate());
        holder.costText.setText(currentItem.getCost());
        holder.ratingBar.setRating(currentItem.getRating());
    }

    @Override
    public int getItemCount() {
        return historyOrderList.size();
    }

    public class HistoryOrderViewHolder extends RecyclerView.ViewHolder {
        public TextView startPointText;
        public TextView endPointText;
        public TextView dateText;
        public TextView costText;
        public RatingBar ratingBar;

        public HistoryOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            startPointText = itemView.findViewById(R.id.historyOrders_startPointText);
            endPointText = itemView.findViewById(R.id.historyOrders_endPointText);
            dateText = itemView.findViewById(R.id.historyOrders_dateText);
            costText = itemView.findViewById(R.id.historyOrders_cost);
            ratingBar = itemView.findViewById(R.id.historyOrders_ratingBar);
        }
    }
}
