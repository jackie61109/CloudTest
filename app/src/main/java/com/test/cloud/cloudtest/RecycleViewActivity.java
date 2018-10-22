package com.test.cloud.cloudtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.cloud.cloudtest.model.CloudListItem;

public class RecycleViewActivity extends AppCompatActivity {

    private static final String LIST_ITEM = "list_item";

    public static void start(Context mContext, CloudListItem item) {
        Intent intent = new Intent(mContext, RecycleViewActivity.class);
        intent.putExtra(LIST_ITEM, item);
        mContext.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        CloudListItem item = (CloudListItem) getIntent().getSerializableExtra(LIST_ITEM);
    }
}
