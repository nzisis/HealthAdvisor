package com.example.vromia.healthadvisor.Activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vromia.healthadvisor.Data.Database;
import com.example.vromia.healthadvisor.R;

import java.util.ArrayList;


public class HomeActivity extends ActionBarActivity {

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bitmap homeIcon = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_avoid);
        Bitmap userIcon = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_safe);


        gridArray.add(new Item(homeIcon,"Menu item 1" ));
        gridArray.add(new Item(userIcon,"Menu item 2" ));
        gridArray.add(new Item(homeIcon,"Menu item 1" ));
        gridArray.add(new Item(userIcon,"Menu item 2" ));
        gridArray.add(new Item(homeIcon,"Menu item 1" ));
        gridArray.add(new Item(userIcon,"Menu item 2" ));
        gridArray.add(new Item(homeIcon,"Menu item 1" ));
        gridArray.add(new Item(userIcon,"Menu item 2" ));
        gridArray.add(new Item(homeIcon,"Menu item 1" ));
        gridArray.add(new Item(userIcon,"Menu item 2" ));
        gridArray.add(new Item(homeIcon,"Menu item 1" ));
        gridArray.add(new Item(userIcon,"Menu item 2" ));

        gridView = (GridView) findViewById(R.id.gridview);
        CustomGridAdapter adapter = new CustomGridAdapter(HomeActivity.this , R.layout.grid_item_menu , gridArray);
        gridView.setAdapter(adapter);

        Database mydb = new Database(this);
        mydb.showTuples();
        mydb.close();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    public class CustomGridAdapter extends ArrayAdapter<Item> {


        int layoutResourceId;
        Context context;
        ArrayList<Item> data;

        public CustomGridAdapter(Context context, int layoutResourceId, ArrayList<Item> data) {
            super(context, layoutResourceId , data);
            this.layoutResourceId=layoutResourceId;
            this.context=context;
            this.data=data;
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
