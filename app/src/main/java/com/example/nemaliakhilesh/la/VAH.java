package com.example.nemaliakhilesh.la;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class VAH extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vah);


        String[] con ={"mahesh-9553429323","suresh-9952375262","kiran-99595955959","mani-13213131","ratnam-131311231"};
        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,con);
        ListView listView =(ListView)findViewById(R.id.lv5);
        listView.setAdapter(adapter);
    }
}
