package com.ngngteam.healthadvisor.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ngngteam.healthadvisor.R;

import java.util.ArrayList;

/**
 * Created by Nick Zisis on 18-Oct-15.
 */
public class ESubstanceImageAdapter extends BaseAdapter {

    private Context mContext;

    public ESubstanceImageAdapter (Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
//                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.mipmap.ic_safe,
            R.mipmap.ic_genetic,
            R.mipmap.ic_allergy,
            R.mipmap.ic_earth,
            R.mipmap.ic_danger,
            R.mipmap.ic_cancer,
            R.mipmap.ic_animal,
            R.mipmap.ic_headache,
            R.mipmap.ic_heart,
            R.mipmap.ic_suspicious,
            R.mipmap.forbidden,
            R.mipmap.ic_stomach,
            R.mipmap.ic_skin,
    };
    // set by sql category
    private Integer[] mThumbIdsActive = {
            R.mipmap.ic_safe_active,
            R.mipmap.ic_genetic_active,
            R.mipmap.ic_allergy_active,
            R.mipmap.ic_earth_active,
            R.mipmap.ic_danger_active,
            R.mipmap.ic_cancer_active,
            R.mipmap.ic_animal_active,
            R.mipmap.ic_headache_active,
            R.mipmap.ic_heart_active,
            R.mipmap.ic_suspicious_active,
            R.mipmap.forbidden_active,
            R.mipmap.ic_stomach_active,
            R.mipmap.ic_skin_active,

    };


    public void updateIcons(ArrayList<Integer> intArray) {
        for (int i : intArray) {
            mThumbIds[i] = mThumbIdsActive[i];
        }
    }



}
