package com.example.cusadpt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Integer> ids = new ArrayList<>();

    public CustomAdapter(Context appContext, ArrayList<String> rName, ArrayList<Integer> rId) {

        this.names = rName;
        this.ids = rId;
        this.context = appContext;
        this.inflater = inflater.from(appContext);

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.from(context).inflate(R.layout.hone, null);
        TextView name = (TextView) view.findViewById(R.id.textView);
       // TextView desc = (TextView) view.findViewById(R.id.textView2);



        name.setText(names.get(i));
       // desc.setText(ids.get(i));


        return view;    }
}
