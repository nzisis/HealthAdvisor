package com.example.vromia.healthadvisor.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.vromia.healthadvisor.R;


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

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
