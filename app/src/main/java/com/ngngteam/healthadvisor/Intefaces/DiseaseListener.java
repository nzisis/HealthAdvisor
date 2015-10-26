package com.ngngteam.healthadvisor.Intefaces;

import com.ngngteam.healthadvisor.Data.DiseaseItem;

import java.util.ArrayList;

/**
 * Created by Nick Zisis on 10/24/15.
 */
public interface DiseaseListener {
    void onDiseaseSelected(ArrayList<DiseaseItem> items);
}
