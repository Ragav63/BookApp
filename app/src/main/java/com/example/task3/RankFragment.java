package com.example.task3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RankFragment extends Fragment {

    private RecyclerView recyclerViewRank;
    private RecyclerItemRankAdapter recyclerItemRankAdapter;
    private List<RecyclerItemRank> rankList;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // Method to generate sample item list (you can replace it with your own data source)
    private List<RecyclerItemRank> generateItemList() {
        List<RecyclerItemRank> itemList = new ArrayList<>();
        itemList.add(new RecyclerItemRank("1",R.drawable.man, "Ragav", "ragav@gmail.com", "1003 P"));
        itemList.add(new RecyclerItemRank("2",R.drawable.woman, "Sakthi", "sakthi@gmail.com", "1003 P"));
        itemList.add(new RecyclerItemRank("3",R.drawable.man, "John", "sakthi@gmail.com", "1003 P"));
        itemList.add(new RecyclerItemRank("4",R.drawable.man, "Rohan", "sakthi@gmail.com", "1003 P"));
        itemList.add(new RecyclerItemRank("5",R.drawable.woman, "Priya", "sakthi@gmail.com", "1003 P"));

        return itemList;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rank, container, false);

        // Initialize RecyclerView
        recyclerViewRank = view.findViewById(R.id.recyclerViewRank);
        recyclerViewRank.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize data for RecyclerView
        rankList = generateItemList();

        recyclerItemRankAdapter = new RecyclerItemRankAdapter(getContext(), rankList);

        // Set adapter to RecyclerView
        recyclerViewRank.setAdapter(recyclerItemRankAdapter);
        // Inflate the layout for this fragment
        return view;

    }


}