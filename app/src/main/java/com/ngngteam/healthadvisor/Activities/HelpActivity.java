package com.ngngteam.healthadvisor.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.ngngteam.healthadvisor.R;

public class HelpActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
    }


}
