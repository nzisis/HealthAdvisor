package com.ngngteam.healthadvisor.Fragments;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.ngngteam.healthadvisor.Activities.DiseaseActivity;
import com.ngngteam.healthadvisor.Adapters.SimpleCursorRecycleAdapter;
import com.ngngteam.healthadvisor.Data.Database;
import com.ngngteam.healthadvisor.R;
import com.ngngteam.healthadvisor.Utils.DividerItemDecoration;

/**
 * Created by Nick Zisis on 15-Oct-15.
 */
public class NormalView extends Fragment implements SimpleCursorRecycleAdapter.RecycleViewListener {

    private RecyclerView rvSearch;
    private EditText etSearch;
    private SimpleCursorRecycleAdapter adapter;

    private Cursor cursor;
    private Database database;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_normal_view, container, false);

        rvSearch = (RecyclerView) view.findViewById(R.id.rvSearch);
        rvSearch.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvSearch.addItemDecoration(new DividerItemDecoration(getActivity().getResources().getDrawable(R.drawable.divider),false,true));

        etSearch = (EditText) view.findViewById(R.id.et_search);


        return view;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        database = new Database(getActivity());
        cursor = database.getAllDiseases();

        if (adapter == null) {
            adapter = new SimpleCursorRecycleAdapter(cursor, this);
            rvSearch.setAdapter(adapter);
        }

        initListeners();

    }


    private void initListeners() {
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
                Toast.makeText(getActivity(), s.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public void onViewClicked(int position) {
        Cursor cursor = adapter.getCursor();
        cursor.moveToPosition(position);
        String nameOfDisease = cursor.getString(1);

        Intent i = new Intent(getActivity(), DiseaseActivity.class);
        i.putExtra("name", nameOfDisease);
        startActivity(i);
    }
}