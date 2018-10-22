package com.test.cloud.cloudtest;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

public class CloudApplication extends Application {

    private static RequestQueue requestQueue;


    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        VolleyLog.setTag("Cloud - [Volley]");
    }
}
