package com.ngngteam.vromia.healthadvisor.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.ngngteam.vromia.healthadvisor.R;


public class SearchMenuActivity extends ActionBarActivity implements View.OnClickListener {

    Button bCategories, bSearch;

    private boolean hasAnimations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_menu);


        hasAnimations = PreferenceManager.getDefaultSharedPreferences(SearchMenuActivity.this).getBoolean("pref_key_animations", false);


        bCategories = (Button) findViewById(R.id.bSearchByCategory);
        bSearch = (Button) findViewById(R.id.bSearchByName);

        bCategories.setOnClickListener(this);
        bSearch.setOnClickListener(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(getResources().getDrawable(R.mipmap.ic_launcher));

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bSearchByCategory) {
            startActivity(new Intent(SearchMenuActivity.this, CategoryViewActivity.class));
        } else {
            startActivity(new Intent(SearchMenuActivity.this, SearchViewActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (hasAnimations) {
            overridePendingTransition(R.anim.disappear_top_left_in, R.anim.disappear_top_left_out);
        }
    }
}
