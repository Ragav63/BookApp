package com.example.task3;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    private RecyclerView recyclerViewSearch;
    private RecyclerItemSearchAdapter recyclerItemSearchAdapter;
    private List<RecyclerItemSearch> searchList;

    private EditText searchEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private List<RecyclerItemSearch> generateItemList() {
        List<RecyclerItemSearch> itemList = new ArrayList<>();
        itemList.add(new RecyclerItemSearch("How to Contact the Seller of the Book?"));
        itemList.add(new RecyclerItemSearch("How to sell a Book?"));
        itemList.add(new RecyclerItemSearch("How to change the password?"));
        itemList.add(new RecyclerItemSearch("How to become a seller?"));
        itemList.add(new RecyclerItemSearch("How to download a Book?"));
        itemList.add(new RecyclerItemSearch("What is payment for the seller?"));
        itemList.add(new RecyclerItemSearch("Which cities are offline buy availabel?"));


        return itemList;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Initialize RecyclerView
        recyclerViewSearch = view.findViewById(R.id.rec_viewSearch);
        recyclerViewSearch.setLayoutManager(new LinearLayoutManager(getContext()));


        // Initialize EditText for search input
        searchEditText = view.findViewById(R.id.searchEt);

        // Initialize data for RecyclerView
        searchList = generateItemList();

        recyclerItemSearchAdapter = new RecyclerItemSearchAdapter(getContext(), searchList);

        // Set adapter to RecyclerView
        recyclerViewSearch.setAdapter(recyclerItemSearchAdapter);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Inflate the layout for this fragment
        return view;
    }

    // Method to filter data based on search query
    private void filter(String query) {
        List<RecyclerItemSearch> filteredList = new ArrayList<>();
        Log.d("Search Query", "Query: " + query);

        if(query.isEmpty()){
            //if the query in the search edit text is empty means all the data should apper as well
            //Log.d("Empty Query", "Query: " + searchList);
            filteredList.addAll(generateItemList());

//            recyclerViewSearch.setAdapter(new RecyclerItemSearchAdapter(getContext(),generateItemList()));
//            recyclerItemSearchAdapter.notifyDataSetChanged();

        } else {
            for (RecyclerItemSearch item : searchList) {
                if (item.getSearchQuestions().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(item);
                }
            }
        }
        for (RecyclerItemSearch filteredItem : filteredList) {
            Log.d("Filtered List", filteredItem.getSearchQuestions());
        }

        recyclerItemSearchAdapter.filterList(filteredList);

    }
}