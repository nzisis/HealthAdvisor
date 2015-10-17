package com.ngngteam.healthadvisor.Model;

import com.ngngteam.healthadvisor.Fragments.CategoryView;

import java.io.Serializable;

/**
 * Created by Nick Zisis on 17-Oct-15.
 */
public class CategoryViewModel implements Serializable {

    private boolean isHeader;
    private String title;
    private String context;
    private int groupPosition;
    private int childPosition;


    public CategoryViewModel(String title, int groupPosition) {
        this.isHeader = true;
        this.title = title;
        this.groupPosition = groupPosition;
    }

    public CategoryViewModel(String context,int groupPosition,int childPosition){
        this.isHeader = false;
        this.context=context;
        this.groupPosition=groupPosition;
        this.childPosition=childPosition;


    }


    public void setHeader(boolean isHeader) {
        this.isHeader = isHeader;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setGroupPosition(int groupPosition) {
        this.groupPosition = groupPosition;
    }

    public void setChildPosition(int childPosition) {
        this.childPosition = childPosition;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    public int getGroupPosition(){
        return groupPosition;
    }

    public int getChildPosition(){
        return childPosition;
    }


}
