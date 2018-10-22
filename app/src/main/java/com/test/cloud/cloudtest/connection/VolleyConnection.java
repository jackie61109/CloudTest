package com.test.cloud.cloudtest.connection;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class VolleyConnection {

    public StringRequest connectByGet(String url,
                                       Response.Listener<String> listener,
                                       Response.ErrorListener errorListener) {

        return new StringRequest(Request.Method.GET, url, listener, errorListener);
    }
}
