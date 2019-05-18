package music.netease.com.neteasecloudmusic;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class MusicApplication extends Application {
    private static MusicApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null) {
            instance = this;
        }

        /*leak*/
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        /*Glide設置*/
    }

    public static MusicApplication getInstance() {
        return instance;
    }
}
