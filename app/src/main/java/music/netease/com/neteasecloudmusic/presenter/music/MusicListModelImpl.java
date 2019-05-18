package music.netease.com.neteasecloudmusic.presenter.music;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import music.netease.com.neteasecloudmusic.callback.DataCallBack;
import music.netease.com.neteasecloudmusic.model.MusicModel;
import music.netease.com.neteasecloudmusic.network.OkHttpManager;
import music.netease.com.neteasecloudmusic.utils.Constant;
import music.netease.com.neteasecloudmusic.utils.EncryptUtils;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class MusicListModelImpl extends OkHttpManager implements IMusicList<MusicModel> {
    @Override
    public void getMusicList(String id, String limit, DataCallBack<MusicModel> callBack) {

        HashMap parameter = new HashMap<>();
        parameter.put("id", id);
        parameter.put("limit", limit);
        parameter.put("total", true);
        requestPost(Constant.BASE_URL_NETEASE + "playlist/detail", parameter, callBack);
    }
}
