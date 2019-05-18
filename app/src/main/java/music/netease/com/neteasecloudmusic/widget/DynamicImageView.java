package music.netease.com.neteasecloudmusic.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.app.tools.widget.NineGridLayout;
import com.app.tools.widget.RatioImageView;
import com.bumptech.glide.Glide;

import java.util.List;

public class DynamicImageView extends NineGridLayout {
    private Context context;

    public DynamicImageView(Context context) {
        super(context);
        this.context = context;
    }

    public DynamicImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected boolean displayOneImage(RatioImageView imageView, String url, int parentWidth) {
        return true;
    }

    @Override
    protected void displayImage(RatioImageView imageView, String url) {
        Glide.with(context).load(url).into(imageView);
    }

    @Override
    protected void onClickImage(int position, String url, List<String> urlList) {
        if (onItemClick != null) {
            onItemClick.onClick(position);
        }
    }

    OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick {
        void onClick(int position);
    }
}
