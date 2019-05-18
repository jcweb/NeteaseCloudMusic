package music.netease.com.neteasecloudmusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import music.netease.com.neteasecloudmusic.R;


public class FragmentAdapter extends FragmentPagerAdapter {
    private String[] title;
    private List<Fragment> list;
    private Context context;

    public FragmentAdapter(Context context, @NonNull FragmentManager fm, String[] title, List<Fragment> list) {
        super(fm);
        this.title = title;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_feedback_text, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_tab_item);
        tv.setText(title[position]);
        return view;
    }
}
