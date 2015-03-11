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

/**
 * Created by Vromia on 28/2/2015.
 */
public class Database extends SQLiteOpenHelper {


    private final static int DB_VERSION = 1;
    private final static String DB_NAME = "database.db";
    private Context context;


    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        // Store the context for later use
        this.context = context;
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
       return getReadableDatabase().rawQuery("SELECT * "+ " FROM "+ "esubstances",null);
    }

    public Cursor getAllEsubstancesDependOnNumber(int number){

        return getReadableDatabase().rawQuery("SELECT * " + " FROM "+ "esubstances "+" WHERE name LIKE 'E"+number+"%'",null);


    }



}
