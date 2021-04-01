package com.example.cusadpt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView simpleList;
    ArrayList<Item> animalList = new ArrayList<>();
    final ArrayList<String> userDataFromDBname = new ArrayList<>();
    final ArrayList<Integer> userDataFromDBId = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("hhhhhhh","Main Ac 1111111111");

        simpleList = (ListView)findViewById(R.id.listv);

        userDataFromDBname.add("John");
        userDataFromDBId.add(5);userDataFromDBname.add("John");
        userDataFromDBId.add(5);userDataFromDBname.add("John");
        userDataFromDBId.add(5);userDataFromDBname.add("John");
        userDataFromDBId.add(5);userDataFromDBname.add("John");
        userDataFromDBId.add(5);userDataFromDBname.add("John");
        userDataFromDBId.add(5);userDataFromDBname.add("John");
        userDataFromDBId.add(5);


        Log.e("hhhhhhh SIZE",Integer.toString(userDataFromDBId.size()));

        CustomAdapter cus = new CustomAdapter(this,userDataFromDBname,userDataFromDBId);
        simpleList.setAdapter(cus);
    }


    public void load(View v){

        CustomAdapter cus = new CustomAdapter(this,userDataFromDBname,userDataFromDBId);
        simpleList.setAdapter(cus);

    }
}
