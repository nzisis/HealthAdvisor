package com.ngngteam.healthadvisor.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ngngteam.healthadvisor.R;

import java.util.ArrayList;

/**
 * Created by Nick on 18-Oct-15.
 */
public class ESubstanceSideEffectAdapter extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<String> items;

    public ESubstanceSideEffectAdapter(Context context, int resource, ArrayList items) {
        super(context, resource, items);
        this.context = context;
        this.resource = resource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
        }
        TextView tvText = (TextView) convertView.findViewById(R.id.tv_side_effect);
        tvText.setText(items.get(position));


        return convertView;
    }


}
