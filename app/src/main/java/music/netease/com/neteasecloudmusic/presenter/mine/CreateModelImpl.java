package music.netease.com.neteasecloudmusic.presenter.mine;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import music.netease.com.neteasecloudmusic.callback.DataCallBack;
import music.netease.com.neteasecloudmusic.network.OkHttpManager;
import music.netease.com.neteasecloudmusic.utils.Constant;
import music.netease.com.neteasecloudmusic.utils.EncryptUtils;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class CreateModelImpl extends OkHttpManager implements ICreate {
    @Override
    public void getCreateList(String uid, int limit, DataCallBack dataCallBack) {

        HashMap parameter = new HashMap<>();
        parameter.put("uid", uid);
        parameter.put("limit", limit);
        requestPost(Constant.BASE_URL_NETEASE + "user/playlist?", parameter, dataCallBack);
    }
}
