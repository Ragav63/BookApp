package com.example.task3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerItemRankAdapter extends RecyclerView.Adapter<RecyclerItemRankAdapter.ItemViewHolder>{

    private static Context context;
    private List<RecyclerItemRank> itemList;

    public RecyclerItemRankAdapter(Context context, List<RecyclerItemRank> itemList) {
        this.context = context;
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rank_recycler_items, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        RecyclerItemRank item = itemList.get(position);

        // Set data to views
        holder.rankNo.setText(item.getItemrankno());
        holder.imageView.setImageResource(item.getImageResource());
        holder.titleTextView.setText(item.getName());
        holder.descriptionTextView.setText(item.getMail());
        holder.pointTv.setText(item.getPoint());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView rankNo;
        ImageView imageView;
        TextView titleTextView;
        TextView descriptionTextView;
        TextView pointTv;

        Button rankVPBtn;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            rankNo=itemView.findViewById(R.id.item_rankno);
            imageView = itemView.findViewById(R.id.item_image);
            titleTextView = itemView.findViewById(R.id.item_title);
            descriptionTextView = itemView.findViewById(R.id.item_description);
            pointTv = itemView.findViewById(R.id.item_points);

            rankVPBtn=itemView.findViewById(R.id.rankVPBtn);

            rankVPBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog(context, rankNo,titleTextView,descriptionTextView,pointTv);
                }
            });

        }
    }

    private static void showDialog(Context context, TextView rankNo, TextView titleTextView, TextView descriptionTextView, TextView pointTv){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        String title=titleTextView.getText().toString();
        builder.setTitle(title);

        String rankno=rankNo.getText().toString();
        String description=descriptionTextView.getText().toString();
        String points=pointTv.getText().toString();

        builder.setMessage("Rank No: " + rankno + "\nDescription: " + description + "\nPoints: " + points);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
