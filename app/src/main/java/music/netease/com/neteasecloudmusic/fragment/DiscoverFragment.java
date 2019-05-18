package music.netease.com.neteasecloudmusic.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.adapter.discover.DiscoverAdapter;
import music.netease.com.neteasecloudmusic.model.BaseEntity;
import music.netease.com.neteasecloudmusic.model.discover.BannerModel;
import music.netease.com.neteasecloudmusic.presenter.discover.BannerModelImpl;
import music.netease.com.neteasecloudmusic.view.IDisFragment;

/**
 * 发现
 * 整体是一个recycleview
 * type1：广告栏banner
 * type2：五大类tablayout
 * type3：推荐歌单 6个button
 * type4：新碟 3个button
 * type5：视频 多个item
 */
public class DiscoverFragment extends Fragment implements IDisFragment {
    private DiscoverAdapter adapter;
    private List<BaseEntity> list;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discover, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.rv_discover);
        list = new ArrayList<>();
        adapter = new DiscoverAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        BannerModelImpl bannerModel = new BannerModelImpl(this);
        String[] bannerType = getResources().getStringArray(R.array.banner_type);
        bannerModel.getBannerList(bannerType[1]);
    }

    @Override
    public void update(List<BaseEntity> discoverList) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                list.addAll(discoverList);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
