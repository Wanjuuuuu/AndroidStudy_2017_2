package com.example.wanjukim.myapplication;

import android.app.Application;
import android.content.Context;

import com.example.wanjukim.myapplication.week3.MyDBMigration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Wanju Kim on 2017-11-16.
 */

public class AndroidApplication extends Application{
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext=getApplicationContext();

        Realm.init(this); // application에서..

        RealmConfiguration config=new RealmConfiguration.Builder().name("osori.realm")
                .migration(new MyDBMigration()).schemaVersion(MyDBMigration.SCHEMA_VERSION)//
                .build();

        Realm.setDefaultConfiguration(config);
    }

    public static Context getContext(){
        return applicationContext;
    }
}
