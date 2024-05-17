package com.example.task3;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerItemSearchAdapter extends RecyclerView.Adapter<RecyclerItemSearchAdapter.ItemViewHolder>{

    private Context context;
    private List<RecyclerItemSearch> itemList;

    private List<RecyclerItemSearch> filteredList; // Add filteredList field

    public RecyclerItemSearchAdapter(Context context, List<RecyclerItemSearch> itemList) {
        this.context = context;
        this.itemList = itemList;

    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_rec_items, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        RecyclerItemSearch item = itemList.get(position);

        // Set data to views
        holder.searchQuestions.setText(item.getSearchQuestions());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // Method to update adapter's dataset with filtered list
    @SuppressLint("NotifyDataSetChanged")
    public void filterList(List<RecyclerItemSearch> filteredList) {
        itemList.clear();
        itemList.addAll(filteredList);

        notifyDataSetChanged(); // Notify RecyclerView of dataset changes
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView searchQuestions;

        Button searchViewBtn;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            searchQuestions=itemView.findViewById(R.id.searchIQuestion);

            searchViewBtn=itemView.findViewById(R.id.searchviewBtn);

            //used custom dialog box for the link purpose
            searchViewBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //showDialog(context, searchQuestions);
                    // Create and show the custom dialog
                    CustomDialog dialog = new CustomDialog(itemView.getContext());
                    dialog.setTitle(searchQuestions.getText().toString());
                    dialog.setMessage("Please visit the below link to know more about your Query.");
                    dialog.setLinkText("Click here for more info -->");
                    dialog.setLinkClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String url = "https://en.wikipedia.org/wiki/The_Help";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            itemView.getContext().startActivity(intent);

                        }
                    });
                    dialog.show();
                }
            });

        }
    }

}
