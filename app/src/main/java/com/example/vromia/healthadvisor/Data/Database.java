package com.example.vromia.healthadvisor.Data;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vromia on 28/2/2015.
 */
public class Database extends SQLiteOpenHelper {


    private final static int DB_VERSION = 1;
    private final static String DB_NAME = "database.db";
    private Context context;
    private HashMap<Integer,String> categories;


    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        // Store the context for later use
        this.context = context;
        initCategories();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        executeSQLScript(db, "create.sql");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void executeSQLScript(SQLiteDatabase database, String dbname) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte buf[] = new byte[1024];
        int len;
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = null;

        try {
            inputStream = assetManager.open(dbname);
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();

            String[] createScript = outputStream.toString().split(";");
            for (int i = 0; i < createScript.length; i++) {
                String sqlStatement = createScript[i].trim();
                // TODO You may want to parse out comments here
                if (sqlStatement.length() > 0) {
                    database.execSQL(sqlStatement + ";");
                }
            }
        } catch (IOException e) {
            // TODO Handle Script Failed to Load
        } //catch (SQLException e) {
//            // TODO Handle Script Failed to Execute
//        }
    }

    private void initCategories(){
        categories=new HashMap<>();
        categories.put(0,"Respiratory Disorders");
        categories.put(1,"Skin Disorders");
        categories.put(2,"Stomach Disorders");
        categories.put(3,"Pain");
        categories.put(4,"High Fever");
    }


   public void showTuples(){

       Cursor c=getReadableDatabase().rawQuery("SELECT * "+ " FROM "+ "diseases",null);
       if(c!=null){

           for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){

               String name=c.getString(1);
               String substence=c.getString(2);
               String source=c.getString(3);
               String effect=c.getString(4);
               String side_effect=c.getString(5);
               Log.i("tuple",name+" "+substence+ " "+ source +" "+source +" "+effect +" "+side_effect);

           }

       }

   }


    public Cursor getAllESubstances(){
        return getReadableDatabase().rawQuery("SELECT * "+ " FROM "+ "esubstances ORDER BY name",null);
    }

    public Cursor getAllEsubstancesDependOnNumber(String number){

        return getReadableDatabase().rawQuery("SELECT * " + " FROM "+ "esubstances "+" WHERE name LIKE 'E" + number + "%'",null);


    }

    public ESubstanceItem getESubstanceItemById(int id){

        Cursor c=getReadableDatabase().rawQuery("SELECT * FROM esubstances WHERE _id = "+id,null);
        ESubstanceItem item=null;

        if(c!=null){
            c.moveToFirst();

            String name=c.getString(1);
            String compound=c.getString(2);
            String attributes=c.getString(3);
            String sideEffects=c.getString(4);
            String categories=c.getString(5);

            item=new ESubstanceItem(name,compound,attributes);
            item.setId(Integer.parseInt(c.getString(0)));

            String sideEffectsElements[]=sideEffects.split("-");
            for(int i=0; i<sideEffectsElements.length; i++){
                item.addSideEffect(sideEffectsElements[i]);
            }

            String categoriesElements[]=categories.split("-");
            for(int i=0; i<categoriesElements.length; i++){
                int cat=Integer.parseInt(categoriesElements[i]);
                item.addCategory(cat);
            }

        }

        return item;
    }


    public Cursor getAllDiseases(){
        return getReadableDatabase().rawQuery("SELECT * FROM diseases GROUP BY name",null);
    }

    public Cursor getAllDiseasesDependOnName(String name){
        return getReadableDatabase().rawQuery("SELECT * " + " FROM "+ "diseases "+" WHERE name LIKE '%" + name + "%'" + " GROUP BY name" ,null);
    }


    public ArrayList<DiseaseItem> getDiseaseBasedOnName(String name){

        Cursor c=getReadableDatabase().rawQuery("SELECT * FROM diseases WHERE name = '"+name+"'",null);
        ArrayList<DiseaseItem> diseaseItems=new ArrayList<>();

        if(c!=null){

          for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){

              String nameOfDisease=c.getString(1);
              String substance=c.getString(2);
              String sources=c.getString(3);
              String effects=c.getString(4);
              String side_effects=c.getString(5);
              String categories=c.getString(6);

              DiseaseItem item=new DiseaseItem(nameOfDisease);
              item.setId(Integer.parseInt(c.getString(0)));

              String nameElements[]=substance.split("-");

              for(int i=0; i<nameElements.length; i++){
                  Log.i("test" , "added" + nameElements[i]);
                  item.addSubstance(nameElements[i]);
              }

              String sourcesElements[]=sources.split("-");
              for(int i=0; i<sourcesElements.length; i++){
                  item.addSource(sourcesElements[i]);
              }

              String effectsElements[]=effects.split("-");
              for(int i=0; i<effectsElements.length; i++){
                  item.addEffect(effectsElements[i]);
              }

              String side_effectsElements[]=side_effects.split("-");
              for(int i=0; i<side_effectsElements.length; i++){
                  item.addSideEffect(side_effectsElements[i]);
              }

              String categoriesElements[]=categories.split("-");
              for(int i=0; i<categoriesElements.length; i++){
                  item.addCategory(Integer.parseInt(categoriesElements[i]));
              }
              
              diseaseItems.add(item);



          }

        }

        return diseaseItems;
    }


    public ArrayList<String> getAllCategories(){
        ArrayList<String> categoriesNames=new ArrayList<>();

        for(int i=0; i<categories.size(); i++){
            categoriesNames.add(categories.get(i));
        }

        return categoriesNames;

    }


    public ArrayList<String> getAllDiseasesBasedOnCategories(String nameOfCategory){

        ArrayList<String > diseases=new ArrayList<>();
        int numberOfCategory=-1;
       for(Map.Entry<Integer,String> entry:categories.entrySet()){
           if(nameOfCategory.equals(entry.getValue())){
               numberOfCategory=entry.getKey();
           }
       }

        Cursor c=this.getAllDiseases();
        if(c!=null){

            for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){

               String allCategories=c.getString(6);
               if(allCategories.contains(numberOfCategory+"")){
                   diseases.add(c.getString(1));
               }

            }

        }
        return diseases;

    }



}
