package com.example.nemaliakhilesh.la;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AH extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ah);

        String[] con ={"charan-9553429323","rahul pola-9952375262","virat-99595955959","ll-13213131","mm-131311231"};
        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,con);
        ListView listView =(ListView)findViewById(R.id.lv1);
        listView.setAdapter(adapter);

    }

}
