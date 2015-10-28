package com.ngngteam.healthadvisor.Adapters;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.github.aakira.expandablelayout.Utils;
import com.ngngteam.healthadvisor.Data.DiseaseItem;
import com.ngngteam.healthadvisor.R;

import java.util.ArrayList;

/**
 * Created by vromia on 10/24/15.
 */
public class DiseaseRecyclerAdapter extends RecyclerView.Adapter<DiseaseRecyclerAdapter.MyViewHolder> {

    private ArrayList<DiseaseItem> items;
    private SparseBooleanArray expandState;
    private Context context;
    private boolean firstTime;

    public DiseaseRecyclerAdapter(ArrayList<DiseaseItem> items) {
        this.items = items;
        expandState = new SparseBooleanArray();
        for (int i = 0; i < items.size(); i++) {
            expandState.append(i, false);
        }
        firstTime = true;
    }


    @Override
    public DiseaseRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.disease_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DiseaseRecyclerAdapter.MyViewHolder holder, final int position) {
        DiseaseItem diseaseItem = items.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        holder.tvTitle.setText(diseaseItem.getSubstance().get(0));
        // holder.tvSubstanceName.setText(diseaseItem.getSubstance().get(0));
        if (diseaseItem.getSubstance().get(1).trim().equals("natural")) {
            holder.tvOrigin.setText("Natural Origin");
            holder.tvOrigin.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.mipmap.ic_nature), null, null, null);
            holder.tvOrigin.setCompoundDrawablePadding(8);
            holder.tvTitle.setBackgroundColor(context.getResources().getColor(R.color.natural));
            holder.buttonLayout.setBackgroundColor(context.getResources().getColor(R.color.natural));
        } else {
            holder.tvOrigin.setText("Chemical Origin");
            holder.tvOrigin.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.mipmap.ic_chemical), null, null, null);
            holder.tvOrigin.setCompoundDrawablePadding(8);
            holder.tvTitle.setBackgroundColor(context.getResources().getColor(R.color.chemical));
            holder.buttonLayout.setBackgroundColor(context.getResources().getColor(R.color.chemical));
        }


        if (firstTime) {


            if (!diseaseItem.getSubstance().get(2).trim().equals("0")) {
                View view = inflater.inflate(R.layout.list_row_side_effect, null, false);
                TextView tvCompound = (TextView) view.findViewById(R.id.tv_side_effect);
                tvCompound.setText("Compound : " + diseaseItem.getSubstance().get(2));
                holder.llGeneral.addView(view);

            }

            if (!diseaseItem.getSubstance().get(3).trim().equals("0")) {

                View view = inflater.inflate(R.layout.list_row_side_effect, null, false);
                TextView tvTradeName = (TextView) view.findViewById(R.id.tv_side_effect);
                tvTradeName.setText("Trade Name : " + diseaseItem.getSubstance().get(3));
                holder.llGeneral.addView(view);

            }


            for (int i = 0; i < diseaseItem.getSources().size(); i++) {


                View view = inflater.inflate(R.layout.list_row_side_effect, null, false);
                TextView tvsource = (TextView) view.findViewById(R.id.tv_side_effect);
                tvsource.setText(diseaseItem.getSources().get(i));
                holder.llSource.addView(view);
            }


            for (int i = 0; i < diseaseItem.getEffects().size(); i++) {

                View view = inflater.inflate(R.layout.list_row_side_effect, null, false);
                TextView tvsource = (TextView) view.findViewById(R.id.tv_side_effect);
                tvsource.setText(diseaseItem.getEffects().get(i));
                holder.llEffects.addView(view);
            }


            for (int i = 0; i < diseaseItem.getSide_effects().size(); i++) {

                View view = inflater.inflate(R.layout.list_row_side_effect, null, false);
                TextView tvsource = (TextView) view.findViewById(R.id.tv_side_effect);
                tvsource.setText(diseaseItem.getSide_effects().get(i));
                holder.llSideEffects.addView(view);
            }

        }


        holder.expandableLayout.setInterpolator(Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR));
        holder.expandableLayout.setExpanded(expandState.get(position));
        holder.expandableLayout.setListener(new ExpandableLayoutListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {

            }

            @Override
            public void onPreOpen() {
                firstTime = false;
                createRotateAnimator(holder.buttonLayout, 0f, 180f).start();
            }

            @Override
            public void onPreClose() {
                createRotateAnimator(holder.buttonLayout, 180f, 0f).start();
            }

            @Override
            public void onOpened() {
                expandState.put(position, true);
            }

            @Override
            public void onClosed() {
                expandState.put(position, false);
            }
        });


        holder.buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(holder.expandableLayout);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    private void onClickButton(final ExpandableLayout expandableLayout) {
        expandableLayout.toggle();
    }


    public ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout llSource, llEffects, llSideEffects, llGeneral;
        public TextView tvOrigin, tvTitle;
        //, tvSubstanceName
        public ExpandableRelativeLayout expandableLayout;
        public RelativeLayout buttonLayout;

        public MyViewHolder(View rootView) {
            super(rootView);

            llSource = (LinearLayout) rootView.findViewById(R.id.llSource);
            llEffects = (LinearLayout) rootView.findViewById(R.id.llEffect);
            llSideEffects = (LinearLayout) rootView.findViewById(R.id.llSideEffect);
            llGeneral = (LinearLayout) rootView.findViewById(R.id.llGeneral);

            tvOrigin = (TextView) rootView.findViewById(R.id.tvOrigin);
            //tvSubstanceName = (TextView) rootView.findViewById(R.id.tvSubstanceName);
            tvTitle = (TextView) rootView.findViewById(R.id.tvHeader);

            expandableLayout = (ExpandableRelativeLayout) rootView.findViewById(R.id.expandableLayout);
            buttonLayout = (RelativeLayout) rootView.findViewById(R.id.button);
        }
    }
}


