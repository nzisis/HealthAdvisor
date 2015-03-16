package com.example.vromia.healthadvisor.Activities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vromia.healthadvisor.Data.Database;
import com.example.vromia.healthadvisor.Data.ESubstanceItem;
import com.example.vromia.healthadvisor.R;
import com.example.vromia.healthadvisor.Utils.CustomPopUp;
import com.example.vromia.healthadvisor.Utils.ScrollableGridView;

import java.util.ArrayList;


public class ESubstanceActivity extends ActionBarActivity {

    ScrollableGridView gridView;
    LinearLayout sideEffects;
    SideEffectsAdapter effectsAdapter;
    ImageAdapter adapter;
    Database database;
    ESubstanceItem item;
    String [] desc;
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


            LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
          for(int i=0; i<item.getSideEffects().size(); i++){

              View view=inflater.inflate(R.layout.list_row_side_effect,llSideEffects,false);
              TextView tvText = (TextView) view.findViewById(R.id.tv_side_effect);
              tvText.setText(item.getSideEffects().get(i));
              sideEffects.addView(view);

          }

     //   TextView tvText = (TextView) convertView.findViewById(R.id.tv_side_effect);
      //  tvText.setText(items.get(position));





        // setListViewHeightBasedOnChildren(sideEffects);
//        for (String s : item.getSideEffects()) {
//            TextView tvSideEffect = new TextView(this);
//
//            Log.i("nikos", item.getSideEffects().size() + "");
//
//            String htmlS = "&#8226; " + s;
//
//            tvSideEffect.setText(Html.fromHtml(htmlS));
//
//            llSideEffects.addView(tvSideEffect);
//        }

    }

    private void init() {
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
        //llSideEffects = (LinearLayout) findViewById(R.id.llSideEffects);

        gridView = (ScrollableGridView) findViewById(R.id.gvIcons);
        gridView.setExpanded(true);

        sideEffects = (LinearLayout) findViewById(R.id.lvSideEffects);

    }

    private void initListeners() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Toast.makeText(ESubstanceActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                // create window
                CustomPopUp pop = new CustomPopUp(ESubstanceActivity.this, 200);//specify the window width explicitly
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

    public static void setListViewHeightBasedOnChildren(ListView listView) {

/*
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null ) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if (listItem instanceof ViewGroup) listItem.setLayoutParams(lp);
            listItem.measure(widthMeasureSpec, heightMeasureSpec);
            totalHeight += listItem.getMeasuredHeight();
        }

        totalHeight += listView.getPaddingTop() + listView.getPaddingBottom();
        totalHeight += (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight;
        listView.setLayoutParams(params);
        listView.requestLayout();
        */
        /*

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int numberOfItems = listAdapter.getCount();

        // Get total height of all items.
        int totalItemsHeight = 0;
        for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
            View item = listAdapter.getView(itemPos, null, listView);
            item.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            Log.i("Nikos",(itemPos+1)+item.getMeasuredHeight()+"");
            totalItemsHeight += item.getMeasuredHeight();
        }

        // Get total height of all item dividers.
        int totalDividersHeight = listView.getDividerHeight() *
                (numberOfItems );

        // Set list height.
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalItemsHeight + totalDividersHeight;
        listView.setLayoutParams(params);
        listView.requestLayout();

*/


        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (view instanceof ViewGroup)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() -1));
        listView.setLayoutParams(params);
        listView.requestLayout();

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
                R.mipmap.ic_earth,
                R.mipmap.ic_danger,
                R.mipmap.ic_cancer,
                R.mipmap.ic_animal,
                R.mipmap.ic_head,
                R.mipmap.ic_heart,
                R.mipmap.ic_suspicious,
                R.mipmap.ic_stomach,
                R.mipmap.ic_skin,
        };
        // set by sql category
        private Integer[] mThumbIdsActive = {
                R.mipmap.ic_safe_active,
                R.mipmap.ic_genetic_active,
                R.mipmap.ic_earth_active,
                R.mipmap.ic_danger_active,
                R.mipmap.ic_cancer_active,
                R.mipmap.ic_animal_active,
                R.mipmap.ic_head_active,
                R.mipmap.ic_heart_active,
                R.mipmap.ic_suspicious_active,
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
