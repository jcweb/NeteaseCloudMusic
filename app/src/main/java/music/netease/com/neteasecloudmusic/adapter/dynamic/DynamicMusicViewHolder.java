package music.netease.com.neteasecloudmusic.adapter.dynamic;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.tools.widget.XCRoundRectImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.activity.ImagePreviewActivity;
import music.netease.com.neteasecloudmusic.constant.ImageCanstant;
import music.netease.com.neteasecloudmusic.model.DynamicEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicMusicEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.RcmdInfoEntity;
import music.netease.com.neteasecloudmusic.utils.JsonUtils;
import music.netease.com.neteasecloudmusic.widget.DynamicImageView;

public class DynamicMusicViewHolder extends DynamicBaseViewHolder<DynamicEntity> {
    private DynamicImageView imageView;
    private ArrayList<String> originalList;
    private RelativeLayout rlContainer;
    private XCRoundRectImageView xcRoundRectImageView;
    private TextView tvMusicName;
    private TextView tvMusicAuthor;

    public DynamicMusicViewHolder(Context context, @NonNull View itemView) {
        super(context, itemView);
        imageView = itemView.findViewById(R.id.div_pic);
        rlContainer = itemView.findViewById(R.id.rl_music_container);
        xcRoundRectImageView = itemView.findViewById(R.id.iv_item_dynamic_music);
        tvMusicAuthor = itemView.findViewById(R.id.tv_item_dynamic_music_author);
        tvMusicName = itemView.findViewById(R.id.tv_item_dynamic_music_name);
        originalList = new ArrayList<>();
    }

    @Override
    public void onBindView(DynamicEntity entity) {
        detailOtherView(entity.getJson(), entity);
        imageView.setIsShowAll(true);
        if (entity.getPics() == null || entity.getPics().size() == 0) {
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setVisibility(View.VISIBLE);
            if (entity.getPics().size() == 1) {
                imageView.setScale(entity.getPics().get(0).getWidth() * 1.0f / entity.getPics().get(0).getHeight());
                List<String> list = new ArrayList<>();
                list.add(entity.getPics().get(0).getOriginUrl());
                originalList.clear();
                originalList.add(entity.getPics().get(0).getOriginUrl());
                imageView.setUrlList(list);
            } else {
                imageView.setUrlList(getPicUrl(entity.getPics()));
            }
            imageView.setOnItemClick(new DynamicImageView.OnItemClick() {
                @Override
                public void onClick(int position) {
                    Intent intent = new Intent(context, ImagePreviewActivity.class);
                    intent.putExtra(ImageCanstant.START_IAMGE_POSITION, position);
                    intent.putExtra(ImageCanstant.START_ITEM_POSITION, position);
                    intent.putStringArrayListExtra("imageList", originalList);
                    context.startActivity(intent);
                }
            });
        }

    }

    /*获取所有图片的url*/
    private List<String> getPicUrl(List<DynamicEntity.PicsBean> listPic) {
        List<String> list = new ArrayList<>();
        originalList.clear();
        for (int i = 0; i < listPic.size(); i++) {
            list.add(listPic.get(i).getPcSquareUrl());
            originalList.add(listPic.get(i).getOriginUrl());
        }
        return list;
    }

    /*处理图片以外的view*/
    private void detailOtherView(String json, DynamicEntity entity) {
        DynamicMusicEntity bean = JsonUtils.getParam(json, DynamicMusicEntity.class);
        if (entity.getRcmdInfo() == null) {
            initHeaderContent(entity.getUser(), bean.getMsg(), entity.getEventTime());

        } else {
            JSONObject object = new JSONObject((Map) entity.getRcmdInfo());
            RcmdInfoEntity rcmdInfoEntity = JsonUtils.getParam(object.toString(), RcmdInfoEntity.class);
            initHeaderContent(entity.getUser(), bean.getMsg(), rcmdInfoEntity.getUserReason());
            //处理歌曲相关的view
            if (bean.getSong() != null) {
                tvMusicName.setText(bean.getSong().getName());
                String author = "";
                for (int i = 0; i < bean.getSong().getArtists().size(); i++) {
                    author += bean.getSong().getArtists().get(i).getName();
                    if (i < bean.getSong().getArtists().size() - 1) {
                        author += "/";
                    }
                }
                tvMusicAuthor.setText(author);
                String iconUrl = bean.getSong().getAlbum().getPicUrl();

                Glide.with(context).load(iconUrl).diskCacheStrategy(DiskCacheStrategy.ALL).into(xcRoundRectImageView);
            }
        }
    }
}
