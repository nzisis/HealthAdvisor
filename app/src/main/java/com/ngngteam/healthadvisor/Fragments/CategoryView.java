package com.ngngteam.healthadvisor.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ExpandableListView;

import com.ngngteam.healthadvisor.Activities.DiseaseActivity;
import com.ngngteam.healthadvisor.Data.Database;
import com.ngngteam.healthadvisor.Model.CategoryViewModel;
import com.ngngteam.healthadvisor.R;
import com.ngngteam.healthadvisor.Adapters.CategoryViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick Zisis on 15-Oct-15.
 */
public class CategoryView extends Fragment {


   // private ExpandableRecyclerView expandableRecyclerView;
    private CategoryViewAdapter adapter;
    private ExpandableListView expListView;
    private List<CategoryViewModel> data;
    private Database db;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_view, container, false);
//        expandableRecyclerView = (ExpandableRecyclerView) view.findViewById(R.id.expCategories);
//        expandableRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
         expListView=(ExpandableListView) view.findViewById(R.id.expCategories);

        return view;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (adapter == null) {

            initData();
            adapter = new CategoryViewAdapter(getActivity(),data);
            expListView.setAdapter(adapter);
            expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    String diseaseName = ((CategoryViewModel) adapter.getChild(groupPosition, childPosition)).getContext();
                    Intent i = new Intent(getActivity(), DiseaseActivity.class);
                    i.putExtra("name", diseaseName);
                    startActivity(i);
//                    if (hasAnimations) {
//                        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
//                    }
                    return true;

                }
            });

        }


    }


    private void initData() {
        db = new Database(getActivity());

        data = new ArrayList<>();

        ArrayList<String> categories = db.getAllCategories();

        for (int i = 0; i < categories.size(); i++) {
            data.add(new CategoryViewModel(categories.get(i), i));
            List<String> children = db.getAllDiseasesBasedOnCategories(categories.get(i));
            Log.i("Category",categories.get(i));
            for (int j = 0; j < children.size(); j++) {
                data.add(new CategoryViewModel(children.get(j), i, j));
                Log.d("Categories diseases ",children.get(j));
            }
        }



    }


}
