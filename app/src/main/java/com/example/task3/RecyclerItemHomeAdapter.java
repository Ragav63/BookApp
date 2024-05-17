package com.example.task3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
public class RecyclerItemHomeAdapter extends RecyclerView.Adapter<RecyclerItemHomeAdapter.ItemViewHolder>{

    private Context context;
    private List<RecyclerItemHome> itemList;


    public interface OnItemClickListener {
        void onItemClick(RecyclerItemHome item);
    }


    public RecyclerItemHomeAdapter(Context context, List<RecyclerItemHome> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_items, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        RecyclerItemHome item = itemList.get(position);
//
        holder.bind(item);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(context, item.getTitle(), item.getDescription(), item.getPrice(), item.getRating());
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView descriptionTextView;
        TextView priceTextView;
        RatingBar ratingBar;

        AppCompatButton view;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            titleTextView = itemView.findViewById(R.id.item_title);
            descriptionTextView = itemView.findViewById(R.id.item_description);
            priceTextView = itemView.findViewById(R.id.item_price);
            ratingBar = itemView.findViewById(R.id.item_rating);
            view=itemView.findViewById(R.id.rchomeViewBtn);


        }


        public void bind(RecyclerItemHome item) {
            imageView.setImageResource(item.getImageResource());
            titleTextView.setText(item.getTitle());
            descriptionTextView.setText(item.getDescription());
            priceTextView.setText(item.getPrice());

            float rating = item.getRating() / 10.0f; // Divide by 10 to get the float value

            ratingBar.setRating(rating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }


    }

    public void showDialog(Context context, String title, String description, String price, float rating) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage("Description: " + description + "\nPrice: " + price + "\nRating: " + rating);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
