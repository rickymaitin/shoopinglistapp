package com.example.shoppinglistapp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Second extends AppCompatActivity {
    TextView textView2;
    ListView list2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView2=(TextView)findViewById(R.id.textView2);
        list2=(ListView)findViewById(R.id.list2);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            String listname = bundle.getString("name");
            textView2.setText(listname);
            ArrayList arrayList=bundle.getStringArrayList("arraylist");
            if (!arrayList.isEmpty()) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Second.this, android.R.layout.simple_list_item_1, arrayList);
                list2.setAdapter(arrayAdapter);
            }
        }

    }
}