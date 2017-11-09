package com.example.wanjukim.myapplication.week2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wanjukim.myapplication.R;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.RecyclerViewSwipeManager;

/**
 * Created by Wanju Kim on 2017-11-09.
 */

public class SwipeViewAcitivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.swipe_example);

        RecyclerView recyclerView = findViewById(R.id.swipe_recycler_view);

        RecyclerViewSwipeManager swipeManager = new RecyclerViewSwipeManager(); // provides item swipe operation for recyclerview

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(swipeManager.createWrappedAdapter(new SwipeViewAdapter())); // wrap한번 더

        swipeManager.attachRecyclerView(recyclerView);
    }
}
