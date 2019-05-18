package music.netease.com.neteasecloudmusic.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.adapter.DynamicListAdapter;
import music.netease.com.neteasecloudmusic.model.BaseEntity;
import music.netease.com.neteasecloudmusic.model.DynamicEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicTabEntity;
import music.netease.com.neteasecloudmusic.presenter.friends.DynamicModelImpl;
import music.netease.com.neteasecloudmusic.view.IFriendFragment;

/**
 * 朋友
 */
public class FriendFragment extends Fragment implements IFriendFragment{
    private String uid = "118006451";//临时使用，后续会从登录接口中取
    private static final int PAGE_SIZE = 30;
    private RecyclerView recyclerView;
    private DynamicListAdapter dynamicListAdapter;
    private List<BaseEntity> list;
    private DynamicModelImpl dynamicModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friend, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        dynamicModel = new DynamicModelImpl(this);
        getDynamicList(System.currentTimeMillis());
    }

    private void initView() {
        list = new ArrayList<>();
        recyclerView = getActivity().findViewById(R.id.rv_dymanic_list);
        //添加Android自带的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dynamicListAdapter = new DynamicListAdapter(getContext(), list);
        recyclerView.setAdapter(dynamicListAdapter);

        recyclerView.addOnScrollListener(listener);
    }

    /*获取朋友动态和关注的人*/
    private void getDynamicList(long lasttime) {
        long test = 1557990337239L;
        dynamicModel.getAttenList(uid);
    }


    @Override
    public void update(List<DynamicEntity> dynamicList) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                list.clear();
                list.addAll(dynamicList);
                dynamicListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void loadTabList(DynamicTabEntity tabEntity) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dynamicModel.getDynamicList(PAGE_SIZE, -1);
                list.add(tabEntity);
                dynamicListAdapter.notifyDataSetChanged();
            }
        });
    }

    private RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int lastChildPosition = layoutManager.findLastCompletelyVisibleItemPosition();
            super.onScrolled(recyclerView, dx, dy);
        }
    };
}
