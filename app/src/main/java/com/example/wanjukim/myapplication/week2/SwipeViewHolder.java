package com.example.wanjukim.myapplication.week2;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wanjukim.myapplication.R;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;

/**
 * Created by Wanju Kim on 2017-11-09.
 */

public class SwipeViewHolder extends AbstractSwipeableItemViewHolder {
    LinearLayout containerView;
    TextView textView;

    public SwipeViewHolder(View itemView) {
        super(itemView);
        containerView = itemView.findViewById(R.id.swipe_view_container);
        textView = itemView.findViewById(R.id.view_text);
    }

    //Gets the container view for the swipeable area
    @Override
    public View getSwipeableContainerView() {
        return containerView;
    }
}
