package music.netease.com.neteasecloudmusic.adapter.discover;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.tools.widget.XCRoundRectImageView;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.ArrayList;
import java.util.List;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.model.BaseEntity;
import music.netease.com.neteasecloudmusic.model.discover.BannerEntity;
import music.netease.com.neteasecloudmusic.model.discover.BannerModel;

public class DisBannerViewHolder extends RecyclerView.ViewHolder {
    private XBanner xBanner;
    private Context context;

    public DisBannerViewHolder(Context context, @NonNull View itemView) {
        super(itemView);
        this.context = context;
        xBanner = itemView.findViewById(R.id.xbanner_dis);
    }

    public void bindViewHolder(BaseEntity entity) {
        BannerModel bannerModel = (BannerModel) entity;

        List<BannerEntity> list = new ArrayList<>();
        list.addAll(bannerModel.getBanners());
        list.addAll(bannerModel.getBanners());
        list.addAll(bannerModel.getBanners());

        xBanner.setBannerData(R.layout.item_banner, list);
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                XCRoundRectImageView iv = view.findViewById(R.id.iv_banner);
                TextView tv = view.findViewById(R.id.tv_banner);
                Glide.with(context).load(list.get(position).getPic()).into(iv);
                tv.setText(list.get(position).getTypeTitle());
            }
        });
    }
}
