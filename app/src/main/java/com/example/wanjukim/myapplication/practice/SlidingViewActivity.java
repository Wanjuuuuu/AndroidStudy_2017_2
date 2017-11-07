package com.example.wanjukim.myapplication.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.wanjukim.myapplication.R;

/**
 * Created by Wanju Kim on 2017-11-04.
 */

public class SlidingViewActivity extends AppCompatActivity {
    boolean isPageOpen=false;

    Animation translateLeftAnim;
    Animation translateRightAnim;
    LinearLayout page;
    Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding_sample);

        Log.d("Debugging_","set");

        page=(LinearLayout)findViewById(R.id.page);

        translateLeftAnim= AnimationUtils.loadAnimation(this,R.anim.translate_left);
        translateRightAnim=AnimationUtils.loadAnimation(this,R.anim.translate_right);

        SlidingPageAnimListener animListener=new SlidingPageAnimListener();
        translateLeftAnim.setAnimationListener(animListener);
        translateRightAnim.setAnimationListener(animListener);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPageOpen) {
                    page.startAnimation(translateRightAnim);
                }else{
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateLeftAnim);
                }
            }
        });
    }

    private class SlidingPageAnimListener implements AnimationListener{
        @Override
        public void onAnimationEnd(Animation animation) {
            if(isPageOpen){
                page.setVisibility(View.INVISIBLE);
                button.setText("open");
                isPageOpen=false;
            }else{
                button.setText("close");
                isPageOpen=true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        @Override
        public void onAnimationStart(Animation animation) {
            Log.d("Debugging_","start");
        }
    }
}
