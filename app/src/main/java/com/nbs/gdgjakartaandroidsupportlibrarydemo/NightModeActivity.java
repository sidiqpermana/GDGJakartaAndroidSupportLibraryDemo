package com.nbs.gdgjakartaandroidsupportlibrarydemo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NightModeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnModeAuto, btnModeNight, btnModeDay;
    private TextView tvSelectedNightMode;
    private int currentDayNightMode = AppCompatDelegate.MODE_NIGHT_AUTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_mode);

        getSupportActionBar().setTitle("Night Mode Demo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnModeAuto = (Button)findViewById(R.id.btn_mode_auto);
        btnModeDay = (Button)findViewById(R.id.btn_mode_day);
        btnModeNight = (Button)findViewById(R.id.btn_mode_night);
        tvSelectedNightMode = (TextView)findViewById(R.id.tv_selected_night_mode);

        btnModeDay.setOnClickListener(this);
        btnModeNight.setOnClickListener(this);
        btnModeAuto.setOnClickListener(this);

        int currentUiMode = getResources().getConfiguration().uiMode;
        int currentDayNightUiMode = currentUiMode & Configuration.UI_MODE_NIGHT_MASK;

        if (currentDayNightUiMode == Configuration.UI_MODE_NIGHT_NO){
            currentDayNightMode = AppCompatDelegate.MODE_NIGHT_NO;
            tvSelectedNightMode.setText("MODE NIGHT NO");
        }else if (currentDayNightUiMode == Configuration.UI_MODE_NIGHT_YES){
            currentDayNightMode = AppCompatDelegate.MODE_NIGHT_YES;
            tvSelectedNightMode.setText("MODE NIGHT YES");
        }else{
            currentDayNightMode = AppCompatDelegate.MODE_NIGHT_AUTO;
            tvSelectedNightMode.setText("MODE NIGHT AUTO");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_mode_auto:
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
                recreate();
                break;

            case R.id.btn_mode_day:
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
                break;

            case R.id.btn_mode_night:
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();
                break;
        }
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, NightModeActivity.class);
        context.startActivity(starter);
    }
}
