package com.ngngteam.healthadvisor.Adapters;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Nick Zisis on 15-Oct-15.
 */
public abstract class CursorRecyclerAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected Cursor cursor;
    protected boolean dataValid;


    public CursorRecyclerAdapter(Cursor cursor){
        this.cursor=cursor;
        dataValid= cursor!=null;
    }


    @Override
    public final void onBindViewHolder (VH holder, int position) {
        if (!dataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!cursor.moveToPosition(position)) {
            throw new IllegalStateException("couldn't move cursor to position " + position);
        }

        onBindViewHolder(holder, cursor);
    }

    public abstract void onBindViewHolder(VH holder, Cursor cursor);

    public Cursor getCursor() {
        return cursor;
    }


    @Override
    public int getItemCount() {
        if (dataValid && cursor != null) {
            return cursor.getCount();
        } else {
            return 0;
        }
    }

    @Override
    public long getItemId(int position) {
        if(dataValid && cursor != null){
            if(cursor.moveToPosition(position)){
                return cursor.getLong(0);
            }else {
                return RecyclerView.NO_ID;
            }
        }else {
            return RecyclerView.NO_ID;
        }
    }

    /**
     * Change the underlying cursor to a new cursor. If there is an existing cursor it will be
     * closed.
     *
     * @param newCursor The new cursor to be used
     */
    public void changeCursor(Cursor newCursor){

        Cursor old=swapCursor(newCursor);
        if(old !=null){
            old.close();
        }


    }

    /**
     * Swap in a new Cursor, returning the old Cursor.  Unlike
     * changeCursor(Cursor), the returned old Cursor is not
     * closed.
     *
     * @param newCursor The new cursor to be used.
     * @return Returns the previously set Cursor, or null if there wasa not one.
     * If the given new Cursor is the same instance is the previously set
     * Cursor, null is also returned.
     */
    public Cursor swapCursor(Cursor newCursor){


        if (newCursor == cursor) {
            return null;
        }
        Cursor oldCursor = cursor;
        cursor = newCursor;
        if (newCursor != null) {
            dataValid = true;
            // notify the observers about the new cursor
            notifyDataSetChanged();
        } else {
            dataValid = false;
            // notify the observers about the lack of a data set
            notifyItemRangeRemoved(0, getItemCount());
        }
        return oldCursor;
    }


}
