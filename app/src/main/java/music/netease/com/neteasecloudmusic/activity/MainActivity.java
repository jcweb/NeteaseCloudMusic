package music.netease.com.neteasecloudmusic.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.adapter.FragmentAdapter;
import music.netease.com.neteasecloudmusic.model.UserEntity;
import music.netease.com.neteasecloudmusic.fragment.DiscoverFragment;
import music.netease.com.neteasecloudmusic.fragment.FriendFragment;
import music.netease.com.neteasecloudmusic.fragment.MineFragment;
import music.netease.com.neteasecloudmusic.fragment.VideoFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private NavigationView navigationView;
    private ImageView ivUserIcon;
    private TextView tvUserName;
    private ViewPager viewpager;
    private RadioGroup rgMusic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        navigationView = findViewById(R.id.navigation_view);
        viewpager = findViewById(R.id.viewpager);
        rgMusic = findViewById(R.id.rg_music_bar);
        View header = LayoutInflater.from(this).inflate(R.layout.navigation_header, navigationView, false);
        ivUserIcon = header.findViewById(R.id.iv_user_icon);
        tvUserName = header.findViewById(R.id.tv_user_nick);
        navigationView.addHeaderView(header);
    }

    private void initData() {
        MineFragment mineFragment = new MineFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();
        FriendFragment friendFragment = new FriendFragment();
        VideoFragment videoFragment = new VideoFragment();
        List<Fragment> list = new ArrayList<>();
        list.add(mineFragment);
        list.add(discoverFragment);
        list.add(friendFragment);
        list.add(videoFragment);
        String[] title = getResources().getStringArray(R.array.tab_list);
        FragmentAdapter adapter = new FragmentAdapter(this, getSupportFragmentManager(), title, list);
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(0);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    rgMusic.check(R.id.rb_mine);
                } else if (position == 01) {
                    rgMusic.check(R.id.rb_discover);
                } else if (position == 2) {
                    rgMusic.check(R.id.rb_friend);
                } else if (position == 3) {
                    rgMusic.check(R.id.rb_video);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rgMusic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_mine:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.rb_discover:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.rb_friend:
                        viewpager.setCurrentItem(2);
                        break;
                    case R.id.rb_video:
                        viewpager.setCurrentItem(3);
                        break;
                }
            }
        });

        UserEntity entity = (UserEntity) getIntent().getSerializableExtra("user");
        if (entity != null) {
            Glide.with(this).load(entity.getIconUrl()).into(ivUserIcon);
            tvUserName.setText(entity.getNickName());
        }
    }

    @Override
    public void onClick(View v) {
    }
}
