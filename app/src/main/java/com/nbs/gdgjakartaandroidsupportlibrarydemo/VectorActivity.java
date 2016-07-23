package com.nbs.gdgjakartaandroidsupportlibrarydemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class VectorActivity extends AppCompatActivity {
    private AnimatedVectorDrawableCompat playToResetAnim;
    private AnimatedVectorDrawableCompat resetToPlayAnim;
    private boolean isShowingPlay = true;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector);

        getSupportActionBar().setTitle("Vector Drawables");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        playToResetAnim = AnimatedVectorDrawableCompat.create(this, R.drawable.fab_play_to_reset_animated_vector);
        resetToPlayAnim = AnimatedVectorDrawableCompat.create(this, R.drawable.fab_reset_to_play_animated_vector);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setImageDrawable(playToResetAnim);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButtonIcon();
            }
        });
    }

    private void changeButtonIcon(){
        AnimatedVectorDrawableCompat currentDrawable = isShowingPlay ? playToResetAnim : resetToPlayAnim;
        floatingActionButton.setImageDrawable(currentDrawable);
        currentDrawable.start();
        isShowingPlay = !isShowingPlay;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, VectorActivity.class);
        context.startActivity(starter);
    }
}
