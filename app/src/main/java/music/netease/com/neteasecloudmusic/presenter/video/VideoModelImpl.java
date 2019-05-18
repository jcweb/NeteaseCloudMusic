package music.netease.com.neteasecloudmusic.presenter.video;

import android.content.Context;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import music.netease.com.neteasecloudmusic.adapter.dynamic.DynamicVideoViewHolder;
import music.netease.com.neteasecloudmusic.callback.DataCallBack;
import music.netease.com.neteasecloudmusic.model.MVUrlEntity;
import music.netease.com.neteasecloudmusic.model.VideoEntity;
import music.netease.com.neteasecloudmusic.model.VideoModel;
import music.netease.com.neteasecloudmusic.model.VideoUrlEntity;
import music.netease.com.neteasecloudmusic.network.OkHttpManager;
import music.netease.com.neteasecloudmusic.utils.Constant;
import music.netease.com.neteasecloudmusic.utils.EncryptUtils;
import music.netease.com.neteasecloudmusic.utils.JsonUtils;
import music.netease.com.neteasecloudmusic.view.IVideoFragment;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class VideoModelImpl extends OkHttpManager implements IVideo {
    private Context context;
    private IVideoFragment iVideoFragment;
    private List<VideoEntity> list;
    private int counts = 0;
    private DynamicVideoViewHolder holder;

    public VideoModelImpl(Context context, IVideoFragment iVideoFragment) {
        this.context = context;
        this.iVideoFragment = iVideoFragment;
        list = new ArrayList<>();
    }

    public VideoModelImpl(Context context, DynamicVideoViewHolder holder) {
        this.context = context;
        this.holder = holder;
    }

    @Override
    public void getVideoList(String id) {

        HashMap parameter = new HashMap<>();
        parameter.put("id", id);
        requestPost(Constant.BASE_URL_NETEASE + "cloudvideo/allvideo/sublist?", parameter, new DataCallBack<VideoModel>() {
            @Override
            public void requestBefore() {

            }

            @Override
            public void requestSuccess(VideoModel data) {
                if (data == null || data.getData().size() == 0)
                    return;
                counts = data.getData().size();
                for (int i = 0; i < data.getData().size(); i++) {
                    VideoModel.DataBean dataBean = data.getData().get(i);
                    VideoEntity entity = new VideoEntity();
                    entity.setId(dataBean.getVid());
                    entity.setThumb(dataBean.getCoverUrl());
                    entity.setTitle(dataBean.getTitle());
                    list.add(entity);
                    if (!TextUtils.isEmpty(dataBean.getVid())) {
                        if (dataBean.getVid().length() > 10) {
                            getVideoUrl(dataBean.getVid());
                        } else {
                            getMvUrl(dataBean.getVid());
                        }
                    }
                }
            }

            @Override
            public void requestError(String msg) {

            }
        });
    }

    private void manage(String vid, String url) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(vid)) {
                list.get(i).setUrl(url);
            }
        }
        if (counts == 0) {
            iVideoFragment.updateView(list);
        }
    }

    public void getVideoUrl(String vid) {
        HashMap parameter = new HashMap<>();
        parameter.put("ids", "[\"" + vid + "\"]");
        parameter.put("resolution", 720);

        requestPost(Constant.BASE_URL_NETEASE + "cloudvideo/playurl?", parameter, new DataCallBack<VideoUrlEntity>() {
            @Override
            public void requestBefore() {

            }

            @Override
            public void requestSuccess(final VideoUrlEntity data) {
                if (data != null && data.getUrls() != null) {
                    if (holder == null) {
                        counts--;
                        manage(data.getUrls().get(0).getId(), data.getUrls().get(0).getUrl());
                    } else {
                        holder.updateVideoView(data);
                    }
                }
            }

            @Override
            public void requestError(String msg) {

            }
        });
    }

    public void getMvUrl(String vid) {
        HashMap parameter = new HashMap<>();
        parameter.put("id", vid);
        parameter.put("r", 720);

        requestPost(Constant.BASE_URL_NETEASE + "song/enhance/play/mv/url?", parameter, new DataCallBack<MVUrlEntity>() {
            @Override
            public void requestBefore() {

            }

            @Override
            public void requestSuccess(MVUrlEntity data) {
                counts--;
                if (data != null && data.getData() != null) {
                    manage(data.getData().getId(), data.getData().getUrl());
                }
            }

            @Override
            public void requestError(String msg) {

            }
        });
    }
}
