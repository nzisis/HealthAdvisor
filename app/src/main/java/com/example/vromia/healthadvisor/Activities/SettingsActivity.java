package com.example.vromia.healthadvisor.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import com.example.vromia.healthadvisor.R;


public class SettingsActivity extends PreferenceActivity {

    private boolean hasAnimations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        hasAnimations = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this).getBoolean("pref_key_animations", false);


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

        screen = findPreference("pref_key_help");
        screen.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(SettingsActivity.this, HelpActivity.class));
                return true;
            }
        });

        screen = findPreference("pref_key_animations");
        screen.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                hasAnimations = (boolean) newValue;
//                Log.i("nikos" , newValue.toString());
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (hasAnimations) {
            overridePendingTransition(R.anim.disappear_top_left_in, R.anim.disappear_top_left_out);
        }
    }
}
