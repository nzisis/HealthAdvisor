package com.ngngteam.healthadvisor.Fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.ngngteam.healthadvisor.R;

/**
 * Created by Nick Zisis on 10/29/15.
 */
public class Help extends Fragment {

    private Toolbar toolbar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help,container,false);

        toolbar=(Toolbar) view.findViewById(R.id.toolbar);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AppCompatActivity act = (AppCompatActivity) getActivity();
        act.setSupportActionBar(toolbar);
        act.getSupportActionBar().setHomeButtonEnabled(true);
    }
}
