package music.netease.com.neteasecloudmusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.tools.adapter.BaseRecyclerAdapter;


import java.util.List;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.model.MusicEntity;

public class MusicListAdapter extends BaseRecyclerAdapter<MusicEntity, MusicListAdapter.ViewHolder> {
    public MusicListAdapter(Context context, List<MusicEntity> list) {
        super(context, list);
    }

    @Override
    public MusicListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return new ViewHolder(layoutInflater.inflate(R.layout.item_music_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MusicEntity entity = list.get(position);
        ViewHolder holder = (ViewHolder) viewHolder;
        String name = entity.getName();
        if (entity.getAlias() != null && entity.getAlias().size() > 0) {
            name = entity.getName() + "(" + entity.getAlias().get(0) + ")";
        }
        holder.tvMusicName.setText(name);

        String musicInfo = "";
        if (entity.getArtists() != null && entity.getArtists().size() > 0) {
            musicInfo = entity.getArtists().get(0).getName();
        }
        if (entity.getAlbum() != null && !TextUtils.isEmpty(entity.getAlbum().getName())) {
            musicInfo += " - " + entity.getAlbum().getName();
        }
        holder.tvMusicInfo.setText(musicInfo);
        holder.tvPosition.setText(position + "");
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPosition;
        private TextView tvIsSQ;
        private TextView tvMusicName;
        private TextView tvMusicInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIsSQ = itemView.findViewById(R.id.tv_is_sq);
            tvPosition = itemView.findViewById(R.id.tv_item_position);
            tvMusicInfo = itemView.findViewById(R.id.tv_music_item_info);
            tvMusicName = itemView.findViewById(R.id.tv_music_item_name);
        }
    }

}
