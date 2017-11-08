package com.example.wanjukim.myapplication.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wanjukim.myapplication.R;

/**
 * Created by Wanju Kim on 2017-11-07.
 */

public class ScrollActivity extends AppCompatActivity {
    private RecyclerView stuffStringView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_scrollview);
        setContentView(R.layout.horizontal_scrollview);

        stuffStringView = (RecyclerView) findViewById(R.id.stuff_string_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        stuffStringView.setLayoutManager(linearLayoutManager);
        stuffStringView.setAdapter(new StuffStringAdapter(this));
    }
}
