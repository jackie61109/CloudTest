package com.test.cloud.cloudtest.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.test.cloud.cloudtest.R;
import com.test.cloud.cloudtest.connection.ImageDownload;
import com.test.cloud.cloudtest.model.CloudItems;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private ArrayList<CloudItems> mItems;
    private Context mContext;

    public RecycleViewAdapter(Context mContext) {
        this.mContext = mContext;
        mItems = new ArrayList<>();
    }

    public void resetData(ArrayList<CloudItems> infoItems) {
        if (infoItems != null) {
            mItems.clear();
            mItems.addAll(infoItems);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_recycleview,
                        viewGroup,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.setupUIData(mContext, mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements Handler.Callback {

        private TextView txtId;
        private TextView txtTitle;
        private RelativeLayout image;
        private Handler handler;
        private Context mContext;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtId = itemView.findViewById(R.id.txt_id);
            txtTitle = itemView.findViewById(R.id.txt_title);
            image = itemView.findViewById(R.id.rel_image);

            handler = new Handler(this);
        }

        private void setupUIData(Context mContext, CloudItems item) {
            this.mContext = mContext;
            txtId.setText(item.getId());
            txtTitle.setText(item.getTitle());
            // image download .....
            new ImageDownload(handler).execute(item.getThumbnailUrl());
        }

        @Override
        public boolean handleMessage(Message msg) {
            Bitmap bitmap = (Bitmap) msg.obj;
            image.setBackground(new BitmapDrawable(mContext.getResources(), bitmap));
            return false;
        }
    }
}
