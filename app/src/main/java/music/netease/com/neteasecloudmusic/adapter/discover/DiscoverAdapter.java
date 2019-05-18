package music.netease.com.neteasecloudmusic.adapter.discover;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.app.tools.adapter.BaseRecyclerAdapter;

import java.util.List;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.model.BaseEntity;
import music.netease.com.neteasecloudmusic.model.discover.BannerModel;
import music.netease.com.neteasecloudmusic.model.discover.RecomModel;
import music.netease.com.neteasecloudmusic.model.discover.TabButtonModel;

public class DiscoverAdapter extends BaseRecyclerAdapter<BaseEntity, RecyclerView.ViewHolder> {
    private static final int TYPE_BANNER = 1;
    private static final int TYPE_TAB = 2;
    private static final int TYPE_MUSIC_LIST = 3;
    private static final int TYPE_VIDEO = 4;

    public DiscoverAdapter(Context context, List<BaseEntity> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_BANNER) {
            return new DisBannerViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.discover_item_banner, parent, false));
        } else {
            return new DisBannerViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.discover_item_banner, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        super.onBindViewHolder(viewHolder, position);
        BaseEntity entity = list.get(position);
        if (entity instanceof BannerModel) {
            ((DisBannerViewHolder) viewHolder).bindViewHolder(entity);
        }
    }

    @Override
    public int getItemViewType(int position) {
        BaseEntity entity = list.get(position);
        if (entity instanceof BannerModel) {
            return TYPE_BANNER;
        } else if (entity instanceof TabButtonModel) {
            return TYPE_TAB;
        } else if (entity instanceof RecomModel) {
            return TYPE_MUSIC_LIST;
        }
        return 0;
    }
}
