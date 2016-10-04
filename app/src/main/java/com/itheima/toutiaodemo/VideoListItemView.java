package com.itheima.toutiaodemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * 创建者: Leon
 * 创建时间: 2016/10/4 11:18
 * 描述： TODO
 */
public class VideoListItemView extends RelativeLayout {
    private static final String TAG = "VideoListItemView";

    private HeiMaVideoView mHeiMaVideoView;

    private ImageView mStart;

    private ImageView mCover;

    private static final int STATE_PLAYING = 1;
    private static final int STATE_STOP = 2;
    private int mState = STATE_STOP;

    public VideoListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public VideoListItemView(Context context) {
        this(context, null);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_video_list_item, this);
        mHeiMaVideoView = (HeiMaVideoView) findViewById(R.id.heima_video_view);
        mStart = (ImageView) findViewById(R.id.start);
        mCover = (ImageView) findViewById(R.id.cover);
        mStart.setOnClickListener(mOnClickListener);
    }

    private OnClickListener mOnClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (mState == STATE_STOP) {
                play();
            }
        }
    };

    public void play() {
        mState = STATE_PLAYING;
        mHeiMaVideoView.play();
        mCover.setVisibility(GONE);
        mStart.setVisibility(GONE);
    }

    public void stop() {
        mState = STATE_STOP;
        mHeiMaVideoView.stop();
        mStart.setVisibility(VISIBLE);
    }

    public void setVideoPath(String url) {
        mHeiMaVideoView.setVideoPath(url);
    }
}
