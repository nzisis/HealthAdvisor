package com.example.vromia.healthadvisor.Activities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vromia.healthadvisor.Data.Database;
import com.example.vromia.healthadvisor.Data.ESubstanceItem;
import com.example.vromia.healthadvisor.R;
import com.example.vromia.healthadvisor.Utils.CustomPopUp;
import com.example.vromia.healthadvisor.Utils.ScrollableGridView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class ESubstanceActivity extends ActionBarActivity {

    ScrollableGridView gridView;
    ImageAdapter adapter;
    Database database;
    ESubstanceItem item;

    TextView tvName, tvState, tvCompound, tvAttribute;
    LinearLayout llsubstance, llSideEffects;

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

        for (String s : item.getSideEffects()) {
            TextView tvSideEffect = new TextView(this);

            Log.i("nikos", item.getSideEffects().size() + "");

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
                //Toast.makeText(ESubstanceActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                // create window
                CustomPopUp pop = new CustomPopUp(ESubstanceActivity.this, 400);//specify the window width explicitly
                // set content view
                TextView tv = new TextView(ESubstanceActivity.this);
                tv.setText(item.getSideEffects().get(1));
                tv.setPadding(20,20,20,20);
                tv.setTextColor(Color.WHITE);
                pop.setBackgroundDrawable(new ColorDrawable(0xb3111213));
                pop.setContentView(tv);
                // set pointer image
                pop.setPointerImageRes(R.mipmap.ic_popup_pointer);
                // show popup window point to the anchor view
                pop.showAsPointer(v);
                // there are three kinds of built-in align mode are supported:DEFAULT, CENTER_FIX, AUTO_OFFSET
                pop.setAlignMode(CustomPopUp.AlignMode.AUTO_OFFSET);

                pop.setMarginScreen(50);
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
                R.mipmap.ic_safe,
                R.mipmap.ic_genetic,
                R.mipmap.ic_danger,
                R.mipmap.ic_bio_hazzard,
                R.mipmap.ic_avoid,
                R.mipmap.ic_animal,
                R.mipmap.ic_suspicious,
                R.mipmap.ic_radio,
        };
        // set by sql category
        private Integer[] mThumbIdsActive = {
                R.mipmap.ic_safe_active,
                R.mipmap.ic_genetic_active,
                R.mipmap.ic_danger_active,
                R.mipmap.ic_bio_hazzard_active,
                R.mipmap.ic_avoid_active,
                R.mipmap.ic_animal_active,
                R.mipmap.ic_suspicious_active,
                R.mipmap.ic_radio_active,
        };


        public void updateIcons(ArrayList<Integer> intArray) {
            for (int i : intArray) {
                mThumbIds[i] = mThumbIdsActive[i];
            }
        }


    }
}
