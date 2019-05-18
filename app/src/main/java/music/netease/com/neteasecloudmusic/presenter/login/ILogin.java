package music.netease.com.neteasecloudmusic.presenter.login;

import music.netease.com.neteasecloudmusic.callback.DataCallBack;

public interface ILogin<T> {

    void login(String name, String password, DataCallBack<T> callBaclk);

}
