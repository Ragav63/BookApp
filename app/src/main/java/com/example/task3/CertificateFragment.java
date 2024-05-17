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


public class CertificateFragment extends Fragment {

    private RecyclerView recyclerViewCertificate;
    private RecyclerItemCertificateAdapter recyclerItemCertificateAdapter;
    private List<RecyclerItemCertificate> certificateList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private List<RecyclerItemCertificate> generateItemList() {
        List<RecyclerItemCertificate> itemList = new ArrayList<>();
        itemList.add(new RecyclerItemCertificate("1","Introduction to Science",R.drawable.certificatecards, "From IIT Khargpur","1003 P"));
        itemList.add(new RecyclerItemCertificate("2","Introduction to Maths",R.drawable.certificatecards, "From IIT Khargpur","1003 P"));
        itemList.add(new RecyclerItemCertificate("3","Introduction to Physics",R.drawable.certificatecards, "From IIT Khargpur","1003 P"));
        itemList.add(new RecyclerItemCertificate("4","Introduction to Chemistry",R.drawable.certificatecards, "From IIT Khargpur","1003 P"));

        return itemList;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_certificate, container, false);

        // Initialize RecyclerView
        recyclerViewCertificate = view.findViewById(R.id.recyclerViewCertificate);
        recyclerViewCertificate.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize data for RecyclerView
        certificateList = generateItemList();

        recyclerItemCertificateAdapter = new RecyclerItemCertificateAdapter(getContext(), certificateList);

        // Set adapter to RecyclerView
        recyclerViewCertificate.setAdapter(recyclerItemCertificateAdapter);
        // Inflate the layout for this fragment
        return view;

    }


}