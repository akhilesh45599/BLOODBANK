package com.example.nemaliakhilesh.la;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NEMALI AKHILESH on 4/5/2018.
 */

public class donorrequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://saveblood.000webhostapp.com/akhil.php";
    private Map<String, String> params;

    public donorrequest( String username ,  String password,int age ,String email,int mobile,String bloodg,String gender, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();

        params.put("username", username);
        params.put("password", password);
        params.put("age", age + "");
        params.put("email", email);
        params.put("mobile", mobile + "");
        params.put("bloodg", bloodg);
        params.put("gender", gender);





    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
