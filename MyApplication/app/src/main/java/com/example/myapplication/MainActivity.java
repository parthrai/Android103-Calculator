package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View v){

        int id = v.getId();

        String ourId = "";

        ourId = v.getResources().getResourceEntryName(id);

        ImageView img  = (ImageView) findViewById(R.id.imageView);

        int rID = getResources().getIdentifier(ourId, "drawable","com.example.myapplication");



        img.setImageResource(R.drawable.robot);

        img.animate().alpha(0.6F).setDuration(2000);



        Log.i("BTN","CLICKED   - "+ ourId );


    }
}
