package com.itheima.toutiaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView;

    private HeiMaVideoView mHeiMaVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView = (VideoView) findViewById(R.id.video_view);
        mHeiMaVideoView = (HeiMaVideoView) findViewById(R.id.heima_video_view);
//        mVideoView.setVideoPath(Constant.url);
//        mVideoView.start();
        mHeiMaVideoView.setVideoPath(Constant.url);
    }

    public void onScrollBy(View view) {
        mVideoView.scrollBy(-100, 0);
    }

    public void onTranslate(View view) {
        mVideoView.setTranslationX(100);
    }

    public void onStartAnimation(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
//        mVideoView.startAnimation(rotateAnimation);
        mHeiMaVideoView.startAnimation(rotateAnimation);
/*        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mVideoView, "rotation", 0f, -180f);
        objectAnimator.setDuration(1000);
        objectAnimator.start();*/
    }
}
