package com.test.cloud.cloudtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.test.cloud.cloudtest.connection.VolleyConnection;
import com.test.cloud.cloudtest.model.CloudItems;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String CLOUD_URL = "https://my-json-server.typicode.com/jackie61109/CloudTest/items";
    private ArrayList<CloudItems> items = new ArrayList<>();
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonCloud);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"連線中...",Toast.LENGTH_SHORT).show();
        requestQueue = CloudApplication.getRequestQueue();
        requestQueue.add(new VolleyConnection().connectByGet(CLOUD_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                //String s即为服务器返回的数据
                Toast.makeText(MainActivity.this,"連線成功",Toast.LENGTH_SHORT).show();
                Log.d("CLOUD ", s);
                RecycleViewActivity.start(MainActivity.this,null);

            }
        }, null));
    }
}
