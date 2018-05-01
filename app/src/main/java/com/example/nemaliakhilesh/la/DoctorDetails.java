package com.example.nemaliakhilesh.la;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DoctorDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        String[] con ={"charan-9553429323,hyderabad","Mahesh-9952375262,vellore","virat-99595955959,madyapradesh","narayana-13213131,delhi","mm.poorna-131311231,mumbai","Mahesh-9952375262,vellore","virat-99595955959"};
        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,con);
        ListView listView =(ListView)findViewById(R.id.lv15);
        listView.setAdapter(adapter);
    }
}
