package com.example.vromia.healthadvisor.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.vromia.healthadvisor.Data.Database;
import com.example.vromia.healthadvisor.R;
import com.example.vromia.healthadvisor.Utils.CategoryViewAdapter;

import java.util.HashMap;
import java.util.List;


public class CategoryViewActivity extends ActionBarActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Database db;

    private boolean hasAnimations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        hasAnimations = PreferenceManager.getDefaultSharedPreferences(CategoryViewActivity.this).getBoolean("pref_key_animations", false);

        init();


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
    }

    private void init() {
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.expCategories);

        // preparing list data
        prepareListData();

        listAdapter = new CategoryViewAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String diseaseName = (String) listAdapter.getChild(groupPosition, childPosition);
                Intent i = new Intent(CategoryViewActivity.this, DiseaseActivity.class);
                i.putExtra("name", diseaseName);
                startActivity(i);
                if (hasAnimations) {
                    overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                }
                return true;

            }
        });
    }

    private void prepareListData() {

        db = new Database(this);

        listDataHeader = db.getAllCategories();

        listDataChild = new HashMap<>();
        for (String cat : listDataHeader) {
            List<String> diseases = db.getAllDiseasesBasedOnCategories(cat);
            listDataChild.put(cat, diseases);
        }
    }

}
