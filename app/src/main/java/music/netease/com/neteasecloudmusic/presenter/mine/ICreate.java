package music.netease.com.neteasecloudmusic.presenter.mine;

import music.netease.com.neteasecloudmusic.callback.DataCallBack;

public interface ICreate<T> {
    public void getCreateList(String uid, int limit, DataCallBack<T> dataCallBack);
}
