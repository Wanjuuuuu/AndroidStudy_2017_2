package com.example.wanjukim.myapplication.practice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wanjukim.myapplication.R;


/**
 * Created by Wanju Kim on 2017-11-07.
 */

public class StuffStringAdapter extends RecyclerView.Adapter<StuffStringAdapter.StuffStringHolder>{
    private Context mContext;
    private LayoutInflater mInflater;

    private String[] itemList={"Android","Study","is","very","interesting"};

    private final int SECTION_FIRST=0;

    private final int ITEM_HEADER = 0;
    private final int ITEM_FOOTER = 0;
    private final int ITEM_BODY_FIRST = 2;

    public StuffStringAdapter(Context context){
        mContext=context;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public StuffStringHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StuffStringHolder(mInflater.inflate(R.layout.stuff_viewholder,parent,false));
    }

    @Override
    public void onBindViewHolder(StuffStringHolder holder, int position) {
        holder.bind(itemList[position]);
    }

    @Override
    public int getItemCount() {
        return itemList.length;
    }

    class StuffStringHolder extends RecyclerView.ViewHolder{
        TextView titleView;
        LinearLayout horizontalScrollView;

        public StuffStringHolder(View view){
            super(view);
            titleView=(TextView)view.findViewById(R.id.view_title);
            horizontalScrollView=(LinearLayout) view.findViewById(R.id.scroll_view);
            horizontalScrollView.setOnTouchListener(new OnSwipeTouchListener(mContext));
        }

        private void bind(String string){
            titleView.setText(string);
        }
    }
}
