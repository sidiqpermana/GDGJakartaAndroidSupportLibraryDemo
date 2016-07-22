package com.nbs.gdgjakartaandroidsupportlibrarydemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class DemoFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_fragment);

        getSupportActionBar().setTitle("commitNow() Demo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null){
            DemoFragment mDemoFragment = new DemoFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, mDemoFragment, DemoFragment.class.getSimpleName())
                    .commitNow();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, DemoFragmentActivity.class);
        context.startActivity(starter);
    }
}
