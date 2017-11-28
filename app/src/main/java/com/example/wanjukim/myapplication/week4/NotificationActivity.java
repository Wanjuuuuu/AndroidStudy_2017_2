package com.example.wanjukim.myapplication.week4;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.wanjukim.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Wanju Kim on 2017-11-28.
 */

public class NotificationActivity extends AppCompatActivity {
    @BindView(R.id.notify_button)Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_view);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.notify_button)
    public void onClickButton(){
        /* 알림에 대한 UI정보와 작업 지정 */
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"default")
                .setSmallIcon(R.drawable.push_icon).setContentTitle("Hey Dude").setContentText("Click this");

        /* 알림과 연결될 activity를 intent로 */
        Intent intent=new Intent(this,NotificationResultActivity.class);

        /* stack builder로 이전 탐색 보존 */
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationResultActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        /* 알림ID가 다른 경우, 복수의 동일한 알림이 가능해짐 */
        int notifyID=11;

        /* Notification 객체를 전달해서 알림 발행 */
        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notifyID,builder.build());
    }
}
