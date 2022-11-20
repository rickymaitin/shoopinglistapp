package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {
    EditText editText ;
    Button button,button2;
    ListView listView;
    ArrayList arrayList,selectlist;
    String listname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        listView=(ListView)findViewById(R.id.list);
        selectlist=new ArrayList();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listname=editText.getText().toString();
                if (listname.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter list name..", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    arrayList = new ArrayList<>();
                    arrayList.add("Apple");
                    arrayList.add("bread");
                    arrayList.add("Corn");
                    arrayList.add("Rice");
                    arrayList.add("Chicken");
                    arrayList.add("Mango");
                    arrayList.add("Eggs");
                    arrayList.add("White bread");
                    arrayList.add("Brown bread");
                    arrayList.add("Pasta");


                    ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, simple_list_item_1,arrayList);
                    listView.setAdapter(arrayAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String clickedItem=(String) listView.getItemAtPosition(position);
                            selectlist.add(clickedItem);
                            Toast.makeText(MainActivity.this,clickedItem +" Selected",Toast.LENGTH_LONG).show();

                        }
                    });



                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putStringArrayList("arraylist",selectlist);
                bundle.putString("name",listname);

                Intent i=new Intent(MainActivity.this,Second.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });









    }
}