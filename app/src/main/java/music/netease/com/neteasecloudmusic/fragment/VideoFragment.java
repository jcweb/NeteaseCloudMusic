package music.netease.com.neteasecloudmusic.fragment;


import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

import com.app.playerlib.listener.OnVideoViewStateChangeListener;
import com.app.playerlib.player.IjkVideoView;
import com.app.tools.adapter.OnRecyclerViewClickListener;

import java.util.ArrayList;
import java.util.List;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.activity.VideoDetailActivity;
import music.netease.com.neteasecloudmusic.adapter.VideoCollectAdapter;
import music.netease.com.neteasecloudmusic.model.VideoEntity;
import music.netease.com.neteasecloudmusic.presenter.video.VideoModelImpl;
import music.netease.com.neteasecloudmusic.storage.preference.SeamlessPlayHelper;
import music.netease.com.neteasecloudmusic.utils.IntentKeys;
import music.netease.com.neteasecloudmusic.view.IVideoFragment;
import music.netease.com.neteasecloudmusic.widget.controller.SeamlessController;

/**
 * 视频
 */
public class VideoFragment extends Fragment implements OnRecyclerViewClickListener, IVideoFragment {
    private String uid = "118006451";//临时使用，后续会从登录接口中取
    private IjkVideoView ijkVideoView;
    private List<VideoEntity> list;
    private boolean mSkipToDetail;
    private SeamlessController mSeamlessController;
    private int mCurrentPlayPosition = -1;
    private VideoCollectAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ijkVideoView = SeamlessPlayHelper.getInstance().getIjkVideoView();
        mSeamlessController = new SeamlessController(getContext());
        ijkVideoView.setVideoController(mSeamlessController);

        recyclerView = getActivity().findViewById(R.id.rv);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        list = new ArrayList<>();
        adapter = new VideoCollectAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
        getMVlist();

//        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
//            @Override
//            public void onChildViewAttachedToWindow(View view) {
//
//            }
//
//            @Override
//            public void onChildViewDetachedFromWindow(View view) {
//                FrameLayout playerContainer = view.findViewById(R.id.player_container);
//                IjkVideoView ijkVideoView = view.findViewById(R.id.video_player);
//                if (ijkVideoView != null && !ijkVideoView.isFullScreen()) {
//
//                    if (playerContainer != null) {
//                        playerContainer.removeView(ijkVideoView);
//                    }
//
//                    ijkVideoView.stopPlayback();
//                }
//            }
//        });
//
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//            int firstVisibleItem, lastVisibleItem, visibleCount;
//
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//
//                switch (newState) {
//                    case RecyclerView.SCROLL_STATE_IDLE: //滚动停止
//                        autoPlayVideo(recyclerView);
//                        break;
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
//                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
//                visibleCount = lastVisibleItem - firstVisibleItem;//记录可视区域item个数
//            }
//
//            private void autoPlayVideo(RecyclerView view) {
//                //循环遍历可视区域playerContainer,如果完全可见就把播放器添加到里面，并开始播放
//                for (int i = 0; i < visibleCount; i++) {
//                    View itemView = view.getChildAt(i);
//                    if (itemView == null) continue;
//                    FrameLayout playerContainer = itemView.findViewById(R.id.player_container);
//                    Rect rect = new Rect();
//                    playerContainer.getLocalVisibleRect(rect);
//                    int videoHeight = playerContainer.getHeight();
//                    if (rect.top == 0 && rect.bottom == videoHeight) {
//                        int position = (int) itemView.getTag();
//                        if (mCurrentPlayPosition == position) break;
//                        removePlayerFormParent();
//                        ijkVideoView.release();
//                        VideoEntity videoBean = list.get(position);
//                        ijkVideoView.setUrl(videoBean.getUrl());
//                        mSeamlessController.resetController();
//                        ijkVideoView.setVideoController(mSeamlessController);
//                        ijkVideoView.start();
//                        playerContainer.addView(ijkVideoView);
//                        mCurrentPlayPosition = position;
//                        break;
//                    }
//                }
//            }
//        });

    }

    /**
     * 将播放器从父控件中移除
     */
    private void removePlayerFormParent() {
        ViewParent parent = ijkVideoView.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).removeView(ijkVideoView);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (!mSkipToDetail) {
            ijkVideoView.pause();
        } else {
            mSkipToDetail = false;
        }
        ijkVideoView.removeOnVideoViewStateChangeListener(mOnVideoViewStateChangeListener);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!mSkipToDetail) {
            ijkVideoView.resume();
        }
        ijkVideoView.addOnVideoViewStateChangeListener(mOnVideoViewStateChangeListener);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        removePlayerFormParent();
        ijkVideoView.setVideoController(null);
        ijkVideoView.release();

    }

    private OnVideoViewStateChangeListener mOnVideoViewStateChangeListener = new OnVideoViewStateChangeListener() {
        @Override
        public void onPlayerStateChanged(int playerState) {

        }

        @Override
        public void onPlayStateChanged(int playState) {
            //小屏状态下播放出来之后，把声音关闭
            if (playState == IjkVideoView.STATE_PREPARED && !ijkVideoView.isFullScreen()) {
                ijkVideoView.setMute(true);
            }
        }
    };

    /*获取用户收藏的MV数据*/
    private void getMVlist() {
        VideoModelImpl videoModel = new VideoModelImpl(getActivity(), this);
        videoModel.getVideoList(uid);
    }


    @Override
    public void onItemClick(View view, int position) {

        mSkipToDetail = true;
        //移除Controller
        ijkVideoView.setVideoController(null);
        //重置Controller
        mSeamlessController.resetController();
        Intent intent = new Intent(getContext(), VideoDetailActivity.class);
        Bundle bundle = new Bundle();

        if (mCurrentPlayPosition == position) {
            //需要无缝播放
            bundle.putBoolean(IntentKeys.SEAMLESS_PLAY, true);
        } else {
            //无需无缝播放，把相应数据传到详情页
            ijkVideoView.release();
            VideoEntity videoBean = list.get(position);
            bundle.putBoolean(IntentKeys.SEAMLESS_PLAY, false);
            bundle.putString(IntentKeys.URL, videoBean.getUrl());
            bundle.putString(IntentKeys.TITLE, videoBean.getTitle());
        }
        intent.putExtras(bundle);
        startActivity(intent, bundle);
        //重置当前播放位置
        mCurrentPlayPosition = -1;
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }

    @Override
    public void updateView(List<VideoEntity> listvideo) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                list.clear();
                list.addAll(listvideo);
                adapter.notifyDataSetChanged();
                recyclerView.post(() -> {
                    //自动播放第一个
                    VideoEntity videoBean = list.get(0);
                    ijkVideoView.setUrl(videoBean.getUrl());
                    ijkVideoView.start();
                    mCurrentPlayPosition = 0;

                    View view = recyclerView.getChildAt(0);
                    FrameLayout playerContainer = view.findViewById(R.id.player_container);
//                    playerContainer.addView(ijkVideoView);
                });
            }
        });
    }
}
