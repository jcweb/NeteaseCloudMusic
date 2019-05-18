package music.netease.com.neteasecloudmusic.callback;

public interface DataCallBack<T> {
    void requestBefore();

    void requestSuccess(T data);

    void requestError(String msg);
}
