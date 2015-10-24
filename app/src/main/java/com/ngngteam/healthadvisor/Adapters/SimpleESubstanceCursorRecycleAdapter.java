package com.ngngteam.healthadvisor.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ngngteam.healthadvisor.Intefaces.RecycleViewListener;
import com.ngngteam.healthadvisor.R;

/**
 * Created by Nick Zisis on 18-Oct-15.
 */
public class SimpleESubstanceCursorRecycleAdapter extends CursorRecyclerAdapter<SimpleESubstanceViewHolder> {

    private RecycleViewListener listener;
    private Context context;

    public SimpleESubstanceCursorRecycleAdapter(Cursor cursor, RecycleViewListener listener,Context context) {
        super(cursor);
        this.listener=listener;
        this.context=context;
    }



    @Override
    public SimpleESubstanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.esubstances_list_row, parent, false);

        return new SimpleESubstanceViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(SimpleESubstanceViewHolder holder, Cursor cursor) {
        if (cursor.getString(5).contains("0") && !cursor.getString(4).contains("Forbidden")) {
            // good drawable
            holder.iv.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_safe_green));
        } else {
            //bad drawable
            holder.iv.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_dangerous));
        }
        holder.tvName.setText(cursor.getString(1));
        holder.tvDescription.setText(cursor.getString(2));
    }


}


class SimpleESubstanceViewHolder extends RecyclerView.ViewHolder{

    public ImageView iv;
    public TextView tvName, tvDescription;
    public RecycleViewListener listener;

    public SimpleESubstanceViewHolder(View itemView,final RecycleViewListener listener) {
        super(itemView);
        this.listener=listener;

        iv = (ImageView) itemView.findViewById(R.id.iv_esubstances);
        tvName = (TextView) itemView.findViewById(R.id.tv_esubstance_name);
        tvDescription = (TextView) itemView.findViewById(R.id.tv_esubstance_desc);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onViewClicked(getAdapterPosition());
            }
        });

    }
}