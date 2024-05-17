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

public class RecyclerItemCertificateAdapter extends RecyclerView.Adapter<RecyclerItemCertificateAdapter.ItemViewHolder>{

    private static Context context;
    private List<RecyclerItemCertificate> itemList;

    public RecyclerItemCertificateAdapter(Context context, List<RecyclerItemCertificate> itemList) {
        this.context = context;
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.certificate_rec_items, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        RecyclerItemCertificate item = itemList.get(position);

        // Set data to views
        holder.certificateTitle.setText(item.getItemCertificateTitle());
        holder.personImg.setImageResource(item.getImageResource());
        holder.descriptionTv.setText(item.getItemDescription());
        holder.pointTv.setText(item.getPoint());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView certificateTitle;
        ImageView personImg;
        TextView descriptionTv;
        TextView pointTv;

        Button certificateVBtn;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            certificateTitle=itemView.findViewById(R.id.item_title);
            personImg = itemView.findViewById(R.id.item_image);
            descriptionTv = itemView.findViewById(R.id.item_description);
            pointTv = itemView.findViewById(R.id.item_points);

            certificateVBtn=itemView.findViewById(R.id.certificateViewBtn);
            certificateVBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog(context,certificateTitle,descriptionTv,pointTv);
                }
            });

        }
    }

    private static void showDialog(Context context, TextView titleTv, TextView descriptionTv, TextView pointTv){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        String title=titleTv.getText().toString();
        builder.setTitle(title);

        String description=descriptionTv.getText().toString();
        String points=pointTv.getText().toString();

        builder.setMessage("Description: " + description + "\nPoints: " + points);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
