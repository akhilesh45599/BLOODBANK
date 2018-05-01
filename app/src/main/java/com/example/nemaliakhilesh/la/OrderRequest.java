package com.example.nemaliakhilesh.la;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NEMALI AKHILESH on 4/4/2018.
 */

public class OrderRequest extends StringRequest {
    private static final String ORDER_REQUEST_URL = "http://saveblood.000webhostapp.com/ak.php";
    private Map<String, String> params;

    public OrderRequest( String name, String state , int pin,String vild, String bg,String hono,int mob, Response.Listener<String> listener) {
        super(Method.POST, ORDER_REQUEST_URL, listener, null);
        params = new HashMap<>();

        params.put("name", name);
        params.put("state", state);
        params.put("pin", pin + "");
        params.put("vild", vild);
        params.put("bg", bg);
        params.put("hono", hono);
        params.put("mob", mob + "");





    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
