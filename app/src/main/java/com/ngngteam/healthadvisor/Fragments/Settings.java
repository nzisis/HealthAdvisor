package com.ngngteam.healthadvisor.Fragments;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.ngngteam.healthadvisor.Intefaces.HelpListener;
import com.ngngteam.healthadvisor.R;

/**
 * Created by Nick Zisis on 10/29/15.
 */
public class Settings extends PreferenceFragment {

    private Context context;
    private HelpListener helpListener;


    public void setHelpListener(HelpListener listener){
        this.helpListener =listener;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);

        Log.d("Settings ","Created");

        //when user clicks on "about" preference item
        //launch an alert dialog with the aboout text
        Preference screen = (Preference) findPreference("pref_key_about");
        screen.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

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

                Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
                }

                return false;
            }
        });

        screen = findPreference("pref_key_help");
        screen.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                //startActivity(new Intent(SettingsActivity.this, HelpActivity2.class));
                helpListener.onHelpPressed();
                return true;
            }
        });



    }
}
