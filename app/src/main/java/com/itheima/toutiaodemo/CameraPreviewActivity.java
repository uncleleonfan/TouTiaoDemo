package com.itheima.toutiaodemo;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.TextureView;
import android.widget.LinearLayout;

import java.io.IOException;

/**
 * 创建者: Leon
 * 创建时间: 2016/10/4 9:33
 * 描述： TODO
 */
public class CameraPreviewActivity extends AppCompatActivity {

    private TextureView mTextureView;

    private Camera mCamera;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_preview);
        mTextureView = (TextureView) findViewById(R.id.texture_view);
        mTextureView.setSurfaceTextureListener(mSurfaceTextureListener);
    }

    private TextureView.SurfaceTextureListener mSurfaceTextureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            mCamera = Camera.open();
            Camera.Size previewSize = mCamera.getParameters().getPreviewSize();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(previewSize.width, previewSize.height);
            layoutParams.gravity = Gravity.CENTER;
            mTextureView.setLayoutParams(layoutParams);
            try {
                mCamera.setPreviewTexture(surface);
                mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }

            mTextureView.setRotation(90);
            mTextureView.setAlpha(0.5f);
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            mCamera.stopPreview();
            mCamera.release();
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {

        }
    };
}

