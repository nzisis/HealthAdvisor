package com.ngngteam.healthadvisor.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import com.ngngteam.healthadvisor.Utils.CustomViewPager;

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


    private HashMap<String,Fragment> components;
    private String currentDiseaseTag,currentESubstanceTag;

    private Fragment firstPage,secondPage;

    private FragmentManager manager;

    private ESubstanceListener eSubstanceListener = new ESubstanceListener() {
        @Override
        public void onESubstanceSelected(ESubstanceItem item) {
            manager.beginTransaction().remove(components.get(currentESubstanceTag)).commit();
            currentESubstanceTag=item.getTag();
            ((ESubstance)components.get(currentESubstanceTag)).initESubstanceItem(item);
            secondPage = components.get(currentESubstanceTag);
            mSectionsPagerAdapter.notifyDataSetChanged();
        }
    };

    private DiseaseListener diseaseListener = new DiseaseListener() {
        @Override
        public void onDiseaseSelected(ArrayList<DiseaseItem> items) {
            manager.beginTransaction().remove(components.get(currentDiseaseTag)).commit();
            currentDiseaseTag="Disease";
            ((Disease)components.get(currentDiseaseTag)).initTreatments(items);
            firstPage =components.get(currentDiseaseTag);
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

        String tag="NormalView";
        NormalView normalView = new NormalView();
        normalView.setDiseaseListener(diseaseListener);
        components.put(tag,normalView);

        currentDiseaseTag=tag;


        tag="CategoryView";
        CategoryView categoryView=new CategoryView();
        components.put(tag, categoryView);

        tag="ESubstanceSearch";
        ESubstanceSearch eSubstanceSearch = new ESubstanceSearch();
        eSubstanceSearch.setESubstanceListener(eSubstanceListener);
        //eSubstanceSearch.setRe
        components.put(tag,eSubstanceSearch);

        currentESubstanceTag=tag;

        tag="ESubstance";
        ESubstance eSubstance=new ESubstance();
        components.put(tag,eSubstance);

        tag="Disease";
        Disease disease = new Disease();
        components.put(tag,disease);

        manager = getSupportFragmentManager();

    }

    private void setUpTabs() {
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



//    @Override
//    public void onESubstanceSelected(ESubstanceItem item) {
//          manager.beginTransaction().remove(components.get(currentESubstanceTag)).commit();
//          currentESubstanceTag=item.getTag();
//         ((ESubstance)components.get(currentESubstanceTag)).initESubstanceItem(item);
//          secondPage = components.get(currentESubstanceTag);
//          mSectionsPagerAdapter.notifyDataSetChanged();
//    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter{

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if(firstPage == null) firstPage= components.get(currentDiseaseTag);
                    return  firstPage;
                //getFragmentManager().beginTransaction().rem
                case 1:
                    if(secondPage == null) secondPage =components.get(currentESubstanceTag);
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
                    if(firstPage!=null && firstPage instanceof Disease) return "TREATMENT";
                    return "DISEASES";
                case 1:
                    return "E-SUBSTANCES";
            }
            return null;
        }




        @Override
        public int getItemPosition(Object object) {
            if(object instanceof ESubstanceSearch && secondPage instanceof ESubstance ){
                return POSITION_NONE;
            }if(object instanceof ESubstance && secondPage instanceof ESubstanceSearch ){
                return POSITION_NONE;
            }if(object instanceof  NormalView && firstPage instanceof Disease){
                return POSITION_NONE;
            }if(object instanceof  Disease && firstPage instanceof NormalView){
                return POSITION_NONE;
            }
            return POSITION_UNCHANGED;
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
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    @Override
    public void onBackPressed() {

        if(mViewPager.getCurrentItem() == 1){

            if(secondPage instanceof ESubstance){


                    manager.beginTransaction().remove(components.get(currentESubstanceTag)).commit();
                    currentESubstanceTag="ESubstanceSearch";
                    secondPage=components.get(currentESubstanceTag);

                    mSectionsPagerAdapter.notifyDataSetChanged();


            }else{
                super.onBackPressed();
            }


        }else if(mViewPager.getCurrentItem() == 0){

            if(firstPage instanceof Disease){
                manager.beginTransaction().remove(components.get(currentDiseaseTag)).commit();
                currentDiseaseTag="NormalView";
                firstPage=components.get(currentDiseaseTag);

                mSectionsPagerAdapter.notifyDataSetChanged();
            }else {
                super.onBackPressed();
            }
        }

    }
}
