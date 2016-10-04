
package com.itheima.toutiaodemo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;

import java.io.IOException;

/**
 * 创建者: Leon
 * 创建时间: 2016/10/4 10:19
 * 描述： TODO
 */
public class HeiMaVideoView extends TextureView {
    private static final String TAG = "HeiMaVideoView";

    private MediaPlayer mMediaPlayer;
    private String mUrl;

    public HeiMaVideoView(Context context) {
        this(context, null);
    }

    public HeiMaVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setSurfaceTextureListener(mSurfaceTextureListener);
    }

    private SurfaceTextureListener mSurfaceTextureListener = new SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            if (mMediaPlayer == null) {
                mMediaPlayer = new MediaPlayer();
                mMediaPlayer.setOnPreparedListener(mOnPreparedListener);
                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mMediaPlayer.setScreenOnWhilePlaying(true);
                mMediaPlayer.setSurface(new Surface(surface));
            }
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            mMediaPlayer.release();
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {

        }
    };

    public void setVideoPath(String url) {
        mUrl = url;
    }

    private MediaPlayer.OnPreparedListener mOnPreparedListener = new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mMediaPlayer.start();
        }
    };


    public void start() {
        try {
            mMediaPlayer.setDataSource(getContext(), Uri.parse(mUrl));
            mMediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        mMediaPlayer.stop();
    }

    public void pause() {
        mMediaPlayer.pause();
    }

    public void play() {
        mMediaPlayer.start();
    }
}
