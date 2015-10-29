package com.ngngteam.healthadvisor.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.ngngteam.healthadvisor.Data.DiseaseItem;
import com.ngngteam.healthadvisor.Data.ESubstanceItem;
import com.ngngteam.healthadvisor.Fragments.CategoryView;
import com.ngngteam.healthadvisor.Fragments.Disease;
import com.ngngteam.healthadvisor.Fragments.ESubstance;
import com.ngngteam.healthadvisor.Fragments.ESubstanceSearch;
import com.ngngteam.healthadvisor.Fragments.NormalView;
import com.ngngteam.healthadvisor.Intefaces.DiseaseListener;
import com.ngngteam.healthadvisor.Intefaces.ESubstanceListener;
import com.ngngteam.healthadvisor.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    private HashMap<String, Fragment> components;
    private String currentDiseaseTag, currentESubstanceTag;
    private boolean diseaseView;

    private Fragment firstPage, secondPage;

    private FragmentManager manager;

    private ESubstanceListener eSubstanceListener = new ESubstanceListener() {
        @Override
        public void onESubstanceSelected(ESubstanceItem item) {
            manager.beginTransaction().remove(components.get(currentESubstanceTag)).commit();
            currentESubstanceTag = item.getTag();
            ((ESubstance) components.get(currentESubstanceTag)).initESubstanceItem(item);
            secondPage = components.get(currentESubstanceTag);
            mSectionsPagerAdapter.notifyDataSetChanged();
        }
    };

    private DiseaseListener diseaseListener = new DiseaseListener() {
        @Override
        public void onDiseaseSelected(ArrayList<DiseaseItem> items) {
            manager.beginTransaction().remove(components.get(currentDiseaseTag)).commit();
            currentDiseaseTag = "Disease";
            ((Disease) components.get(currentDiseaseTag)).initTreatments(items);
            firstPage = components.get(currentDiseaseTag);
            mSectionsPagerAdapter.notifyDataSetChanged();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Init the basic components of the app
        init();

        setUpToolbar();

        setUpTabs();


    }

    private void init() {
        components = new HashMap<>();
        diseaseView = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getBoolean("pref_key_category_view", false);
        String tag;


        tag = "NormalView";
        NormalView normalView = new NormalView();
        normalView.setDiseaseListener(diseaseListener);
        components.put(tag, normalView);

        currentDiseaseTag = tag;

        tag = "CategoryView";
        CategoryView categoryView = new CategoryView();
        categoryView.setDiseaseListener(diseaseListener);
        components.put(tag, categoryView);

        if (diseaseView) currentDiseaseTag = tag;


        tag = "ESubstanceSearch";
        ESubstanceSearch eSubstanceSearch = new ESubstanceSearch();
        eSubstanceSearch.setESubstanceListener(eSubstanceListener);
        //eSubstanceSearch.setRe
        components.put(tag, eSubstanceSearch);

        currentESubstanceTag = tag;

        tag = "ESubstance";
        ESubstance eSubstance = new ESubstance();
        components.put(tag, eSubstance);

        tag = "Disease";
        Disease disease = new Disease();
        components.put(tag, disease);

        manager = getSupportFragmentManager();

    }

    private void setUpTabs() {
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(manager);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(mViewPager);


    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (firstPage == null) firstPage = components.get(currentDiseaseTag);
                    return firstPage;
                //getFragmentManager().beginTransaction().rem
                case 1:
                    if (secondPage == null) secondPage = components.get(currentESubstanceTag);
                    return secondPage;
            }
            return null;

        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    if (firstPage != null && firstPage instanceof Disease) return "TREATMENT";
                    return "DISEASES";
                case 1:
                    return "E-SUBSTANCES";
            }
            return null;
        }


        @Override
        public int getItemPosition(Object object) {
            if (object instanceof ESubstanceSearch && secondPage instanceof ESubstance) {
                return POSITION_NONE;
            }
            if (object instanceof ESubstance && secondPage instanceof ESubstanceSearch) {
                return POSITION_NONE;
            }
            if (object instanceof NormalView && firstPage instanceof Disease) {
                return POSITION_NONE;
            }
            if (object instanceof Disease && firstPage instanceof NormalView) {
                return POSITION_NONE;
            }
            if(object instanceof CategoryView && firstPage instanceof Disease){
                return POSITION_NONE;
            }
            if(object instanceof Disease && firstPage instanceof CategoryView){
                return POSITION_NONE;
            }
            if(object instanceof NormalView && firstPage instanceof CategoryView){
                return POSITION_NONE;
            }
            if(object instanceof CategoryView && firstPage instanceof NormalView){
                return POSITION_NONE;
            }

            return POSITION_UNCHANGED;
        }
    }

    @Override
    public void onBackPressed() {

        if (mViewPager.getCurrentItem() == 1) {

            if (secondPage instanceof ESubstance) {


                manager.beginTransaction().remove(components.get(currentESubstanceTag)).commit();
                currentESubstanceTag = "ESubstanceSearch";
                secondPage = components.get(currentESubstanceTag);

                mSectionsPagerAdapter.notifyDataSetChanged();


            } else {
                super.onBackPressed();
            }


        } else if (mViewPager.getCurrentItem() == 0) {

            if (firstPage instanceof Disease && !diseaseView) {
                manager.beginTransaction().remove(components.get(currentDiseaseTag)).commit();
                currentDiseaseTag = "NormalView";
                firstPage = components.get(currentDiseaseTag);

                mSectionsPagerAdapter.notifyDataSetChanged();
            }else if(firstPage instanceof Disease && diseaseView){
                manager.beginTransaction().remove(components.get(currentDiseaseTag)).commit();
                currentDiseaseTag = "CategoryView";
                firstPage = components.get(currentDiseaseTag);

                mSectionsPagerAdapter.notifyDataSetChanged();
            }
            else {
                super.onBackPressed();
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume(); PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getBoolean("pref_key_category_view", false);
        boolean currentDiseaseView =  PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getBoolean("pref_key_category_view", false);
        //User changed the view of the disease
        if(currentDiseaseView != diseaseView){
            diseaseView =currentDiseaseView;
            //User changed the view of diseases to be now category and the first page is set to the normal view
            if(currentDiseaseView && firstPage instanceof NormalView){
                manager.beginTransaction().remove(components.get(currentDiseaseTag)).commit();
                currentDiseaseTag = "CategoryView";
                firstPage = components.get(currentDiseaseTag);
                mSectionsPagerAdapter.notifyDataSetChanged();
            }//User chanded the view of diseases to be now normal and the first page is set to the category view
            else if(!currentDiseaseView && firstPage instanceof CategoryView){
                manager.beginTransaction().remove(components.get(currentDiseaseTag)).commit();
                currentDiseaseTag = "NormalView";
                firstPage = components.get(currentDiseaseTag);
                mSectionsPagerAdapter.notifyDataSetChanged();
            }
        }
    }
}
