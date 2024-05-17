package com.example.task3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements RecyclerItemHomeAdapter.OnItemClickListener{

    private RecyclerView recItemCardHome;
    private List<RecyclerItemCardHome> cardHomeList;
    private LinearLayoutManager cardLinearLayoutManager;
    private  RecyclerItemCardHomeAdapter recyclerItemCardHomeAdapter;
    private RecyclerView rec_viewCategoryHf;
    private RecyclerItemHomeAdapter itemAdapter;
    private List<RecyclerItemHome> itemList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private List<RecyclerItemCardHome> generateCardItemList() {
        List<RecyclerItemCardHome> itemCardHomeList = new ArrayList<>();
        itemCardHomeList.add(new RecyclerItemCardHome("Maths"));
        itemCardHomeList.add(new RecyclerItemCardHome("Physics"));
        itemCardHomeList.add(new RecyclerItemCardHome("Chemistry"));
        itemCardHomeList.add(new RecyclerItemCardHome("Botany"));
        itemCardHomeList.add(new RecyclerItemCardHome("Zoology"));
        itemCardHomeList.add(new RecyclerItemCardHome("Commerce"));
        itemCardHomeList.add(new RecyclerItemCardHome("Computer"));
        itemCardHomeList.add(new RecyclerItemCardHome("English"));
        itemCardHomeList.add(new RecyclerItemCardHome("Tamil"));

        return  itemCardHomeList;
    }

    // Method to generate sample item list (you can replace it with your own data source)
    private List<RecyclerItemHome> generateItemList() {
        List<RecyclerItemHome> itemList = new ArrayList<>();
        itemList.add(new RecyclerItemHome(R.drawable.book, "Maths", "Maths(1-12)", "Item Price: Rs10.00", 4.5f));
        itemList.add(new RecyclerItemHome(R.drawable.book, "Physics", "Physics(1-12)", "Item Price: Rs10.00", 4.5f));
        itemList.add(new RecyclerItemHome(R.drawable.book, "Chemistry", "Chemistry(1-12)", "Item Price: Rs10.00", 4.5f));
        itemList.add(new RecyclerItemHome(R.drawable.book, "Botany", "Botany(1-12)", "Item Price: Rs10.00", 4.5f));
        itemList.add(new RecyclerItemHome(R.drawable.book, "Zoology", "Zoology(1-12)", "Item Price: Rs10.00", 4.5f));
        itemList.add(new RecyclerItemHome(R.drawable.book, "Commerce", "Commerce(1-12)", "Item Price: Rs10.00", 4.5f));
        itemList.add(new RecyclerItemHome(R.drawable.book, "Computer", "Computer(1-12)", "Item Price: Rs10.00", 4.5f));
        itemList.add(new RecyclerItemHome(R.drawable.book, "English", "English(1-12)", "Item Price: Rs10.00", 4.5f));
        itemList.add(new RecyclerItemHome(R.drawable.book, "Tamil", "Tamil(1-12)", "Item Price: Rs10.00", 4.5f));

        return itemList;
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recItemCardHome=view.findViewById(R.id.rec_cardViewHsv);

        cardHomeList=generateCardItemList();

        cardLinearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        recyclerItemCardHomeAdapter=new RecyclerItemCardHomeAdapter(getContext(),cardHomeList);

        recItemCardHome.setLayoutManager(cardLinearLayoutManager);

        recItemCardHome.setAdapter(recyclerItemCardHomeAdapter);

        // Initialize RecyclerView for Category in Home and Category Fragment
        rec_viewCategoryHf = view.findViewById(R.id.rec_viewCategoryHf);
        rec_viewCategoryHf.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize data for RecyclerView
        itemList = generateItemList();

        itemAdapter = new RecyclerItemHomeAdapter(getContext(), itemList);

        // Set adapter to RecyclerView
        rec_viewCategoryHf.setAdapter(itemAdapter);


        return view;
    }
    @Override
    public void onItemClick(RecyclerItemHome item) {
        // Handle item click here
        String title = "Item Title: " + item.getTitle();
        String description = "Item Description: " + item.getDescription();
        String price = "Item Price: " + item.getPrice();

        Log.d("HomeFragment", "Item clicked: " + item.getTitle());

        Toast.makeText(getContext(), title +description +price, Toast.LENGTH_SHORT).show();
    }


}