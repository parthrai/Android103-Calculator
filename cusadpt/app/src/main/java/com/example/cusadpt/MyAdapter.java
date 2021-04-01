package com.example.cusadpt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter {


    ArrayList<Item> animal = new ArrayList<>();

    public MyAdapter(@NonNull Context context, int resource, ArrayList<Item> data) {
        super(context, resource);

        Log.e("hhhhhhh","Const 1111111111");

        animal = data;
    }

    @Override
    public int getCount() {
        Log.e("total",Integer.toString(super.getCount()));

        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_item,null);
        TextView tvname = (TextView) v.findViewById(R.id.textView);
        TextView tvid = (TextView) v.findViewById(R.id.textView2);
        tvname.setText(animal.get(position).getName());
        tvid.setText(animal.get(position).getId());
        Log.e("hhhhhhh","1111111111");
        return v;
    }
}
