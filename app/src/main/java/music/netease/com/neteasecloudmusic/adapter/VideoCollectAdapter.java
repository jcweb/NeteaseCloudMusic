package music.netease.com.neteasecloudmusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.tools.adapter.BaseRecyclerAdapter;
import com.app.tools.adapter.OnRecyclerViewClickListener;
import com.app.tools.util.ScreenUtils;
import com.bumptech.glide.Glide;

import java.util.List;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.model.VideoEntity;

public class VideoCollectAdapter extends BaseRecyclerAdapter<VideoEntity, VideoCollectAdapter.ViewHolder> {
    private OnRecyclerViewClickListener onClickListener;

    public VideoCollectAdapter(Context context, List<VideoEntity> list) {
        super(context, list);
    }

    @Override
    public VideoCollectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_video_seamless_play, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder holder = (ViewHolder) viewHolder;
        super.onBindViewHolder(viewHolder, position);
        VideoEntity videoBean = list.get(position);
        Glide.with(mContext)
                .load(videoBean.getThumb())
                .crossFade()
                .placeholder(android.R.color.white)
                .into(holder.mThumb);
        holder.title.setText(videoBean.getTitle());
        holder.itemView.setTag(position);
        holder.mThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onItemClick(holder.mThumb, position);
                }
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private FrameLayout mPlayerContainer;
        private ImageView mThumb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mPlayerContainer = itemView.findViewById(R.id.player_container);
            mThumb = itemView.findViewById(R.id.thumb);
            ViewGroup.LayoutParams params = mThumb.getLayoutParams();
            params.height = ScreenUtils.dip2px(mContext,200);
            params.width = ScreenUtils.getScreenWidth(mContext);
            mThumb.setLayoutParams(params);
            int widthPixels = mContext.getResources().getDisplayMetrics().widthPixels;
            mPlayerContainer.setLayoutParams(new LinearLayout.LayoutParams(widthPixels, widthPixels * 9 / 16 + 1));
            title = itemView.findViewById(R.id.tv_title);
        }
    }

    @Override
    public void setOnClickListener(OnRecyclerViewClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.onClickListener = onClickListener;
    }
}
