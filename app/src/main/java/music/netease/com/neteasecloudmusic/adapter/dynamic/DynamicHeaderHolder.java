package music.netease.com.neteasecloudmusic.adapter.dynamic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.app.tools.widget.CircularImageView;
import com.bumptech.glide.Glide;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicTabEntity;

public class DynamicHeaderHolder extends DynamicBaseViewHolder<DynamicTabEntity> {
    private TabLayout tabLayout;

    public DynamicHeaderHolder(Context context, @NonNull View itemView) {
        super(context, itemView);
        tabLayout = itemView.findViewById(R.id.tl_atten);
    }

    @Override
    public void onBindView(DynamicTabEntity entity) {
        tabLayout.removeAllTabs();
        for (int i = 0; i < entity.getFollow().size(); i++) {
            tabLayout.addTab(tabLayout.newTab());
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            View tabView = LayoutInflater.from(context).inflate(R.layout.layout_item_tab, tabLayout, false);
            tab.setCustomView(tabView);
            CircularImageView iv = tabView.findViewById(R.id.iv_tab_item);
            TextView tabName = tabView.findViewById(R.id.tv_tab_item);
            tabName.setText(entity.getFollow().get(i).getNickname());

            Glide.with(context).load(entity.getFollow().get(i).getAvatarUrl()).into(iv);
        }
    }

}
