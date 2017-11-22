package com.example.wanjukim.myapplication.week3;

import io.realm.RealmResults;

/**
 * Created by Wanju Kim on 2017-11-16.
 */

public interface MemoAdapterContract {
    interface View{
        void notifyMemoRangeInserted(int from,int count);
        void notifyMemoRangeDeleted(int from,int count);
        void notifyMemoRangeModified(int from,int count);
        void notifyMemoSetChanged();
        void setOnMemoClickListener(MemoAdapter.OnMemoClickListener listener);
    }

    interface Model{
        void init(RealmResults<Memo> memoResults);
    }
}
