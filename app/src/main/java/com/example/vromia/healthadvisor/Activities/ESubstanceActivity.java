package com.example.vromia.healthadvisor.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vromia.healthadvisor.Data.Database;
import com.example.vromia.healthadvisor.Data.ESubstanceItem;
import com.example.vromia.healthadvisor.R;
import com.example.vromia.healthadvisor.Utils.ScrollableGridView;

import java.util.ArrayList;


public class ESubstanceActivity extends ActionBarActivity {

    ScrollableGridView gridView;
    ImageAdapter adapter;
    Database database;
    ESubstanceItem item;

    TextView tvName, tvState, tvCompound, tvAttribute;
    LinearLayout llsubstance , llSideEffects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esubstance);

        initUI();

        init();

        initListeners();

        setUI();

    }

    private void setUI() {

        tvName.setText(item.getName());
        if(item.getCategories().contains(0)){
            tvState.setText("Safe");
            tvState.setTextColor(getResources().getColor(R.color.green));
            llsubstance.setBackgroundColor(getResources().getColor(R.color.green));

        }else{
            tvState.setText("Dangerous");
            tvState.setTextColor(getResources().getColor(R.color.red));
            llsubstance.setBackgroundColor(getResources().getColor(R.color.red));
        }
        tvCompound.setText(item.getCompound());
        tvAttribute.setText(item.getAttributes());

        for(String s : item.getSideEffects()){
            TextView tvSideEffect = new TextView(this);

            Log.i("nikos" , item.getSideEffects().size() + "");

            String htmlS = "&#8226; " + s;

            tvSideEffect.setText(Html.fromHtml(htmlS));

            llSideEffects.addView(tvSideEffect);
        }

    }

    private void init() {
        int id = (int) getIntent().getExtras().get("id");
        database = new Database(this);
        item = database.getESubstanceItemById(id);

        adapter = new ImageAdapter(this);
        adapter.updateIcons(item.getCategories());

        gridView.setAdapter(adapter);
    }

    private void initUI() {
        tvName = (TextView) findViewById(R.id.tv_esubstance);
        tvState = (TextView) findViewById(R.id.tvState);
        tvCompound = (TextView) findViewById(R.id.tv_esubstance_compound);
        tvAttribute = (TextView) findViewById(R.id.tvAttribute);

        llsubstance = (LinearLayout) findViewById(R.id.llesubstance);
        llSideEffects = (LinearLayout) findViewById(R.id.llSideEffects);

        gridView = (ScrollableGridView) findViewById(R.id.gvIcons);
        gridView.setExpanded(true);
    }

    private void initListeners() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(ESubstanceActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

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
                R.drawable.ic_danger,
                R.drawable.ic_test,
                R.drawable.ic_allergy,
                R.drawable.ic_genetic,
                R.drawable.ic_radio_active,
                R.drawable.ic_danger,
                R.drawable.ic_test,
                R.drawable.ic_allergy,
                R.drawable.ic_genetic,
                R.drawable.ic_radio_active

        };
        private Integer[] mThumbIdsActive = {
                R.drawable.ic_bio_hazzard ,
                R.drawable.ic_bio_hazzard ,
                R.drawable.ic_bio_hazzard ,
                R.drawable.ic_bio_hazzard ,
                R.drawable.ic_bio_hazzard ,
                R.drawable.ic_bio_hazzard ,
                R.drawable.ic_bio_hazzard ,
                R.drawable.ic_bio_hazzard ,
                R.drawable.ic_bio_hazzard ,
                R.drawable.ic_bio_hazzard ,

        };


        public void updateIcons(ArrayList<Integer> intArray) {
            for (int i : intArray) {
                if (i != 0) {
                    mThumbIds[i - 1] = mThumbIdsActive[i - 1];
                }
            }
        }


    }
}
