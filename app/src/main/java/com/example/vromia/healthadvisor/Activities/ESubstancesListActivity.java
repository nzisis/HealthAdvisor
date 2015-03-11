package com.example.vromia.healthadvisor.Activities;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vromia.healthadvisor.Data.Database;
import com.example.vromia.healthadvisor.R;


public class ESubstancesListActivity extends ActionBarActivity {

    ListView listview;
    CustomCursorAdapter adapter;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esubstances_list);

        listview = (ListView) findViewById(R.id.lv_esubstances_list);
        cursor = new Database(ESubstancesListActivity.this).getAllESubstances();
        adapter = new CustomCursorAdapter(ESubstancesListActivity.this, cursor);

        listview.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_esubstances_list, menu);
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

    private class CustomCursorAdapter extends CursorAdapter {

        Context context;
        Cursor cursor;

        public CustomCursorAdapter(Context context, Cursor c) {
            super(context, c);
            this.context = context;
            this.cursor = c;
        }


        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {

            //get database cursor

            Holder holder = new Holder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

            View newView = inflater.inflate(R.layout.esubstances_list_row, parent, false);
            holder.iv = (ImageView) newView.findViewById(R.id.iv_esubstances);
            holder.tvName = (TextView) newView.findViewById(R.id.tv_esubstance_name);
            holder.tvDescription = (TextView) newView.findViewById(R.id.tv_esubstance_desc);

            //set texts and image view from cursor
            if (cursor.getString(5).equals("0")) {
                // good drawable
                holder.iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_safe));
            } else {
                //bad drawable
                holder.iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_danger));
            }
            holder.tvName.setText(cursor.getString(1));
            holder.tvDescription.setText(cursor.getString(2));

            newView.setTag(holder);

            return newView;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            Holder holder = (Holder) view.getTag();

            //set text and image view from cursorif(cursor.getString(5).equals("0")){

            if (cursor.getString(5).equals("0")) {
                // good drawable
                holder.iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_safe));
            } else {
                //bad drawable
                holder.iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_danger));
            }
            holder.tvName.setText(cursor.getString(1));
            holder.tvDescription.setText(cursor.getString(2));


        }

        class Holder {
            ImageView iv;
            TextView tvName, tvDescription;

        }

    }

}
