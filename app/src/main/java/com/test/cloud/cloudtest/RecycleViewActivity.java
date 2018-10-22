package com.test.cloud.cloudtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.test.cloud.cloudtest.adapter.RecycleViewAdapter;
import com.test.cloud.cloudtest.model.CloudListItem;

public class RecycleViewActivity extends AppCompatActivity {

    private static final String LIST_ITEM = "list_item";

    public static void start(Context mContext, CloudListItem item) {
        Intent intent = new Intent(mContext, RecycleViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(LIST_ITEM, item);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        CloudListItem item = (CloudListItem) getIntent().getExtras().getSerializable(LIST_ITEM);

        RecyclerView mRecyclerView = findViewById(R.id.recycleView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.setLayoutManager(new
                StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));

        RecycleViewAdapter adapter = new RecycleViewAdapter(this);
        mRecyclerView.setAdapter(adapter);


        if (item != null) {
            adapter.resetData(item.getItems());
        }


    }
}
