package com.ngngteam.healthadvisor.Data;

import java.util.ArrayList;

/**
 * Created by Vromia on 11/3/2015.
 */
public class ESubstanceItem {

    private int id;
    private String name;
    private String compound;
    private String attributes;
    private ArrayList<String> sideEffects;
    private ArrayList<Integer> categories;

    public ESubstanceItem(String name,String compound,String attributes){

        this.name=name;
        this.compound=compound;
        this.attributes=attributes;
        sideEffects=new ArrayList<>();
        categories=new ArrayList<>();

    }

    public void setId(int id){
        this.id=id;

    }

    public void addSideEffect(String sideEffect){
        sideEffects.add(sideEffect);
    }

    public void addCategory(int category){
        categories.add(category);
    }

    public String getName(){
        return name;
    }

    public String getCompound(){
        return compound;
    }

    public String getAttributes(){
        return attributes;
    }

    public ArrayList<String> getSideEffects(){
        return sideEffects;
    }

    public ArrayList<Integer> getCategories(){
        return categories;
    }


}
