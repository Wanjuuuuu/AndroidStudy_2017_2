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
import android.util.Log;
import android.widget.Button;

import com.example.wanjukim.myapplication.MainActivity;
import com.example.wanjukim.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Wanju Kim on 2017-11-28.
 */

public class NotificationActivity extends AppCompatActivity {
    @BindView(R.id.notify_button)Button button;

    private static final String TAG="Thread Exception";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_view);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.notify_button)
    public void onClickButton(){
        /* 알림에 대한 UI정보와 작업 지정 */
        final NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"default")
                .setSmallIcon(R.drawable.push_icon).setContentTitle("Hey Dude").setContentText("Click this");
        builder.setAutoCancel(true); // When clicking, notification in status bar will disappear

        /* heads up 기능 알림 추가 */
        Intent headsupIntent=new Intent();

        headsupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        headsupIntent.setClass(this, NotificationActivity.class);

        PendingIntent fullScreenPendingIntent=PendingIntent.getActivity(this,0,headsupIntent,PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setFullScreenIntent(fullScreenPendingIntent,true); // Pending intent to launch in screen, not only in status bar

        /* 알림과 연결될 activity를 intent로 */
        Intent intent=new Intent(this,NotificationResultActivity.class);
        Intent intent1=new Intent(this,ResultActivity1.class);
        Intent intent2=new Intent(this,ResultActivity2.class);

        /* stack builder로 이전 탐색 보존 */
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationResultActivity.class);
        stackBuilder.addNextIntent(intent);
        stackBuilder.addNextIntent(intent1);
        stackBuilder.addNextIntent(intent2);
        PendingIntent pendingIntent=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent); // Supply a PendingIntent to send when the notification is clicked

        /* 알림ID가 다른 경우, 복수의 동일한 알림이 가능해짐 */
        final int notifyID=11;

        /* Notification 객체를 전달해서 알림 발행 */
        final NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(notifyID,builder.build());

        /* 고정기간 진행 상태 표시 */
        new Thread(new Runnable() {
            @Override
            public void run() {
                int incr;
                for(incr=0;incr<=20;incr+=5){
                    builder.setProgress(20,incr,false); // max가 20될 때까지 progress
                    notificationManager.notify(notifyID,builder.build());
                    try{
                        Thread.sleep(5*1000); // 5초 동안 지연
                    }catch (InterruptedException e){
                        Log.d(TAG,"sleep failure");
                    }
                }
                builder.setContentText("Download complete").setProgress(0,0,false);
                notificationManager.notify(notifyID,builder.build());
            }
        }).start();
    }
}
