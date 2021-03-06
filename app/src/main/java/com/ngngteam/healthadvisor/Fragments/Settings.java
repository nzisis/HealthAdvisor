package com.ngngteam.healthadvisor.Fragments;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.ngngteam.healthadvisor.Intefaces.HelpListener;
import com.ngngteam.healthadvisor.R;
import com.ngngteam.healthadvisor.Utils.ChangeLogDialog;

import it.gmariotti.changelibs.library.internal.ChangeLog;

/**
 * Created by Nick Zisis on 10/29/15.
 */
public class Settings extends PreferenceFragment {


    private HelpListener helpListener;


    public void setHelpListener(HelpListener listener){
        this.helpListener =listener;
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

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setMessage("Health Advisor was developed by the development team NGNG, by Nick Zisis, Nick Stampoulis and Ilias Zosimadis  in association " +
                        "with Chemical postgraduate student Argyri Kozari who provided the data ." +
                        "\n\nHealth Advisor participated on Eestec Android Competition 2015 and was nominee for the best " +
                        "innovation app among 2 other apps from a total of 550."+
                        "\n\n Libraries used:" +
                        "\n-ExpandableLayout by AAkira" +
                        "\n-CustomPopUp by RuiMa" +
                        "\n-ChangeLog by Gabriele Mariotti" +
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
                ChangeLogDialog dialog = new ChangeLogDialog();
                dialog.show(getFragmentManager(),"Version");

                return false;
            }
        });

        screen = findPreference("pref_key_rate_app");
        screen.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                Uri uri = Uri.parse("market://details?id=" + getActivity().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
                }

                return false;
            }
        });

        screen = findPreference("pref_key_help");
        screen.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                helpListener.onHelpPressed();
                return true;
            }
        });



    }
}
