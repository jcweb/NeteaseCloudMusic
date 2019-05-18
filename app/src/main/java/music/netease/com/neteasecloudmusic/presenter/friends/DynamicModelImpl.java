package music.netease.com.neteasecloudmusic.presenter.friends;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import music.netease.com.neteasecloudmusic.callback.DataCallBack;
import music.netease.com.neteasecloudmusic.model.DynamicEntity;
import music.netease.com.neteasecloudmusic.model.DynamicModel;
import music.netease.com.neteasecloudmusic.model.VideoEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicTabEntity;
import music.netease.com.neteasecloudmusic.network.OkHttpManager;
import music.netease.com.neteasecloudmusic.utils.Constant;
import music.netease.com.neteasecloudmusic.utils.EncryptUtils;
import music.netease.com.neteasecloudmusic.view.IFriendFragment;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class DynamicModelImpl extends OkHttpManager implements IDynamic {
    private IFriendFragment iFriendFragment;
    private List<DynamicEntity> list;

    public DynamicModelImpl(IFriendFragment iFriendFragment) {
        this.iFriendFragment = iFriendFragment;
        list = new ArrayList<>();
    }

    @Override
    public void getDynamicList(int pagesize, long lasttime) {

        HashMap parameter = new HashMap<>();
        parameter.put("pagesize", pagesize);
        parameter.put("lasttime", lasttime);
        requestPost(Constant.BASE_URL_NETEASE + "v1/event/get", parameter, new DataCallBack<DynamicModel>() {
            @Override
            public void requestBefore() {

            }

            @Override
            public void requestSuccess(DynamicModel data) {
                if (data == null || data.getCode() != 200 || data.getEvent() == null)
                    return;
                for (int i = 0; i < data.getEvent().size(); i++) {
                    list.add(data.getEvent().get(i));
                }
                iFriendFragment.update(list);
            }

            @Override
            public void requestError(String msg) {

            }
        });
    }

    public void getAttenList(String uid) {
        HashMap parameter = new HashMap<>();
        parameter.put("offset", 0);
        parameter.put("limit", 30);
        parameter.put("order", true);
        requestPost(Constant.BASE_URL_NETEASE + "user/getfollows/" + uid, parameter, new DataCallBack<DynamicTabEntity>() {
            @Override
            public void requestBefore() {

            }

            @Override
            public void requestSuccess(DynamicTabEntity data) {
                if (data == null || data.getCode() != 200 || data.getFollow() == null)
                    return;

                iFriendFragment.loadTabList(data);
            }

            @Override
            public void requestError(String msg) {

            }
        });
    }
}
