package com.example.wanjukim.myapplication.week2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wanjukim.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Wanju Kim on 2017-11-09.
 */

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleHolder> {
    private LayoutInflater inflater;
    private Context context;

    public SampleAdapter(Context context){
        this.context=context;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public SampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SampleHolder(inflater.inflate(R.layout.item_butter_test,parent,false));
    }

    @Override
    public void onBindViewHolder(SampleHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class SampleHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.butter_text)TextView butterText;
        @BindView(R.id.butter_button)Button butterButton;
        @BindView(R.id.butter_check)CheckBox butterCheck;
        private int position;

        public SampleHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void bind(int position){
            butterText.setText(String.valueOf(position));
            butterButton.setText(String.valueOf(position));
            butterCheck.setChecked(position%2==0);
            this.position=position;
        }
        @OnClick(R.id.butter_button)
        public void onClickButton(){
            Toast.makeText(context,String.valueOf(position),Toast.LENGTH_SHORT).show();
        }
    }
}
