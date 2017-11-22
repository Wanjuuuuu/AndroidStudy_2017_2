package com.example.wanjukim.myapplication.week3;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Wanju Kim on 2017-11-16.
 */

public class Memo extends RealmObject {
    @PrimaryKey
    private String title;

    private String contents;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
