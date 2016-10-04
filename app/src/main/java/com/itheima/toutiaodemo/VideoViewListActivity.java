package com.itheima.toutiaodemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.VideoView;

/**
 * 创建者: Leon
 * 创建时间: 2016/10/4 8:58
 * 描述： TODO
 */
public class VideoViewListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(mListAdapter);
    }

    private BaseAdapter mListAdapter = new BaseAdapter() {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(VideoViewListActivity.this).inflate(R.layout.video_view_list_item, parent, false);
            }
            if (position == 0) {
                VideoView videoView = (VideoView)convertView;
                videoView.setVideoPath(Constant.url);
                videoView.start();
            }
            return convertView;
        }
    };

}
