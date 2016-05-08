package com.xiong.video.youku;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.baseproject.utils.Logger;
import com.xiong.video.R;
import com.youku.player.base.YoukuBasePlayerManager;
import com.youku.player.base.YoukuPlayer;
import com.youku.player.base.YoukuPlayerView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * YouKuPlayActivity
 * Created by 杨超 on 2016/5/4.
 */
public class YouKuPlayActivity extends AppCompatActivity {
    @Bind(R.id.youku_player)
    YoukuPlayerView mYoukuPlayerView;
    private YoukuBasePlayerManager mYoukuPlayerManager;
    private YoukuPlayer mYoukuPlayer;
    private String vid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youku_play);
        ButterKnife.bind(this);
        vid = getIntent().getStringExtra("vid");
        mYoukuPlayerManager = new YoukuBasePlayerManager(this) {
            @Override
            public void setPadHorizontalLayout() {

            }

            @Override
            public void onInitializationSuccess(YoukuPlayer player) {
                addPlugins();
                mYoukuPlayer = player;
                goPlay();
            }

            @Override
            public void onFullscreenListener() {

            }

            @Override
            public void onSmallscreenListener() {

            }
        };
        mYoukuPlayerManager.onCreate();
        mYoukuPlayerView
                .setSmallScreenLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
        mYoukuPlayerView
                .setFullScreenLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
        // 初始化播放器相关数据
        mYoukuPlayerView.initialize(mYoukuPlayerManager);
    }

    private void goPlay() {
        mYoukuPlayer.playVideo(vid);
    }

    @Override
    public void onBackPressed() { // android系统调用
        Logger.d("sgh", "onBackPressed before super");
        super.onBackPressed();
        Logger.d("sgh", "onBackPressed");
        mYoukuPlayerManager.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mYoukuPlayerManager.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mYoukuPlayerManager.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean managerKeyDown = mYoukuPlayerManager.onKeyDown(keyCode, event);
        if (mYoukuPlayerManager.shouldCallSuperKeyDown()) {
            return super.onKeyDown(keyCode, event);
        } else {
            return managerKeyDown;
        }

    }

    @Override
    public void onLowMemory() { // android系统调用
        super.onLowMemory();
        mYoukuPlayerManager.onLowMemory();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mYoukuPlayerManager.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mYoukuPlayerManager.onResume();
    }

    @Override
    public boolean onSearchRequested() { // android系统调用
        return mYoukuPlayerManager.onSearchRequested();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mYoukuPlayerManager.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mYoukuPlayerManager.onStop();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        // TODO Auto-generated method stub
        super.onNewIntent(intent);

        // 通过Intent获取播放需要的相关参数
        vid = intent.getStringExtra("vid");
        // 进行播放
        goPlay();
    }
}
