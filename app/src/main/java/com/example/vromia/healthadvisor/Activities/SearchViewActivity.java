package com.example.vromia.healthadvisor.Activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vromia.healthadvisor.Data.Database;
import com.example.vromia.healthadvisor.R;


public class SearchViewActivity extends ActionBarActivity {

    private ListView listview;
    private CustomCursorAdapter adapter;
    private Cursor cursor;
    private Database database;

    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        database = new Database(SearchViewActivity.this);


        etSearch = (EditText) findViewById(R.id.et_search);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals("")) {
                    cursor = database.getAllDiseasesDependOnName(s.toString());
                } else {
                    cursor = database.getAllDiseases();
                }
                adapter.changeCursor(cursor);
                adapter.notifyDataSetChanged();
                Toast.makeText(SearchViewActivity.this, s.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        listview = (ListView) findViewById(R.id.lvSearch);
        cursor = database.getAllDiseases();
        startManagingCursor(cursor);
        adapter = new CustomCursorAdapter(SearchViewActivity.this, cursor);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                cursor.moveToPosition(position);
                stopManagingCursor(cursor);
                String nameOfDisease = cursor.getString(1);
                Intent i = new Intent(SearchViewActivity.this, DiseaseActivity.class);
                i.putExtra("name", nameOfDisease);
                startActivity(i);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_view, menu);
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

            View newView = inflater.inflate(R.layout.disease_list_row, parent, false);
            holder.tvName = (TextView) newView.findViewById(R.id.tvName);

            holder.tvName.setText(cursor.getString(1));

            newView.setTag(holder);

            return newView;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            Holder holder = (Holder) view.getTag();

            //set text and image view from cursor

            holder.tvName.setText(cursor.getString(1));

        }

        class Holder {
            TextView tvName;

        }

    }
}
