package com.example.henrique.sqliteex;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getActivity(View view){
        Button bt = (Button) view;
        Intent intent;

        if(bt.getText().toString().equalsIgnoreCase("Novo Usuário")){
            intent = new Intent(this, activity_new_user.class);
        }
        else{
            intent = new Intent(this, activity_list_users.class);
            Log.i("Script", "Chamou Activity");
        }

        startActivity(intent);
    }

}
