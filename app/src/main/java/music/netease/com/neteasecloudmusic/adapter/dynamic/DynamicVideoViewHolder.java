package music.netease.com.neteasecloudmusic.adapter.dynamic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;

import com.app.playerlib.player.IjkVideoView;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.model.DynamicEntity;
import music.netease.com.neteasecloudmusic.model.VideoUrlEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicVideoEntity;
import music.netease.com.neteasecloudmusic.presenter.video.VideoModelImpl;
import music.netease.com.neteasecloudmusic.storage.preference.SeamlessPlayHelper;
import music.netease.com.neteasecloudmusic.utils.JsonUtils;
import music.netease.com.neteasecloudmusic.widget.controller.SeamlessController;

public class DynamicVideoViewHolder extends DynamicBaseViewHolder<DynamicEntity> {
    private IjkVideoView ijkVideoView;
    private SeamlessController mSeamlessController;
    private DynamicVideoEntity videoEntity;
    private FrameLayout playerContainer;

    public DynamicVideoViewHolder(Context context, @NonNull View itemView) {
        super(context, itemView);

        ijkVideoView = SeamlessPlayHelper.getInstance().getIjkVideoView();
        playerContainer = itemView.findViewById(R.id.item_player_container);
        mSeamlessController = new SeamlessController(context);
        ijkVideoView.setVideoController(mSeamlessController);

        if (ijkVideoView != null && !ijkVideoView.isFullScreen()) {

            if (playerContainer != null) {
                playerContainer.removeView(ijkVideoView);
            }

            ijkVideoView.stopPlayback();
        }
    }

    @Override
    public void onBindView(DynamicEntity entity) {
        videoEntity = JsonUtils.getParam(entity.getJson(), DynamicVideoEntity.class);
        getVideoUrl();
    }

    private void getVideoUrl() {
        VideoModelImpl videoModel = new VideoModelImpl(context, this);
        if (!TextUtils.isEmpty(videoEntity.getVideo().getVideoId())) {
            String id = videoEntity.getVideo().getVideoId();
            if (id.length() > 10) {
                videoModel.getVideoUrl(id);
            } else {
                videoModel.getMvUrl(id);
            }
        }
    }

    public void updateVideoView(VideoUrlEntity entity) {
        ijkVideoView.setUrl(entity.getUrls().get(0).getUrl());
        playerContainer.addView(ijkVideoView);
        ijkVideoView.start();
    }
}
