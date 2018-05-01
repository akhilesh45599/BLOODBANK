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

public class DonotRegistration extends AppCompatActivity {
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donot_registration);


        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final EditText etmail = (EditText) findViewById(R.id.etmail);
        final EditText etUsername =(EditText) findViewById(R.id.etusername);
        final EditText etPassword = (EditText) findViewById(R.id.etpassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);
        final EditText etmobile  =(EditText)findViewById(R.id.etmobile);
        final Spinner bg =(Spinner)findViewById(R.id.spinner);
        final Spinner gende =(Spinner)findViewById(R.id.spinner2);

        adapter = ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gende .setAdapter(adapter);
        adapter =ArrayAdapter.createFromResource(this,R.array.bg,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bg .setAdapter(adapter);


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etmail.getText().toString();
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final int age = Integer.parseInt(etAge.getText().toString());
                final int mobile =Integer.parseInt(etmobile.getText().toString());
                final String bloodg = bg.getSelectedItem().toString();
                final String gender =gende.getSelectedItem().toString();





                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(),"registration succesful",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(DonotRegistration.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(DonotRegistration.this);
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

                donorrequest donorrequest = new donorrequest( username, password,age, email,mobile, bloodg, gender, responseListener);
                RequestQueue queue = Volley.newRequestQueue(DonotRegistration.this);
                queue.add(donorrequest);
            }
        });
    }
}
