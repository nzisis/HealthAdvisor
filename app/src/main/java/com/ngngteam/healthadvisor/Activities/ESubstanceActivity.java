package com.ngngteam.healthadvisor.Activities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ngngteam.healthadvisor.Data.Database;
import com.ngngteam.healthadvisor.Data.ESubstanceItem;
import com.ngngteam.healthadvisor.R;
import com.ngngteam.healthadvisor.Utils.CustomPopUp;
import com.ngngteam.healthadvisor.Utils.ScrollableGridView;

import java.util.ArrayList;


public class ESubstanceActivity extends ActionBarActivity {

    ScrollableGridView gridView;
    //LinearLayout sideEffects;
    SideEffectsAdapter effectsAdapter;
    ImageAdapter adapter;
    Database database;
    ESubstanceItem item;
    String[] desc;
    TextView tvName, tvState, tvCompound, tvAttribute;
    LinearLayout llsubstance, llSideEffects;

    private boolean hasAnimations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esubstance);

        initUI();

        init();

        initListeners();

        setUI();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(getResources().getDrawable(R.mipmap.ic_launcher));

    }

    private void setUI() {

        tvName.setText(item.getName());
        if (item.getCategories().contains(0)) {
            tvState.setText("Safe");
            tvState.setTextColor(getResources().getColor(R.color.green));
            llsubstance.setBackgroundColor(getResources().getColor(R.color.green));

        } else {
            tvState.setText("Dangerous");
            tvState.setTextColor(getResources().getColor(R.color.red));
            llsubstance.setBackgroundColor(getResources().getColor(R.color.red));
        }
        tvCompound.setText(item.getCompound());
        tvAttribute.setText(item.getAttributes());


        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < item.getSideEffects().size(); i++) {

            View view = inflater.inflate(R.layout.list_row_side_effect, llSideEffects, false);
            TextView tvText = (TextView) view.findViewById(R.id.tv_side_effect);
            tvText.setText(item.getSideEffects().get(i));
            llSideEffects.addView(view);

        }


    }

    private void init() {

        hasAnimations = PreferenceManager.getDefaultSharedPreferences(ESubstanceActivity.this).getBoolean("pref_key_animations" , true);

        int id = (int) getIntent().getExtras().get("id");
        database = new Database(this);
        item = database.getESubstanceItemById(id);

        adapter = new ImageAdapter(this);
        adapter.updateIcons(item.getCategories());
        desc = getResources().getStringArray(R.array.popup_desc);
        gridView.setAdapter(adapter);

        effectsAdapter = new SideEffectsAdapter(this, R.layout.list_row_side_effect, item.getSideEffects());
        //sideEffects.setAdapter(effectsAdapter);

    }

    private void initUI() {
        tvName = (TextView) findViewById(R.id.tv_esubstance);
        tvState = (TextView) findViewById(R.id.tvState);
        tvCompound = (TextView) findViewById(R.id.tv_esubstance_compound);
        tvAttribute = (TextView) findViewById(R.id.tvAttribute);

        llsubstance = (LinearLayout) findViewById(R.id.llesubstance);

        gridView = (ScrollableGridView) findViewById(R.id.gvIcons);
        gridView.setExpanded(true);

        llSideEffects = (LinearLayout) findViewById(R.id.llSideEffects);

    }

    private void initListeners() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Toast.makeText(ESubstanceActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                // create window
                CustomPopUp pop = new CustomPopUp(ESubstanceActivity.this, getResources().getInteger(R.integer.popup_width));//specify the window width explicitly

                // set content view
                TextView tv = new TextView(ESubstanceActivity.this);
                //tv.setText(item.getSideEffects().get(1));
                tv.setText(desc[position]);
                tv.setPadding(20, 20, 20, 20);
                tv.setTextColor(Color.WHITE);
                pop.setBackgroundDrawable(new ColorDrawable(0xb3111213));
                pop.setContentView(tv);
                // set pointer image
                pop.setPointerImageRes(R.mipmap.ic_popup_pointer);
                // show popup window point to the anchor view
                pop.showAsPointer(v);
                // there are three kinds of built-in align mode are supported:DEFAULT, CENTER_FIX, AUTO_OFFSET
                pop.setAlignMode(CustomPopUp.AlignMode.CENTER_FIX);

                pop.setMarginScreen(50);
            }
        });

    }


    public class SideEffectsAdapter extends ArrayAdapter {

        Context context;
        int resource;
        ArrayList<String> items;

        public SideEffectsAdapter(Context context, int resource, ArrayList items) {
            super(context, resource, items);
            this.context = context;
            this.resource = resource;
            this.items = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(resource, parent, false);
            }
            TextView tvText = (TextView) convertView.findViewById(R.id.tv_side_effect);
            tvText.setText(items.get(position));


            return convertView;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        if (hasAnimations) {
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        }
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {  // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
//                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.mipmap.ic_safe,
                R.mipmap.ic_genetic,
                R.mipmap.ic_allergy,
                R.mipmap.ic_earth,
                R.mipmap.ic_danger,
                R.mipmap.ic_cancer,
                R.mipmap.ic_animal,
                R.mipmap.ic_headache,
                R.mipmap.ic_heart,
                R.mipmap.ic_suspicious,
                R.mipmap.forbidden,
                R.mipmap.ic_stomach,
                R.mipmap.ic_skin,
        };
        // set by sql category
        private Integer[] mThumbIdsActive = {
                R.mipmap.ic_safe_active,
                R.mipmap.ic_genetic_active,
                R.mipmap.ic_allergy_active,
                R.mipmap.ic_earth_active,
                R.mipmap.ic_danger_active,
                R.mipmap.ic_cancer_active,
                R.mipmap.ic_animal_active,
                R.mipmap.ic_headache_active,
                R.mipmap.ic_heart_active,
                R.mipmap.ic_suspicious_active,
                R.mipmap.forbidden_active,
                R.mipmap.ic_stomach_active,
                R.mipmap.ic_skin_active,

        };


        public void updateIcons(ArrayList<Integer> intArray) {
            for (int i : intArray) {
                mThumbIds[i] = mThumbIdsActive[i];
            }
        }


    }
}
