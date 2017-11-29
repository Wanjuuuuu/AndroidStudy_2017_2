package com.example.wanjukim.myapplication.week4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Wanju Kim on 2017-11-29.
 */

public class ResultActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(),"ResultActivity1",Toast.LENGTH_LONG).show();
    }
}
