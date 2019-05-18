package music.netease.com.neteasecloudmusic.activity;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.tools.util.MathUtils;
import com.app.tools.util.ScreenUtils;
import com.app.tools.widget.StickyNestedScrollLayout;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropSquareTransformation;
import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.adapter.MusicListAdapter;
import music.netease.com.neteasecloudmusic.callback.DataCallBack;
import music.netease.com.neteasecloudmusic.model.MusicEntity;
import music.netease.com.neteasecloudmusic.model.MusicModel;
import music.netease.com.neteasecloudmusic.presenter.music.MusicListModelImpl;

public class MusicListActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private MusicListAdapter adapter;
    private List<MusicEntity> list;
    private String id = "";
    private static final String limit = "1000";
    private ImageView ivCover;
    private ImageView ivUser;
    private TextView tvName;
    private TextView tvPlayTime;
    private TextView tvAlbumName;
    private TextView tvSongNum;//歌曲总数
    private TextView tvCommentNum;//评论次数
    private TextView tvShareNum;//分享次数
    private TextView tvCoverDiscribe;//歌单宣言(可能为空)
    private LinearLayout llLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        fullScreen(this);
        initView();
        id = getIntent().getStringExtra("songId");
        initData();
        getMusicList();
    }

    private void initView() {
        recyclerView = findViewById(R.id.rv_music_list);
        ivCover = findViewById(R.id.iv_music_cover);
        ivUser = findViewById(R.id.iv_music_header_user);
        tvName = findViewById(R.id.tv_music_header_user);
        tvAlbumName = findViewById(R.id.tv_album_name);
        tvPlayTime = findViewById(R.id.tv_music_play_time);
        tvSongNum = findViewById(R.id.tv_music_list_num);
        tvShareNum = findViewById(R.id.tv_music_list_share);
        tvCommentNum = findViewById(R.id.tv_music_list_comment);
        tvCoverDiscribe = findViewById(R.id.tv_album_discribe);
        llLoading = findViewById(R.id.ll_loading);
    }

    private void initData() {
        list = new ArrayList<>();
        adapter = new MusicListAdapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);
        String albumName = getIntent().getStringExtra("albumName");
        tvAlbumName.setText(albumName);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    /*更新UI*/
    private void updateMainView(MusicModel model) {
        adapter.notifyDataSetChanged();
        Glide.with(this).load(model.getResult().getCoverImgUrl()).bitmapTransform(new CropSquareTransformation(this)).into(ivCover);
        Glide.with(this).load(model.getResult().getCreator().getAvatarUrl()).into(ivUser);
        tvName.setText(model.getResult().getCreator().getNickname());
        tvSongNum.setText("(共" + model.getResult().getTracks().size() + "首)");
        tvPlayTime.setText(MathUtils.formNumberToStr(model.getResult().getPlayCount()));
        if (model.getResult().getCommentCount() > 0) {
            tvCommentNum.setText(MathUtils.formNumberToStr(model.getResult().getCommentCount()));
        }
        if (model.getResult().getShareCount() > 0) {
            tvShareNum.setText(MathUtils.formNumberToStr(model.getResult().getShareCount()));
        }
        if (!TextUtils.isEmpty(model.getResult().getDescription())) {
            tvCoverDiscribe.setText(model.getResult().getDescription());
        }

        Log.d("RecycleView height:", recyclerView.getHeight() + "");
        Log.d("Screen height:", ScreenUtils.getScreenHeight(this) + "");
    }

    private void getMusicList() {
        MusicListModelImpl musicListModel = new MusicListModelImpl();
        musicListModel.getMusicList(id, limit, new DataCallBack<MusicModel>() {
            @Override
            public void requestBefore() {

            }

            @Override
            public void requestSuccess(final MusicModel data) {
                if (data.getCode() == 200 && data.getResult().getTracks() != null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            list.clear();
                            llLoading.setVisibility(View.GONE);
                            list.addAll(data.getResult().getTracks());
                            updateMainView(data);
                        }
                    });
                }
            }

            @Override
            public void requestError(String msg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llLoading.setVisibility(View.GONE);
                    }
                });
            }
        });
    }

    //找到数组中的最大值
    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}