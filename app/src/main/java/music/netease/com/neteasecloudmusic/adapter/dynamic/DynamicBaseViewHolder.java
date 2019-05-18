package music.netease.com.neteasecloudmusic.adapter.dynamic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.app.tools.util.TimeSpecialUtils;
import com.app.tools.widget.CircularImageView;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.model.BaseEntity;
import music.netease.com.neteasecloudmusic.model.DynamicEntity;

/*封装所有item头部的layout*/
public abstract class DynamicBaseViewHolder<T> extends RecyclerView.ViewHolder {
    private TextView tvName;
    private TextView tvContent;
    private TextView tvDate;
    private CircularImageView civUser;
    protected Context context;
    private TextView tvAtten;

    public DynamicBaseViewHolder(Context context, @NonNull View itemView) {
        super(itemView);
        this.context = context;
        tvContent = itemView.findViewById(R.id.tv_dynamic_content);
        tvDate = itemView.findViewById(R.id.tv_dynamic_date_or_fans);
        tvName = itemView.findViewById(R.id.tv_dynamic_user);
        civUser = itemView.findViewById(R.id.iv_dynamic_head);
        tvAtten = itemView.findViewById(R.id.tv_dynamic_atten);
    }

    /*加载头部的布局*/
    public void initHeaderContent(DynamicEntity.UserBean entity, String content, long lasttime) {

        tvName.setText(entity.getNickname());
        tvDate.setText(TimeSpecialUtils.getTimeContent(lasttime));
        Glide.with(context).load(entity.getAvatarUrl()).into(civUser);
        tvAtten.setVisibility(View.GONE);
        if (TextUtils.isEmpty(content)) {
            tvContent.setVisibility(View.GONE);
        } else {
            tvContent.setText(content);
        }
    }

    public void initHeaderContent(DynamicEntity.UserBean entity, String content, String fansNum) {

        tvName.setText(entity.getNickname());
        tvDate.setText(fansNum);
        tvAtten.setVisibility(View.VISIBLE);
        Glide.with(context).load(entity.getAvatarUrl()).into(civUser);
        if (TextUtils.isEmpty(content)) {
            tvContent.setVisibility(View.GONE);
        } else {
            tvContent.setText(content);
        }
    }

    public abstract void onBindView(T entity);
}
