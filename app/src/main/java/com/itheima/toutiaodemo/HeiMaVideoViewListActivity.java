package com.itheima.toutiaodemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 创建者: Leon
 * 创建时间: 2016/10/4 8:58
 * 描述： TODO
 */
public class HeiMaVideoViewListActivity extends ListActivity {

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
                VideoListItemView videoListItemView = new VideoListItemView(HeiMaVideoViewListActivity.this);
                videoListItemView.setVideoPath(Constant.url);
                convertView = videoListItemView;
            }
            return convertView;
        }
    };

}
