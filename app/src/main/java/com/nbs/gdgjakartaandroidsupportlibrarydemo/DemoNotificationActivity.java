package com.nbs.gdgjakartaandroidsupportlibrarydemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DemoNotificationActivity extends AppCompatActivity
    implements View.OnClickListener{
    private Button btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_notification);

        getSupportActionBar().setTitle("Demo NotificationCompat.MessagingStyle");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnNotification = (Button)findViewById(R.id.btn_notification);
        btnNotification.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_notification){
            showNotification();
        }
    }

    private void showNotification(){
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                builder
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("NBS Chat")
                        .setContentText("Received Message")
                        .setAutoCancel(true)
                .setSound(defaultSoundUri)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setContentIntent(resultPendingIntent)
                .setStyle(new NotificationCompat.MessagingStyle("Me")
                .setConversationTitle("Scrum Meeting")
                .addMessage("Hi", System.currentTimeMillis(), "Taufan Arfianto")
                .addMessage("Meeting yuk", System.currentTimeMillis(), "Taufan Arfianto")
                .addMessage("Hayo", System.currentTimeMillis(), "Imam Muzakkir")
                .addMessage("Pagi ini ya", System.currentTimeMillis(), "Taufan Arfianto"));

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, DemoNotificationActivity.class);
        context.startActivity(starter);
    }
}
