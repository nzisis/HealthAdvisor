package com.ngngteam.healthadvisor.Activities;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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

        screen = (Preference) findPreference("pref_key_version");
        screen.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                //TODO show Changelog

                return false;
            }
        });

        screen = findPreference("pref_key_rate_app");
        screen.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }

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
