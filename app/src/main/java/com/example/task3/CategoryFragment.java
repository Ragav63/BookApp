package com.example.task3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
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

public class CategoryFragment extends Fragment implements RecyclerItemHomeAdapter.OnItemClickListener{
    private RecyclerView recyclerViewCategory;
    private RecyclerItemHomeAdapter adapter;

    //ArrayList<RecyclerItemHome> modelClassArrayList;
    private List<RecyclerItemHome> itemList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize item list and adapter

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);

        recyclerViewCategory= view.findViewById(R.id.recyclerViewCategory);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize data for RecyclerView
        itemList = generateItemList();

        adapter = new RecyclerItemHomeAdapter(getContext(), itemList);

        // Set adapter to RecyclerView
        recyclerViewCategory.setAdapter(adapter);


        // Inflate the layout for this fragment
        return view;

    }

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

    @Override
    public void onItemClick(RecyclerItemHome item) {

    }
}