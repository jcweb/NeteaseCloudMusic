package music.netease.com.neteasecloudmusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.tools.adapter.BaseRecyclerAdapter;
import com.app.tools.adapter.OnRecyclerViewClickListener;
import com.app.tools.widget.CircularImageView;
import com.bumptech.glide.Glide;

import java.util.List;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.adapter.dynamic.DynamicBaseViewHolder;
import music.netease.com.neteasecloudmusic.adapter.dynamic.DynamicHeaderHolder;
import music.netease.com.neteasecloudmusic.adapter.dynamic.DynamicMusicViewHolder;
import music.netease.com.neteasecloudmusic.adapter.dynamic.DynamicVideoViewHolder;
import music.netease.com.neteasecloudmusic.model.BaseEntity;
import music.netease.com.neteasecloudmusic.model.DynamicEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicMsgEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicMusicEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicTabEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicVideoEntity;
import music.netease.com.neteasecloudmusic.utils.DynamicItemUtils;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/*
 * 朋友页面的item主要有2种布局
 * 1、图片/图片+音乐，图片和音乐都可以没有
 * 2、视频，视频的话就不会有图片信息，pic数组为空
 * 处理流程是，从返回的json字段中获取加载哪种布局，如果是1，再看有没有图片，有多少张，是什么格式(gif还是jpg），是否需要加载音乐播放布局
 * 如果是2，不用处理图片(pic肯定是空或者0个），直接解析json字段里面的视频URL
 * 不管是哪种item，用户部分的布局是通用的，封装到public_layout中就好，根据字段的值可能会显示出两种效果，基本一样
 * 最后就是底部的评论转发布局，也是通用的
 * */
public class DynamicListAdapter extends BaseRecyclerAdapter<BaseEntity, DynamicBaseViewHolder> {
    private static final int TYPE_MSG = 0;
    private static final int TYPE_MISUC = 1;
    private static final int TYPE_VIDEO = 2;
    private static final int TYPE_TAB = 3;

    public DynamicListAdapter(Context context, List<BaseEntity> list) {
        super(context, list);
    }

    @Override
    public DynamicBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_TAB) {
            return new DynamicHeaderHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.item_dynamic_head, parent, false));
        } else if (viewType == TYPE_VIDEO) {
            return new DynamicVideoViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.item_dynamic_video, parent, false));
        } else if (viewType == TYPE_MISUC) {
            return new DynamicMusicViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.item_dynamic_music, parent, false));
        } else {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_dynamic_public, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        super.onBindViewHolder(viewHolder, position);
        BaseEntity entity = list.get(position);
        if (entity instanceof DynamicTabEntity) {
            ((DynamicHeaderHolder) viewHolder).onBindView((DynamicTabEntity) entity);
        } else if (getItemViewType(position) == TYPE_MISUC) {
            ((DynamicMusicViewHolder) viewHolder).onBindView((DynamicEntity) entity);
        } else if (getItemViewType(position) == TYPE_VIDEO) {
            ((DynamicVideoViewHolder) viewHolder).onBindView((DynamicEntity) entity);
        } else if (getItemViewType(position) == TYPE_MSG) {
            ((DynamicMusicViewHolder) viewHolder).onBindView((DynamicEntity) entity);
        } else {
            ((ViewHolder) viewHolder).onBindView((DynamicEntity) entity);
        }
    }

    public class ViewHolder extends DynamicBaseViewHolder<DynamicEntity> {

        public ViewHolder(@NonNull View itemView) {
            super(mContext, itemView);
        }

        @Override
        public void onBindView(DynamicEntity entity) {
            initHeaderContent(entity.getUser(), entity.getJson(), entity.getEventTime());
        }
    }

    @Override
    public void setOnClickListener(OnRecyclerViewClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemViewType(int position) {
        int type = -1;
        if (list.get(position) instanceof DynamicTabEntity) {
            type = TYPE_TAB;
        } else {
            String json = ((DynamicEntity) list.get(position)).getJson();
            Object t = DynamicItemUtils.parsedynamicJson(json);
            if (t instanceof DynamicMsgEntity) {
                type = TYPE_MSG;
            } else if (t instanceof DynamicMusicEntity) {
                type = TYPE_MISUC;
            } else if (t instanceof DynamicVideoEntity) {
                type = TYPE_VIDEO;
            } else if (t instanceof DynamicTabEntity) {
                type = TYPE_TAB;
            }
        }
        return type;
    }

    public void addHeaderView(View view) {
        if (view == null)
            return;
        notifyItemInserted(0);
    }
}
