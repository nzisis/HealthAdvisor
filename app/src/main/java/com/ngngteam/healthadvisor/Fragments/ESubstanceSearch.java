package com.ngngteam.healthadvisor.Fragments;



import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ngngteam.healthadvisor.Adapters.SimpleESubstanceCursorRecycleAdapter;
import com.ngngteam.healthadvisor.Data.Database;
import com.ngngteam.healthadvisor.Data.ESubstanceItem;
import com.ngngteam.healthadvisor.Intefaces.ESubstanceListener;
import com.ngngteam.healthadvisor.Intefaces.RecycleViewListener;
import com.ngngteam.healthadvisor.R;
import com.ngngteam.healthadvisor.Utils.DividerItemDecoration;

/**
 * Created by Nick Zisis on 18-Oct-15.
 */
public class ESubstanceSearch extends Fragment implements RecycleViewListener {


    private RecyclerView rvSearch;
    private EditText etSearch;
    private SimpleESubstanceCursorRecycleAdapter adapter;


    private Cursor cursor;
    private Database database;

    private ESubstanceListener eSubstanceListener;

    public void setESubstanceListener(ESubstanceListener listener){
        this.eSubstanceListener=listener;
    }

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

        initBasicVariables();
        initListeners();

    }

    private void initBasicVariables(){
        database = new Database(getActivity());
        cursor = database.getAllESubstances();


            adapter = new SimpleESubstanceCursorRecycleAdapter(cursor, this,getActivity());
            rvSearch.setAdapter(adapter);



    }

    private void initListeners() {
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
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public void onViewClicked(int position) {
        cursor.moveToPosition(position);
        ESubstanceItem item = database.getESubstanceItemById(Integer.parseInt(cursor.getString(0)));
        item.setTag("ESubstance");
        //Update cursor to be again the whole ESubstances
        cursor = database.getAllESubstances();
        //Move to the specific ESubstance
        eSubstanceListener.onESubstanceSelected(item);

    }


}
