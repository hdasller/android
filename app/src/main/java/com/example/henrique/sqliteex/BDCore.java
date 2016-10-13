package com.example.henrique.sqliteex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by henrique on 17/09/16.
 */
public class BDCore extends SQLiteOpenHelper{

    private static final String NOME_BD = "teste";
    private static final int VERSAO_BD = 7;


    public BDCore (Context ctx){
        super(ctx, NOME_BD, null, VERSAO_BD);

        Log.i("Script", "BD Core OK");
    }
    @Override
    public void onCreate (SQLiteDatabase bd){
        Log.i("Script", "Antes criar TB");
        bd.execSQL("create table usuario(_id integer primary key autoincrement, nome text not null, email text not null, senha text not null);");

    }
    @Override
    public void onUpgrade (SQLiteDatabase bd, int arg1, int arg2){
    bd.execSQL("drop table usuario;");
        onCreate(bd);

    }


}
