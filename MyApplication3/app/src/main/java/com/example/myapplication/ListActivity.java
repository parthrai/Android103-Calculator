package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        final ArrayList<String> userDataFromDBname = new ArrayList<>();
        final ArrayList<String> userDataFromDBdescription = new ArrayList<>();
        final ArrayList<Integer> userDataFromDBId = new ArrayList<>();


        DbHelper dbh = new DbHelper(this);
        Cursor data = dbh.getData();

        while (data.moveToNext()) {
            userDataFromDBname.add(data.getString(1));
            userDataFromDBdescription.add(data.getString(2));
            userDataFromDBId.add(data.getInt(0));
        }

        // CustomAdapter ca = new CustomAdapter(this.getContext(), names, description);
        CustomAdapter ca = new CustomAdapter(this, userDataFromDBname, userDataFromDBdescription);

        ListView lt = (ListView) findViewById(R.id.lvViews);

        lt.setAdapter(ca);


    }
}
