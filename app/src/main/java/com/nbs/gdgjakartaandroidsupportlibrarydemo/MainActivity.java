package com.nbs.gdgjakartaandroidsupportlibrarydemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
    implements AdapterView.OnItemClickListener{

    private String menus[] = new String[]{
            "Fragment New commitNow()",
            "NotificationCompat.MessagingStyle",
            "Custom Tabs",
            "Vector Drawable and Animated Vector Drawable",
            "Night Mode",
            "Bottom Sheets"
    };

    private ListView lvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItem = (ListView)findViewById(R.id.lv_item);
        lvItem.setOnItemClickListener(this);
        lvItem.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                menus));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                DemoFragmentActivity.start(this);
                break;

            case 1:
                DemoNotificationActivity.start(this);
                break;

            case 2:
                openCustomTabs();
                break;

            case 3:

                break;

        }
    }

    private void openCustomTabs() {
        String url = "https://developer.android.com";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}
