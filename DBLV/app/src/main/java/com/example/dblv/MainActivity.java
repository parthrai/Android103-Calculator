package com.example.dblv;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar ab = getSupportActionBar();
        ab.setTitle("Welcome");
        ab.setSubtitle("Chooooot");


        RequestQueue data = Volley.newRequestQueue(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int clicked = item.getItemId();

        if(clicked == R.id.refresh){
            Toast.makeText(this,"Refresh",Toast.LENGTH_LONG).show();
        }
        if(clicked == R.id.copy){
            Toast.makeText(this,"copy",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void change(View v){

//        android.support.v4.app.Fragment fr ;
//        fr= new BlankFragment2();
//
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        ft.replace(R.id.fragment,fr);

        Log.i("HHH$$$$$$$$$$$","$##$%$%##%#$%#$%#%");

        Fragment fr ;
        fr = new BlankFragment2();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment,fr);

        Log.i("HHH$$$$$$$$$$$","$##$%$%##%#$%#$%#%");

        ft.commit();





    }


    public void jsonData(View view){

        final TextView tv = (TextView) findViewById(R.id.json);

        String url = "https://api.myjson.com/bins/kp9wz";

        Log.d("Name ------", "1");

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try{
                    JSONArray jsonarray = response.getJSONArray("employees");
                    Log.d("Name ------", "2");


                    for(int i=0 ; i< jsonarray.length();i++){
                        JSONObject employee = jsonarray.getJSONObject(i);

                        String fristName = employee.getString("firstname");
                        int age = employee.getInt("age");

                        Log.d("Name ------", fristName);
                        tv.append(fristName + ' ' + String.valueOf(age) );
                    }
                }
                catch(JSONException ex){

                    Log.d("Name ------", "3");

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                Log.d("ERROR",error.toString());
            }
        });
    }



  public void Volly(View v){

      final TextView tv = (TextView) findViewById(R.id.json);

      String url = "http://www.mocky.io/v2/5e866d283100006a00813a58";

      RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
      try {
          JSONObject object = new JSONObject();
          final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
              @Override
              public void onResponse(JSONObject response) {
                // tv.setText("Resposne : " + response.toString());

                 try{
                     JSONArray jsonarray = response.getJSONArray("users");

                     for(int i=0 ; i< jsonarray.length();i++){
                         JSONObject employee = jsonarray.getJSONObject(i);

                         String fristName = employee.getString("name");

                         tv.append(fristName  );
                     }

                 }catch (JSONException ex){


                 }


              }
          }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {

                  Log.e("error",error.toString());

                  Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
              }
          });
          requestQueue.add(jsonObjectRequest);
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

    public void change2(View v){

//        android.support.v4.app.Fragment fr ;
//        fr= new BlankFragment2();
//
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        ft.replace(R.id.fragment,fr);


        Fragment fr ;
        fr = new BlankFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment,fr);
        ft.commit();

    }

    public void AddData(View v) {

       DbHelper mydb = new DbHelper(this);

        boolean result = mydb.addData("John Doeeeee");

        if(result==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }

    public void list(View v){

        Intent i = new Intent(MainActivity.this,list.class);
        startActivity(i);
    }
}
