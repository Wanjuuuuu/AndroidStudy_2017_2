package com.example.wanjukim.myapplication.week3;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wanjukim.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Wanju Kim on 2017-11-16.
 */

public class RealmTestActivity extends AppCompatActivity
        implements RealmTestContract.View{
    private RealmTestPresenter presenter;

    @BindView(R.id.memo_user_name_text)
    EditText userText;
    @BindView(R.id.memo_title_text)
    EditText titleText;
    @BindView(R.id.memo_contents_text)
    EditText contentsText;
    @BindView(R.id.memo_recycler_view)
    RecyclerView memoRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm_test);
        ButterKnife.bind(this);

        presenter=new RealmTestPresenter();
        presenter.attachView(this);

        MemoAdapter adapter=new MemoAdapter(this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);

        memoRecyclerView.setAdapter(adapter);
        memoRecyclerView.setLayoutManager(layoutManager);

        presenter.attachAdapter(adapter);

        presenter.init();
    }

    @Override
    public void toastMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.memo_post_button)
    public void onClickPostMemoButton(){
        String userName=String.valueOf(userText.getText());
        String memoTitle=String.valueOf(titleText.getText());
        String memoContents=String.valueOf(contentsText.getText());

        presenter.postMemo(userName,memoTitle,memoContents);
    }
}
