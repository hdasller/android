package com.example.henrique.sqliteex;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class activity_list_users extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_activity_list_users);

        Log.i("Script", "Iniciou activity");

        BD bd = new BD(this);

        List<Usuario> list = bd.buscar();
        Log.i("Script", "BD Chamado");
        setListAdapter(new UsuarioAdapter(this,list));

    }
}
