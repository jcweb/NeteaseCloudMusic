package music.netease.com.neteasecloudmusic.network;

import okhttp3.OkHttpClient;

public class OkHttpManager extends AbsRequest {

    private OkHttpManager instance;

    public OkHttpManager getInstance() {
        if(instance==null){
            instance = new OkHttpManager();
        }
        return instance;
    }

    public OkHttpManager(){
        if(httpClient==null){
            httpClient = new OkHttpClient();
        }
    }
}
