package com.example.vromia.healthadvisor.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.vromia.healthadvisor.R;


public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpPrefs();

    }

    private void setUpPrefs() {

        addPreferencesFromResource(R.xml.prefs);

        //when user clicks on "about" preference item
        //launch an alert dialog with the aboout text
        Preference screen = (Preference) findPreference("pref_key_about");
        screen.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);

                builder.setMessage("This app was developed by A , B , C in association with D ." +
                        "\n Special thanks to A , B , C , D")
                        .setTitle("About Us");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();


                return false;
            }
        });



    }
}
