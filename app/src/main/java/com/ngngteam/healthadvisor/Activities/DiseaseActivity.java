package com.ngngteam.healthadvisor.Activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ngngteam.healthadvisor.Data.Database;
import com.ngngteam.healthadvisor.Data.DiseaseItem;
import com.ngngteam.healthadvisor.R;

import java.util.ArrayList;
import java.util.Locale;

public class DiseaseActivity extends ActionBarActivity {

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


    private ArrayList<DiseaseItem> diseaseItems;
    private Database db;
    private ActionBar.TabListener tabListener;

    private boolean hasAnimations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_activity);


        initUI();
        init();
        initListeners();


        getSupportActionBar().setTitle("Treatment for " + diseaseItems.get(0).getName());


        for (int i = 0; i < diseaseItems.size(); i++) {
            getSupportActionBar().addTab(
                    getSupportActionBar().newTab()
                            .setText(diseaseItems.get(i).getSubstance().get(0))
                            .setTabListener(tabListener));
        }


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(getResources().getDrawable(R.mipmap.ic_launcher));

    }


    private void initUI() {
        mViewPager = (ViewPager) findViewById(R.id.pager);

    }

    private void init() {

        hasAnimations = PreferenceManager.getDefaultSharedPreferences(DiseaseActivity.this).getBoolean("pref_key_animations", true);

        String name = (String) getIntent().getExtras().get("name");

        db = new Database(DiseaseActivity.this);
        diseaseItems = db.getDiseaseBasedOnName(name);


        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), diseaseItems);

        // Set up the ViewPager with the sections adapter.
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    private void initListeners() {
        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        getSupportActionBar().setSelectedNavigationItem(position);
                    }
                });

        // Create a tab listener that is called when the user changes tabs.
        tabListener = new ActionBar.TabListener() {
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                // show the given tab
                mViewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // hide the given tab
            }

            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // probably ignore this event
            }
        };

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        if (hasAnimations) {
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        }
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        private int uniqueIDs[];
        private int numberOfUniqueIDs;

        public SectionsPagerAdapter(FragmentManager fm, ArrayList<DiseaseItem> diseaseItems) {
            super(fm);

            numberOfUniqueIDs = diseaseItems.size();
            uniqueIDs = new int[numberOfUniqueIDs];
            for (int i = 0; i < numberOfUniqueIDs; i++) {
                uniqueIDs[i] = diseaseItems.get(i).getId();
            }
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);

            if (position < numberOfUniqueIDs) {
                PlaceholderFragment fragment = new PlaceholderFragment();
                fragment.setDiseaseList(diseaseItems);
                fragment.setID(uniqueIDs[position]);
                return fragment;

            }

            return null;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return numberOfUniqueIDs;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */

        private int id;
        private ArrayList<DiseaseItem> items;

        /*
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }*/

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_disease_activity2, container, false);
/*
            RadioGroup source = (RadioGroup) rootView.findViewById(R.id.radioGroupSource);
            RadioGroup effects = (RadioGroup) rootView.findViewById(R.id.radioGroupEffects);
            RadioGroup side_effects = (RadioGroup) rootView.findViewById(R.id.radioGroupSideEffects);
*/
            LinearLayout llSource, llEffects, llSideEffects, llGeneral;
            TextView tvOrigin, tvSubstanceName;

            llSource = (LinearLayout) rootView.findViewById(R.id.llSource);
            llEffects = (LinearLayout) rootView.findViewById(R.id.llEffect);
            llSideEffects = (LinearLayout) rootView.findViewById(R.id.llSideEffect);
            llGeneral = (LinearLayout) rootView.findViewById(R.id.llGeneral);

            tvOrigin = (TextView) rootView.findViewById(R.id.tvOrigin);

            tvSubstanceName = (TextView) rootView.findViewById(R.id.tvSubstanceName);

            DiseaseItem diseaseItem = null;


            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getId() == id) {
                    diseaseItem = items.get(i);
                }
            }

            tvSubstanceName.setText(diseaseItem.getSubstance().get(0));

            if (diseaseItem.getSubstance().get(1).trim().equals("natural")) {
                tvOrigin.setText("Natural Origin");
                tvOrigin.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.mipmap.ic_nature), null, null, null);
                tvOrigin.setCompoundDrawablePadding(4);
            } else {
                tvOrigin.setText("Chemical Origin");
                tvOrigin.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.mipmap.ic_chemical), null, null, null);
                tvOrigin.setCompoundDrawablePadding(4);
            }

            if (!diseaseItem.getSubstance().get(2).trim().equals("0")) {
//                TextView tvChemicalName = new TextView(getActivity());
//                tvChemicalName.setText("Compound : " + diseaseItem.getSubstance().get(2));
//                tvChemicalName.setPadding(4, 4, 4, 4);

                TextView tv = new TextView(getContext());
                tv.setText("Compound : " + diseaseItem.getSubstance().get(2));
                tv.setTextSize(14);
                tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                Drawable img = getContext().getResources().getDrawable(R.drawable.bullet);
                img.setBounds(0, 0, 10, 10);
                tv.setCompoundDrawables(img, null, null, null);
                tv.setCompoundDrawablePadding(8);
                tv.setGravity(Gravity.TOP);
                tv.setPadding(4, 4, 4, 4);
                llGeneral.addView(tv);
            }
            if (!diseaseItem.getSubstance().get(3).trim().equals("0")) {
//                TextView tvChemicalName = new TextView(getActivity());
//                tvChemicalName.setText("Trade Name : " + diseaseItem.getSubstance().get(3));
//                tvChemicalName.setPadding(4, 4, 4, 4);
                TextView tv = new TextView(getContext());
                tv.setText("Trade Name : " + diseaseItem.getSubstance().get(3));
                tv.setTextSize(14);
                tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                Drawable img = getContext().getResources().getDrawable(R.drawable.bullet);
                img.setBounds(0, 0, 10, 10);
                tv.setCompoundDrawables(img, null, null, null);
                tv.setCompoundDrawablePadding(8);
                tv.setGravity(Gravity.TOP);
                tv.setPadding(4, 4, 4, 4);
                llGeneral.addView(tv);
            }


            for (int i = 0; i < diseaseItem.getSources().size(); i++) {

                View view = inflater.inflate(R.layout.list_row_side_effect, container, false);
                TextView tvsource = (TextView) view.findViewById(R.id.tv_side_effect);
                tvsource.setText(diseaseItem.getSources().get(i));
                llSource.addView(view);
            }


            for (int i = 0; i < diseaseItem.getEffects().size(); i++) {

                View view = inflater.inflate(R.layout.list_row_side_effect, container, false);
                TextView tvsource = (TextView) view.findViewById(R.id.tv_side_effect);
                tvsource.setText(diseaseItem.getEffects().get(i));
//                TextView tv = new TextView(getContext());
//                tv.setText(diseaseItem.getEffects().get(i));
//                tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//                Drawable img = getContext().getResources().getDrawable(R.drawable.bullet);
//                img.setBounds(0, 0, 10, 10);
//                tv.setCompoundDrawables(img, null, null, null);
//                tv.setCompoundDrawablePadding(8);
//                tv.setGravity(Gravity.TOP);
//                tv.setPadding(4, 4, 4, 4);
                llEffects.addView(view);
            }


            for (int i = 0; i < diseaseItem.getSide_effects().size(); i++) {

                View view = inflater.inflate(R.layout.list_row_side_effect, container, false);
                TextView tvsource = (TextView) view.findViewById(R.id.tv_side_effect);
                tvsource.setText(diseaseItem.getSide_effects().get(i));
//                TextView tv = new TextView(getContext());
//                tv.setText(diseaseItem.getEffects().get(i));
//                tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//                Drawable img = getContext().getResources().getDrawable(R.drawable.bullet);
//                img.setBounds(0, 0, 10, 10);
//                tv.setCompoundDrawables(img, null, null, null);
//                tv.setCompoundDrawablePadding(8);
//                tv.setGravity(Gravity.TOP);
//                tv.setPadding(4, 4, 4, 4);
                llSideEffects.addView(view);
            }



/*

            for (int i = 0; i < diseaseItem.getEffects().size(); i++) {
                RadioButton rb = new RadioButton(rootView.getContext());
                rb.setText(diseaseItem.getEffects().get(i));
                effects.addView(rb);
            }


            for (int i = 0; i < diseaseItem.getSide_effects().size(); i++) {

                RadioButton rb = new RadioButton(rootView.getContext());
                rb.setText(diseaseItem.getSide_effects().get(i));
                side_effects.addView(rb);
            }
*/

            return rootView;
        }

        public void setID(int uniqueID) {
            this.id = uniqueID;
        }

        public void setDiseaseList(ArrayList<DiseaseItem> diseases) {
            items = diseases;
        }

    }

}
