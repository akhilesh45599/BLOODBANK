package com.example.nemaliakhilesh.la;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AHN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahn);


        String[] con ={"naveen-9553429380","nikhil-3645789354","nikhilesh-998745612","vamshi-123456798","parshi-9952376066","rahul-99595955959"};
        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,con);
        ListView listView =(ListView)findViewById(R.id.lv2);
        listView.setAdapter(adapter);

    }
}
