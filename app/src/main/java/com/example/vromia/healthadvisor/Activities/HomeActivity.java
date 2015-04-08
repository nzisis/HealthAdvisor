package com.example.vromia.healthadvisor.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vromia.healthadvisor.Data.Database;
import com.example.vromia.healthadvisor.R;

import java.util.ArrayList;


public class HomeActivity extends ActionBarActivity {

    GridView gridView;
    ImageView imageView;
    ArrayList<Item> gridArray = new ArrayList<>();

    private boolean hasAnimations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageView = (ImageView) findViewById(R.id.imageIcon);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_lan_menu));


        hasAnimations = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this).getBoolean("pref_key_animations", false);
        Log.i("nikos", hasAnimations + "");

        Bitmap eSubstanceIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_menu_esubstance);
        Bitmap diseaseIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_menu_disease);
        Bitmap settingsIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_menu_settings);
        Bitmap exitIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_exit);


        gridArray.add(new Item(eSubstanceIcon, "E substances"));
        gridArray.add(new Item(diseaseIcon, "Diseases"));
        gridArray.add(new Item(settingsIcon, "Settings"));
        gridArray.add(new Item(exitIcon, "Exit"));

        gridView = (GridView) findViewById(R.id.gridview);
        CustomGridAdapter adapter = new CustomGridAdapter(HomeActivity.this, R.layout.grid_item_menu, gridArray);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(HomeActivity.this, ESubstancesListActivity.class));
                        if (hasAnimations) {
                            overridePendingTransition(R.anim.appear_top_left_in, R.anim.appear_top_left_out);
                        }
                        break;
                    case 1:
                        startActivity(new Intent(HomeActivity.this, SearchMenuActivity.class));
                        if (hasAnimations) {
                            overridePendingTransition(R.anim.appear_top_left_in, R.anim.appear_top_left_out);
                        }
                        break;
                    case 2:
                        startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                        if (hasAnimations) {
                            overridePendingTransition(R.anim.appear_top_left_in, R.anim.appear_top_left_out);
                        }
                        break;
                    case 3:
                        finish();
                        break;

                }
            }
        });

        Database mydb = new Database(this);
        mydb.showTuples();
        mydb.close();

    }

    @Override
    protected void onResume() {
        hasAnimations = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this).getBoolean("pref_key_animations", false);

        super.onResume();
    }

    public class CustomGridAdapter extends ArrayAdapter<Item> {


        int layoutResourceId;
        Context context;
        ArrayList<Item> data;

        public CustomGridAdapter(Context context, int layoutResourceId, ArrayList<Item> data) {
            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            Holder holder = null;

            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new Holder();
                holder.txtTitle = (TextView) row.findViewById(R.id.tvGridItem);
                holder.imageItem = (ImageView) row.findViewById(R.id.ivGridItem);
                row.setTag(holder);
            } else {
                holder = (Holder) row.getTag();
            }

            Item item = data.get(position);
            holder.txtTitle.setText(item.getTitle());
            holder.imageItem.setImageBitmap(item.getImage());
            return row;

        }

        class Holder {
            TextView txtTitle;
            ImageView imageItem;

        }

    }

    private static class Item {
        Bitmap image;
        String title;

        public Item(Bitmap image, String title) {
            super();
            this.image = image;
            this.title = title;
        }

        public Bitmap getImage() {
            return image;
        }

        public void setImage(Bitmap image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

}
