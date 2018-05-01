package com.example.nemaliakhilesh.la;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class OrderBlood extends AppCompatActivity {
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_blood);

        final EditText Name = (EditText) findViewById(R.id.name);
        final EditText State = (EditText) findViewById(R.id.state);
        final EditText pincode =(EditText) findViewById(R.id.pincode);
        final Spinner bloodgroup = (Spinner) findViewById(R.id.bg);
        final Button button = (Button) findViewById(R.id.button2);
        final EditText  vd =(EditText)findViewById(R.id.vd);
        final EditText  hno =(EditText)findViewById(R.id.hno);
        final EditText mobile  =(EditText) findViewById(R.id.mobile);

        adapter = ArrayAdapter.createFromResource(this,R.array.bg,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodgroup .setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name = Name.getText().toString();
                final String state =State.getText().toString();
                final int pin =Integer.parseInt(pincode.getText().toString());
                final String bg =bloodgroup.getSelectedItem().toString();
                final String vild= vd.getText().toString();
                final String hono =hno.getText().toString();
                final int mob =  Integer.parseInt(mobile.getText().toString());


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "registration succesful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(OrderBlood.this, Navigation.class);
                                startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(OrderBlood.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                OrderRequest orderrequest = new OrderRequest( name,state,pin, vild, bg, hono,mob, responseListener);
                RequestQueue queue = Volley.newRequestQueue(OrderBlood.this);
                queue.add(orderrequest);


                    }
        });












    }
}
