package music.netease.com.neteasecloudmusic.presenter.music;

import music.netease.com.neteasecloudmusic.callback.DataCallBack;

public interface IMusicList<T> {
     void getMusicList(String id, String limit, DataCallBack<T> callBack);
}
