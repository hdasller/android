package com.example.henrique.sqliteex;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by henrique on 16/09/16.
 */
public class UsuarioAdapter extends BaseAdapter{

    private Context context;
    private List<Usuario> list;


    public UsuarioAdapter(Context context, List<Usuario> list){
        Log.i("Script", "Chamou Usuario Adap");

        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0).getId();
    }

    @Override
    public View getView(int position, View arg1, ViewGroup arg2) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.usuario, null);
        Log.i("Script", "Layout Inflado");
        TextView tv = (TextView) layout.findViewById(R.id.nome);
        Log.i("Script", "Inserir tv@" +list.get(position).getNome());
        tv.setText(list.get(position).getNome());
        Log.i("Script", " tv");

        Button editarBt = (Button) layout.findViewById(R.id.btEditar);
        editarBt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, activity_new_user.class);
                intent.putExtra("nome", list.get(auxPosition).getNome());
                intent.putExtra("email", list.get(auxPosition).getEmail());
                intent.putExtra("id", list.get(auxPosition).getId());
                context.startActivity(intent);
            }
        });

        Button deletarBt = (Button) layout.findViewById(R.id.deletar);
        deletarBt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                BD bd = new BD(context);
                bd.deletar(list.get(auxPosition));

                layout.setVisibility(View.GONE);
            }
        });

        return layout;


    }
}
