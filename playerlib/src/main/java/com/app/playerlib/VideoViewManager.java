package com.app.playerlib;

import com.app.playerlib.player.BaseIjkVideoView;

public class VideoViewManager {
    private BaseIjkVideoView mPlayer;

    private VideoViewManager() {
    }

    private static VideoViewManager sInstance;

    public static VideoViewManager instance() {
        if (sInstance == null) {
            synchronized (VideoViewManager.class) {
                if (sInstance == null) {
                    sInstance = new VideoViewManager();
                }
            }
        }
        return sInstance;
    }

    public void setCurrentVideoPlayer(BaseIjkVideoView player) {
        mPlayer = player;
    }

    public BaseIjkVideoView getCurrentVideoPlayer() {
        return mPlayer;
    }

    public void releaseVideoPlayer() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void stopPlayback() {
        if (mPlayer != null) mPlayer.stopPlayback();
    }

    public boolean onBackPressed() {
        return mPlayer != null && mPlayer.onBackPressed();
    }
}