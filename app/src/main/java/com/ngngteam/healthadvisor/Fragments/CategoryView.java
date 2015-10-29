package com.ngngteam.healthadvisor.Fragments;



import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ExpandableListView;


import com.ngngteam.healthadvisor.Data.Database;
import com.ngngteam.healthadvisor.Data.DiseaseItem;
import com.ngngteam.healthadvisor.Intefaces.DiseaseListener;
import com.ngngteam.healthadvisor.Model.CategoryViewModel;
import com.ngngteam.healthadvisor.R;
import com.ngngteam.healthadvisor.Adapters.CategoryViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick Zisis on 15-Oct-15.
 */
public class CategoryView extends Fragment {


    private CategoryViewAdapter adapter;
    private ExpandableListView expListView;
    private List<CategoryViewModel> data;
    private Database db;

    private DiseaseListener diseaseListener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_category_view, container, false);
         expListView=(ExpandableListView) view.findViewById(R.id.expCategories);

        return view;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

            initData();
            adapter = new CategoryViewAdapter(getActivity(),data);
            expListView.setAdapter(adapter);
            expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                    String diseaseName = ((CategoryViewModel) adapter.getChild(groupPosition, childPosition)).getContext();
                    ArrayList<DiseaseItem> items = db.getDiseaseBasedOnName(diseaseName);
                    diseaseListener.onDiseaseSelected(items);
                    expListView.setSelection(expListView.getFirstVisiblePosition());

                    return true;

                }
            });




    }

    public void setDiseaseListener(DiseaseListener listener){
        this.diseaseListener = listener;
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
