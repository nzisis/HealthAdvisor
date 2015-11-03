package com.ngngteam.healthadvisor.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ngngteam.healthadvisor.Fragments.Help;
import com.ngngteam.healthadvisor.Fragments.Settings;
import com.ngngteam.healthadvisor.Intefaces.HelpListener;
import com.ngngteam.healthadvisor.Intefaces.OnHelpBackPressed;
import com.ngngteam.healthadvisor.R;


/**
 * Created by Nick Zisis on 10/29/15.
 */
public class SettingsActivity extends AppCompatActivity implements HelpListener, OnHelpBackPressed {

    private Settings settings;
    private Help help;
    private FragmentManager manager;
    private String tag;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initBasicVariables();

        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                } else {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                }
            }
        });

    }


    private void initBasicVariables() {
        settings = new Settings();
        settings.setHelpListener(this);
        help = new Help();
        help.setOnHelpBackPressed(this);

        tag = "Settings";

        manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.flMainContent, settings).commit();

    }


    @Override
    public void onHelpPressed() {
        manager.beginTransaction().replace(R.id.flMainContent, help).addToBackStack("back").commit();
        tag = "Help";
    }


    @Override
    public void onBackPressed() {
        if (tag.equals("Help")) {
            manager.beginTransaction().replace(R.id.flMainContent, settings).commit();
            tag = "Settings";
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onHelpBackPressed() {
        manager.beginTransaction().replace(R.id.flMainContent, settings).commit();
        tag = "settings";
    }
}
