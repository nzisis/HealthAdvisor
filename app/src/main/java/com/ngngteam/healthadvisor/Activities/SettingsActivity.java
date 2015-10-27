package com.ngngteam.healthadvisor.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import com.ngngteam.healthadvisor.HelpActivity2;
import com.ngngteam.healthadvisor.R;


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

                builder.setMessage("Health Advisor was developed by the development team NG^2, by Nick Zisis, Nick Stampoulis and Ilias Zosimadis  in association " +
                        "with Chemical postgraduate student Argyri Kozari ." +
                        "\n\n Libraries used:" +
                        "\n-ActivityTransaction by ophilbert" +
                        "\n-CustomPopUp by RuiMa" +
                        "\n\n Most of our icons designed by www.icons8.com  " +
                        "\n\n Contact us: ngngteam2014@gmail.com")
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
                startActivity(new Intent(SettingsActivity.this, HelpActivity2.class));
                return true;
            }
        });

    }

}
