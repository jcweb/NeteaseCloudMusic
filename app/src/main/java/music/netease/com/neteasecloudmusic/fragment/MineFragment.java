package music.netease.com.neteasecloudmusic.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.activity.MusicListActivity;
import music.netease.com.neteasecloudmusic.callback.DataCallBack;
import music.netease.com.neteasecloudmusic.model.CreateModel;
import music.netease.com.neteasecloudmusic.presenter.mine.CreateModelImpl;

/**
 * 我的
 */
public class MineFragment extends Fragment implements View.OnClickListener {
    private String uid = "118006451";//临时使用，后续会从登录接口中取
    private String nickname = "eijnhec";//临时使用，后续会从登录接口中取

    private static final int limit = 100;//请求的歌单数量
    private LinearLayout containerCreate;
    private LinearLayout containerCollect;
    private TextView tvNumCreate;//创建的歌单数量
    private TextView tvNumCollect;//收藏的歌单数量
    private TabLayout tabLayout;//导航栏
    private int numCreate = 0;
    private int numCollect = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        getUserCreateList();
    }

    private void initView() {
        containerCreate = getActivity().findViewById(R.id.ll_container_create);
        containerCollect = getActivity().findViewById(R.id.ll_container_collect);
        tvNumCreate = getActivity().findViewById(R.id.tv_num_create);
        tvNumCollect = getActivity().findViewById(R.id.tv_num_collect);
        tabLayout = getActivity().findViewById(R.id.tl_mine);
        getActivity().findViewById(R.id.ll_header_collect).setOnClickListener(this);
        getActivity().findViewById(R.id.ll_header_create).setOnClickListener(this);
        /**动态加载导航栏**/
        setNavigationBar();
    }

    private void setNavigationBar() {
        String[] tabStr = getActivity().getResources().getStringArray(R.array.mine_tab);
        for (int i = 0; i < tabStr.length; i++) {
            tabLayout.addTab(tabLayout.newTab());
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            View tabView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_tab, tabLayout, false);
            tab.setCustomView(tabView);
            TextView tabName = tabView.findViewById(R.id.tv_tab_item);
            tabName.setText(tabStr[i]);
            ImageView imageView = tabView.findViewById(R.id.iv_tab_item);
            imageView.setImageResource(R.mipmap.ic_tab_raking);
        }
    }

    /*获取用户创建的歌单*/
    private void getUserCreateList() {
        CreateModelImpl createModel = new CreateModelImpl();
        createModel.getCreateList(uid, limit, new DataCallBack<CreateModel>() {
            @Override
            public void requestBefore() {

            }

            @Override
            public void requestSuccess(CreateModel data) {
                if (data.getCode() != 200)
                    return;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (data != null) {
                            for (int i = 0; i < data.getPlaylist().size(); i++) {
                                CreateModel.PlaylistBean bean = data.getPlaylist().get(i);
                                autoAddCreateItem(bean);
                            }
                            tvNumCreate.setText("(" + numCreate + ")");
                            tvNumCollect.setText("(" + numCollect + ")");
                        }
                    }
                });
            }

            @Override
            public void requestError(String msg) {

            }
        });
    }

    /*动态加载用户创建的歌单*/
    private void autoAddCreateItem(CreateModel.PlaylistBean bean) {
        View item;
        if (bean.getCreator().getNickname().equals(nickname)) {
            item = LayoutInflater.from(getContext()).inflate(R.layout.mine_list_item, containerCreate, false);
        } else {
            item = LayoutInflater.from(getContext()).inflate(R.layout.mine_list_item, containerCollect, false);
        }

        TextView tvName = item.findViewById(R.id.tv_mine_item_name);
        TextView tvNum = item.findViewById(R.id.tv_mine_item_num);
        ImageView ivIcon = item.findViewById(R.id.iv_mine_item_icon);
        tvName.setText(bean.getName());
        Glide.with(getContext()).load(bean.getCoverImgUrl())
                .bitmapTransform(new CropSquareTransformation(getActivity())).into(ivIcon);
        if (bean.getCreator().getNickname().equals(nickname)) {
            tvNum.setText(bean.getTrackCount() + "首");
            numCreate++;
            containerCreate.addView(item);
        } else {
            tvNum.setText(bean.getTrackCount() + "首 by " + bean.getCreator().getNickname());
            numCollect++;
            containerCollect.addView(item);
        }

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MusicListActivity.class);
                intent.putExtra("songId", String.valueOf(bean.getId()));
                intent.putExtra("albumName", bean.getName());
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_header_collect) {
            containerCollect.setVisibility(containerCollect.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        } else if (v.getId() == R.id.ll_header_create)
            containerCreate.setVisibility(containerCreate.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
    }
}
