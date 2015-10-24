package com.ngngteam.healthadvisor.Adapters;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ngngteam.healthadvisor.Intefaces.RecycleViewListener;
import com.ngngteam.healthadvisor.R;

/**
 * Created by Nick Zisis on 15-Oct-15.
 */
public class SimpleDiseaseCursorRecycleAdapter extends CursorRecyclerAdapter<SimpleDiseaseViewHolder> {


    private RecycleViewListener listener;


    public SimpleDiseaseCursorRecycleAdapter(Cursor c, RecycleViewListener listener) {
        super(c);
        this.listener=listener;
    }


    @Override
    public SimpleDiseaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.disease_list_row, parent, false);

        return new SimpleDiseaseViewHolder(view,listener);
    }


    @Override
    public void onBindViewHolder(SimpleDiseaseViewHolder holder, Cursor cursor) {
        holder.tvName.setText(cursor.getString(1));
    }




}


class SimpleDiseaseViewHolder extends RecyclerView.ViewHolder  {

    public TextView tvName;
    public RecycleViewListener listener;


    public SimpleDiseaseViewHolder(View itemView, final RecycleViewListener listener) {
        super(itemView);
        this.listener=listener;
        tvName = (TextView) itemView.findViewById(R.id.tvName);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onViewClicked(getAdapterPosition());
            }
        });
    }




}