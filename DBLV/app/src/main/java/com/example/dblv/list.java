package com.example.dblv;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        ListView lv = (ListView) findViewById(R.id.lv1);

        ArrayList<String> userDataFromDB = new ArrayList<>();

        DbHelper dbH = new DbHelper(this);

        Cursor data = dbH.getData();

        while(data.moveToNext()){

            userDataFromDB.add(data.getString(1));

        }
        ArrayAdapter lda =  new ArrayAdapter<>(this,R.layout.lv_user,R.id.textView,userDataFromDB);


        lv.setAdapter(lda);

    }

}


