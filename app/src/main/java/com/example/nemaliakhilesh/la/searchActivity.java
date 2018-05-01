package com.example.nemaliakhilesh.la;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class searchActivity extends AppCompatActivity {
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        final Spinner bg=(Spinner)findViewById(R.id.spinner3);
        final Spinner locality=(Spinner)findViewById(R.id.spinner4);
        final Button search =(Button)findViewById(R.id.button);
        adapter = ArrayAdapter.createFromResource(this,R.array.bg,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bg .setAdapter(adapter);
        adapter =ArrayAdapter.createFromResource(this,R.array.locality,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locality .setAdapter(adapter);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String bloodg =bg.getSelectedItem().toString();
                final String Locality =locality.getSelectedItem().toString();

                if(Locality.equals("Hyderabad"))
                {
                    if(bloodg.equals("A+")) {
                        Intent intent = new Intent(searchActivity.this, AH.class);
                        startActivity(intent);
                    }
                    if(bloodg.equals("A-"))
                    {
                        Intent intent = new Intent(searchActivity.this, AHN.class);
                        startActivity(intent);
                    }
                    if(bloodg.equals("O+"))
                    {
                        Intent intent = new Intent(searchActivity.this, OH.class);
                        startActivity(intent);
                    }
                    if(bloodg.equals("O-")){
                        Intent intent = new Intent(searchActivity.this, OHN.class);
                        startActivity(intent);
                    }
                }
                if(Locality.equals("Vellore")) {
                    if (bloodg.equals("A+")) {
                        Intent intent = new Intent(searchActivity.this, VAH.class);
                        startActivity(intent);
                    }
                    if (bloodg.equals("A-")) {
                        Intent intent = new Intent(searchActivity.this, VAHN.class);
                        startActivity(intent);
                    }
                    if (bloodg.equals("O+")) {
                        Intent intent = new Intent(searchActivity.this, VOH.class);
                        startActivity(intent);
                    }
                    if (bloodg.equals("O-")) {
                        Intent intent = new Intent(searchActivity.this, VOHN.class);
                        startActivity(intent);
                    }
                }



            }
        });



    }
}
