package music.netease.com.neteasecloudmusic.storage.preference;


import com.app.playerlib.player.IjkVideoView;

import music.netease.com.neteasecloudmusic.MusicApplication;
import music.netease.com.neteasecloudmusic.R;

/**
 * 无缝播放
 */

public class SeamlessPlayHelper {

    private IjkVideoView mIjkVideoView;
    private static SeamlessPlayHelper instance;

    private SeamlessPlayHelper() {
        mIjkVideoView = new IjkVideoView(MusicApplication.getInstance());
        mIjkVideoView.setId(R.id.video_player);
    }

    public static SeamlessPlayHelper getInstance() {
        if (instance == null) {
            synchronized (SeamlessPlayHelper.class) {
                if (instance == null) {
                    instance = new SeamlessPlayHelper();
                }
            }
        }
        return instance;
    }


    public IjkVideoView getIjkVideoView() {
        return mIjkVideoView;
    }


}
