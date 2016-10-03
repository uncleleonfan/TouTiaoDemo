package com.itheima.toutiaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView;

    private String url ="http://flv2.bn.netease.com/videolib3/1604/28/fVobI0704/SD/fVobI0704-mobile.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView = (VideoView) findViewById(R.id.video_view);
        mVideoView.setVideoPath(url);
        mVideoView.start();
    }
}
