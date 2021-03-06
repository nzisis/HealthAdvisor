package com.ngngteam.healthadvisor.Data;

import java.util.ArrayList;

/**
 * Created by Nick Zisis on 15/3/2015.
 */
public class DiseaseItem {

    private int id;
    private String name;
    private ArrayList<String> substance;
    private ArrayList<String> sources;
    private ArrayList<Integer> categories;
    private ArrayList<String> effects;
    private ArrayList<String> side_effects;

    public DiseaseItem(String name){
        this.name = name;
        this.substance = new ArrayList<>();
        sources=new ArrayList<>();
        categories=new ArrayList<>();
        effects=new ArrayList<>();
        side_effects=new ArrayList<>();

    }

    public void setId(int id){
        this.id=id;
    }


    public void addSource(String source){
        sources.add(source);
    }

    public void addCategory(int category){
        categories.add(category);
    }

    public void addEffect(String effect){
        effects.add(effect);
    }

    public void addSideEffect(String side_effect){
        side_effects.add(side_effect);
    }

    public String getName(){
        return name;
    }

    public ArrayList<String> getSubstance(){
        return substance;
    }

    public ArrayList<String> getSources(){
        return sources;
    }

    public ArrayList<String> getEffects(){
        return effects;
    }

    public ArrayList<String> getSide_effects(){
        return side_effects;
    }

    public ArrayList<Integer> getCategories(){
        return categories;
    }

    public void setName(String s){
        name = s;
    }
    public void addSubstance(String s){
        substance.add(s);
    }

    public int getId(){
        return id;
    }

}
