package com.test.cloud.cloudtest.connection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.net.URL;

public class ImageDownload extends AsyncTask<String, Integer, Bitmap> {

    private Handler mHandler;

    public ImageDownload(Handler handler) {
        mHandler = handler;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            String urlStr = strings[0];
            URL url = new URL(urlStr);
            return BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {

        if (mHandler != null) {
            Message message = mHandler.obtainMessage(0);
            message.obj = bitmap;
            mHandler.sendMessage(message);
        }
    }


}
