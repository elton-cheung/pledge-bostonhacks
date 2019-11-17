package com.example.pledgeapplication.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pledgeapplication.PledgeItem;
import com.example.pledgeapplication.PledgeItemAdapter;
import com.example.pledgeapplication.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeFragment extends Fragment {


    private PledgeItemAdapter mAdapter;
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // get a reference to recyclerView
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerview);
        //RecyclerView recyclerView = new RecyclerView(getContext());
        // set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        // create an adapter
        ArrayList<PledgeItem> allPledges = initPledgeArray();
        mAdapter = new PledgeItemAdapter(getContext(), allPledges);

        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

//
        // set item animator to default animator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    // initializes the data - pledge arrays
    public ArrayList<PledgeItem> initPledgeArray() {
        ArrayList<PledgeItem> allPledges = new ArrayList<PledgeItem>();
        PledgeItem p1 = new PledgeItem("1", "Food", "I will not eat take out for a week", "11/12/13",
                "12/12/19", "donate $10 to charity");
        PledgeItem p2 = new PledgeItem("2", "Recycle", "I will not eat take out for a week", "11/12/13",
                "12/12/19", "donate too much to charity");
        allPledges.add(p1);
        allPledges.add(p2);
        return allPledges;
    }

}