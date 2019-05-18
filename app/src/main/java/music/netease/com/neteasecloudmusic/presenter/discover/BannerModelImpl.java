package music.netease.com.neteasecloudmusic.presenter.discover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import music.netease.com.neteasecloudmusic.callback.DataCallBack;
import music.netease.com.neteasecloudmusic.model.BaseEntity;
import music.netease.com.neteasecloudmusic.model.VideoModel;
import music.netease.com.neteasecloudmusic.model.discover.BannerModel;
import music.netease.com.neteasecloudmusic.model.discover.RecomModel;
import music.netease.com.neteasecloudmusic.network.OkHttpManager;
import music.netease.com.neteasecloudmusic.utils.Constant;
import music.netease.com.neteasecloudmusic.view.IDisFragment;

public class BannerModelImpl extends OkHttpManager implements IBanner {
    private IDisFragment disFragment;
    private List<BaseEntity> list;

    public BannerModelImpl(IDisFragment disFragment) {
        this.disFragment = disFragment;
        list = new ArrayList<>();
    }

    @Override
    public void getBannerList(String type) {

        HashMap parameter = new HashMap<>();
        parameter.put("clientType", type);

        requestPost(Constant.URL_BANNER, parameter, new DataCallBack<BannerModel>() {
            @Override
            public void requestBefore() {

            }

            @Override
            public void requestSuccess(BannerModel data) {
                if (data == null || data.getBanners().size() == 0)
                    return;
                list.add(data);
                //banner获取以后请求推荐歌单
//                getRectMusicList();
                disFragment.update(list);
            }

            @Override
            public void requestError(String msg) {

            }
        });
    }

    /*获取推荐歌单*/
    private void getRectMusicList() {

        HashMap parameter = new HashMap<>();

        requestPost(Constant.URL_RCMD, parameter, new DataCallBack<RecomModel>() {
            @Override
            public void requestBefore() {

            }

            @Override
            public void requestSuccess(RecomModel data) {
                if (data == null || data.getRecommend().size() == 0)
                    return;
                list.add(data);
                disFragment.update(list);
            }

            @Override
            public void requestError(String msg) {
            }
        });
    }
}
