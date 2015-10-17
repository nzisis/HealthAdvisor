package com.ngngteam.healthadvisor.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ngngteam.healthadvisor.R;

/**
 * Created by Nick Zisis on 15-Oct-15.
 */
public class SimpleCursorRecycleAdapter extends CursorRecyclerAdapter<SimpleViewHolder> {


    private RecycleViewListener listener;


    public SimpleCursorRecycleAdapter(Cursor c,RecycleViewListener listener) {
        super(c);
        this.listener=listener;
    }


    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.disease_list_row, parent, false);

        return new SimpleViewHolder(view,listener);
    }


    @Override
    public void onBindViewHolder(SimpleViewHolder holder, Cursor cursor) {
        holder.tvName.setText(cursor.getString(1));
    }


    public interface RecycleViewListener{
        void onViewClicked(int position);
    }


}


class SimpleViewHolder extends RecyclerView.ViewHolder  {

    public TextView tvName;
    public SimpleCursorRecycleAdapter.RecycleViewListener listener;


    public SimpleViewHolder(View itemView, final SimpleCursorRecycleAdapter.RecycleViewListener listener) {
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