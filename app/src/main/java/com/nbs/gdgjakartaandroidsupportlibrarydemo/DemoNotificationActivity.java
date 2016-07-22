package com.nbs.gdgjakartaandroidsupportlibrarydemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                builder.setStyle(new NotificationCompat.MessagingStyle("Me")
                        .setConversationTitle("Scrum Meeting")
                        .addMessage("Hi", System.currentTimeMillis(), "Taufan Arfianto")
                        .addMessage("Meeting yuk", System.currentTimeMillis(), "Taufan Arfianto")
                        .addMessage("Hayo", System.currentTimeMillis(), "Imam Muzakkir")
                        .addMessage("Pagi ini ya", System.currentTimeMillis(), "Taufan Arfianto"))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true);
        Notification notification = builder.build();
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
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
