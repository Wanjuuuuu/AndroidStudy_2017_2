package com.example.wanjukim.myapplication.week2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wanjukim.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Wanju Kim on 2017-11-09.
 */

public class ButterKnifeActivity extends AppCompatActivity {
    @BindView(R.id.sample_button)Button sampleButton;
    @BindView(R.id.sample_image)ImageView sampleImage;
    @BindView(R.id.sample_recyclerview)RecyclerView sampleRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);

        ButterKnife.bind(this);

        sampleButton.setText("Hell...o wo..rld");

        SampleAdapter adapter=new SampleAdapter(this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);

        sampleRecyclerView.setLayoutManager(layoutManager);
        sampleRecyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.sample_image)
    public void onClickImage(){
        Toast.makeText(this,"hi",Toast.LENGTH_SHORT).show();
    }
}
