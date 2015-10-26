package com.ngngteam.healthadvisor.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ngngteam.healthadvisor.Adapters.DiseaseRecycleAdapter;
import com.ngngteam.healthadvisor.Data.DiseaseItem;
import com.ngngteam.healthadvisor.R;
import com.ngngteam.healthadvisor.Utils.DividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by Nick Zisis on 10/24/15.
 */
public class Disease extends Fragment {

    private ArrayList<DiseaseItem> items;
    private RecyclerView recyclerView;
    private DiseaseRecycleAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.recycle_view,container,false);
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity().getResources().getDrawable(R.drawable.divider),false,false));


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initBasicVariables();
    }

    private void initBasicVariables(){

        adapter = new DiseaseRecycleAdapter(items);
        recyclerView.setAdapter(adapter);
    }


    public void initTreatments(ArrayList<DiseaseItem> items){
        this.items = items;
    }


}
