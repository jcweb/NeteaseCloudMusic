package music.netease.com.neteasecloudmusic.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.app.tools.util.ScreenUtils;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.model.MusicEntity;
import music.netease.com.neteasecloudmusic.service.IPlayerListener;

public class MusicPlayActivity extends Activity implements IPlayerListener {
    private LinearLayout llContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);

        initView();
    }

    private void initView() {
        llContent = findViewById(R.id.ll_content);
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int top = ScreenUtils.getStatusBarHeight();
            llContent.setPadding(0, top, 0, 0);
        }
    }


    @Override
    public void onChange(MusicEntity music) {

    }

    @Override
    public void onPlayerStart() {

    }

    @Override
    public void onPlayerPause() {

    }

    @Override
    public void onPublish(int progress) {

    }

    @Override
    public void onBufferingUpdate(int percent) {

    }
}
