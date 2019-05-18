package music.netease.com.neteasecloudmusic.service;

import music.netease.com.neteasecloudmusic.model.MusicEntity;

public interface IPlayerListener {

    /**
     * 切换歌曲
     */
    void onChange(MusicEntity music);

    /**
     * 继续播放
     */
    void onPlayerStart();

    /**
     * 暂停播放
     */
    void onPlayerPause();

    /**
     * 更新进度
     */
    void onPublish(int progress);

    /**
     * 缓冲百分比
     */
    void onBufferingUpdate(int percent);
}
