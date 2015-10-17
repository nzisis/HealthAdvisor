package com.ngngteam.healthadvisor.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.ngngteam.healthadvisor.Fragments.CategoryView;
import com.ngngteam.healthadvisor.Model.CategoryViewModel;
import com.ngngteam.healthadvisor.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Vromia on 28/2/2015.
 */
public class CategoryViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> listDataChild;
    private List<CategoryViewModel> data;


    public CategoryViewAdapter(Context context, List<String> listDataHeader,
                               HashMap<String, List<String>> listChildData) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
    }

    public CategoryViewAdapter(Context context, List<CategoryViewModel> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public int getGroupCount() {
        int size = 0;
        for (CategoryViewModel model : data) {
            if (model.isHeader()) size++;
        }

        return size;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        int size = 0;
        for (CategoryViewModel model : data) {
            if (!model.isHeader() && model.getGroupPosition()==groupPosition) size++;
        }

        return size;
    }

    @Override
    public Object getGroup(int groupPosition) {
        for (CategoryViewModel model : data) {
            if (model.isHeader() && model.getGroupPosition() == groupPosition) return model;
        }
        return null;


    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        for (CategoryViewModel model : data) {
            if (!model.isHeader() && model.getGroupPosition() == groupPosition && model.getChildPosition() == childPosition) {
                //                Log.d("Context",model.getContext());
                return model;
            }
        }

        return null;

    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = ((CategoryViewModel) getGroup(groupPosition)).getTitle();
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String childText = ((CategoryViewModel) getChild(groupPosition, childPosition)).getContext();

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.disease_list_row, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.tvName);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
