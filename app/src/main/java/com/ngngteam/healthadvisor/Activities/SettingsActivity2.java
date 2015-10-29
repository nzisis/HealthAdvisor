package com.ngngteam.healthadvisor.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;


import android.support.v7.app.AppCompatActivity;


import com.ngngteam.healthadvisor.Fragments.Help;
import com.ngngteam.healthadvisor.Fragments.Settings;
import com.ngngteam.healthadvisor.Intefaces.HelpListener;
import com.ngngteam.healthadvisor.R;



/**
 * Created by Nick Zisis on 10/29/15.
 */
public class SettingsActivity2 extends AppCompatActivity implements HelpListener {

    private Settings settings;
    private Help help;
    private FragmentManager manager;
    private String tag;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);

        initBasicVariables();

    }


    private void initBasicVariables(){
        settings = new Settings();
        settings.setHelpListener(this);
        help = new Help();

        tag = "Settings";

        manager= getFragmentManager();
        manager.beginTransaction().replace(R.id.flMainContent,settings).commit();

    }


    @Override
    public void onHelpPressed() {
        manager.beginTransaction().replace(R.id.flMainContent,help).commit();
        tag = "Help";
    }

    @Override
    public void onBackPressed() {
        if( tag.equals("Help")){
            manager.beginTransaction().replace(R.id.flMainContent,settings).commit();
            tag = "Settings";
        }else{
            super.onBackPressed();
        }
    }
}
