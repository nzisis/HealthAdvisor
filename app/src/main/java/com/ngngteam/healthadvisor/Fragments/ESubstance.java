package com.ngngteam.healthadvisor.Fragments;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ngngteam.healthadvisor.Adapters.ESubstanceImageAdapter;
import com.ngngteam.healthadvisor.Adapters.ESubstanceSideEffectAdapter;
import com.ngngteam.healthadvisor.Data.Database;
import com.ngngteam.healthadvisor.Data.ESubstanceItem;
import com.ngngteam.healthadvisor.R;
import com.ngngteam.healthadvisor.Utils.CustomPopUp;
import com.ngngteam.healthadvisor.Utils.ScrollableGridView;


/**
 * Created by Nick Zisis on 18-Oct-15.
 */
public class ESubstance extends Fragment {

//    private Database database;
    private ESubstanceItem item;
    private String[] desc;

    private ESubstanceSideEffectAdapter effectsAdapter;
    private ESubstanceImageAdapter imageAdapter;

    private ScrollableGridView gridView;
    private TextView tvName, tvState, tvCompound, tvAttribute;
    private LinearLayout llsubstance, llSideEffects;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_esubstance, container, false);

        tvName = (TextView) view.findViewById(R.id.tv_esubstance);
        tvState = (TextView) view.findViewById(R.id.tvState);
        tvCompound = (TextView) view.findViewById(R.id.tv_esubstance_compound);
        tvAttribute = (TextView) view.findViewById(R.id.tvAttribute);

        llsubstance = (LinearLayout) view.findViewById(R.id.llesubstance);

        gridView = (ScrollableGridView) view.findViewById(R.id.gvIcons);
        gridView.setExpanded(true);

        llSideEffects = (LinearLayout) view.findViewById(R.id.llSideEffects);


        return view;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initBasicVariables();
        loadUI();
        initListeners();

    }


    private void initBasicVariables() {

//        int id = (int) getActivity().getIntent().getExtras().get("id");
//        database = new Database(getActivity());
//        item = database.getESubstanceItemById(id);

        imageAdapter = new ESubstanceImageAdapter(getActivity());
        imageAdapter.updateIcons(item.getCategories());
        desc = getResources().getStringArray(R.array.popup_desc);
        gridView.setAdapter(imageAdapter);

        effectsAdapter = new ESubstanceSideEffectAdapter(getActivity(), R.layout.list_row_side_effect, item.getSideEffects());
    }

    private void loadUI() {

        tvName.setText(item.getName());
        if (item.getCategories().contains(0)) {
            tvState.setText("Safe");
            tvState.setTextColor(getResources().getColor(R.color.green));
            llsubstance.setBackgroundColor(getResources().getColor(R.color.green));

        } else {
            tvState.setText("Dangerous");
            tvState.setTextColor(getResources().getColor(R.color.red));
            llsubstance.setBackgroundColor(getResources().getColor(R.color.red));
        }
        tvCompound.setText(item.getCompound());
        tvAttribute.setText(item.getAttributes());


        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < item.getSideEffects().size(); i++) {

            View view = inflater.inflate(R.layout.list_row_side_effect, llSideEffects, false);
            TextView tvText = (TextView) view.findViewById(R.id.tv_side_effect);
            tvText.setText(item.getSideEffects().get(i));
            llSideEffects.addView(view);

        }

    }


    private void initListeners() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Toast.makeText(ESubstanceActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                // create window
                CustomPopUp pop = new CustomPopUp(getActivity(), getResources().getInteger(R.integer.popup_width));//specify the window width explicitly

                // set content view
                TextView tv = new TextView(getActivity());
                //tv.setText(item.getSideEffects().get(1));
                tv.setText(desc[position]);
                tv.setPadding(20, 20, 20, 20);
                tv.setTextColor(Color.WHITE);
                pop.setBackgroundDrawable(new ColorDrawable(0xb3111213));
                pop.setContentView(tv);
                // set pointer image
                pop.setPointerImageRes(R.mipmap.ic_popup_pointer);
                // show popup window point to the anchor view
                pop.showAsPointer(v);
                // there are three kinds of built-in align mode are supported:DEFAULT, CENTER_FIX, AUTO_OFFSET
                pop.setAlignMode(CustomPopUp.AlignMode.CENTER_FIX);

                pop.setMarginScreen(50);
            }
        });

    }

    public void initESubstanceItem(ESubstanceItem item){
        this.item= item;
    }


}
