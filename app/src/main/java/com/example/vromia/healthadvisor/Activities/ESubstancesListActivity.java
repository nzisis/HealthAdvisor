package com.example.vromia.healthadvisor.Activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vromia.healthadvisor.Data.Database;
import com.example.vromia.healthadvisor.R;


public class ESubstancesListActivity extends ActionBarActivity {

    private ListView listview;
    private CustomCursorAdapter adapter;
    private Cursor cursor;
    private Database database;

    private EditText etSearch;

    private boolean hasAnimations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esubstances_list);


        hasAnimations = PreferenceManager.getDefaultSharedPreferences(ESubstancesListActivity.this).getBoolean("pref_key_animations", false);


        database = new Database(ESubstancesListActivity.this);


        etSearch = (EditText) findViewById(R.id.et_esubstances);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals("")) {
                    cursor = database.getAllEsubstancesDependOnNumber(s.toString());
                } else {
                    cursor = database.getAllESubstances();
                }
                adapter.changeCursor(cursor);
                adapter.notifyDataSetChanged();
                Toast.makeText(ESubstancesListActivity.this, s.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        listview = (ListView) findViewById(R.id.lv_esubstances_list);
        cursor = database.getAllESubstances();
        adapter = new CustomCursorAdapter(ESubstancesListActivity.this, cursor);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                cursor.moveToPosition(position);
                int idOfEsubstance = Integer.parseInt(cursor.getString(0));
                Intent i = new Intent(ESubstancesListActivity.this, ESubstanceActivity.class);
                i.putExtra("id", idOfEsubstance);
                startActivity(i);
                if (hasAnimations) {
                    overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                }
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(getResources().getDrawable(R.mipmap.ic_launcher));

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
            if (cursor.getString(5).contains("0")) {
                // good drawable
                holder.iv.setImageDrawable(getResources().getDrawable(R.mipmap.ic_safe_green));
            } else {
                //bad drawable
                holder.iv.setImageDrawable(getResources().getDrawable(R.mipmap.ic_dangerous));
            }
            holder.tvName.setText(cursor.getString(1));
            holder.tvDescription.setText(cursor.getString(2));

            newView.setTag(holder);

            return newView;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            Holder holder = (Holder) view.getTag();

            //set text and image view from cursor

            if (cursor.getString(5).contains("0")) {
                // good drawable
                holder.iv.setImageDrawable(getResources().getDrawable(R.mipmap.ic_safe_green));
            } else {
                //bad drawable
                holder.iv.setImageDrawable(getResources().getDrawable(R.mipmap.ic_dangerous));
            }
            holder.tvName.setText(cursor.getString(1));
            holder.tvDescription.setText(cursor.getString(2));


        }

        class Holder {
            ImageView iv;
            TextView tvName, tvDescription;

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (hasAnimations) {
            overridePendingTransition(R.anim.disappear_top_left_in, R.anim.disappear_top_left_out);
        }
    }
}
