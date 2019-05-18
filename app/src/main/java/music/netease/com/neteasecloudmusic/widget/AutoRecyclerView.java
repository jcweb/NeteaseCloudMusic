package music.netease.com.neteasecloudmusic.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import music.netease.com.neteasecloudmusic.R;

public class AutoRecyclerView extends RecyclerView {
    private View vFooter;
    private boolean hasFootView;
    public AutoRecyclerView(@NonNull Context context) {
        super(context);
        initView();
    }

    public AutoRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AutoRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
    }

    public void addFootView(View footer){

    }

    public void addFootView(){
        vFooter = LayoutInflater.from(getContext()).inflate(R.layout.auto_load_list_view_footer, null);
    }

    public void removeFootView(){

    }

    public interface LoadMore{
        void loadSuccess(boolean state);
    }
}
