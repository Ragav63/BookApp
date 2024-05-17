package com.example.task3;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerItemCardHomeAdapter extends RecyclerView.Adapter<RecyclerItemCardHomeAdapter.ItemViewHolder>{

    private Context context;
    private List<RecyclerItemCardHome> cardItemList;

    public RecyclerItemCardHomeAdapter(Context context, List<RecyclerItemCardHome> cardItemList) {
        this.context = context;
        this.cardItemList = cardItemList;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        RecyclerItemCardHome recyclerItemCardHome=cardItemList.get(position);

        // Set data to views
        holder.titleTextView.setText(recyclerItemCardHome.getSubjectCardTitle());

    }

    @Override
    public int getItemCount() {
        return cardItemList.size();

    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.homecardTv);

        }
    }
}
