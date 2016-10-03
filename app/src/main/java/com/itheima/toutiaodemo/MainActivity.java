package com.itheima.toutiaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.RotateAnimation;
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

    public void onScrollBy(View view) {
        mVideoView.scrollBy(-100, 0);
    }

    public void onTranslate(View view) {
        mVideoView.setTranslationX(100);
    }

    public void onStartAnimation(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f,  RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        mVideoView.startAnimation(rotateAnimation);
    }
}
