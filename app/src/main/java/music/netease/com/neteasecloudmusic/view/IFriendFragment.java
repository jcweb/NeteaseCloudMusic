package music.netease.com.neteasecloudmusic.view;

import java.util.List;

import music.netease.com.neteasecloudmusic.model.DynamicEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicTabEntity;

public interface IFriendFragment {
    void update(List<DynamicEntity> list);

    void loadTabList(DynamicTabEntity tabEntity);
}
