
package music.netease.com.neteasecloudmusic.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;

import java.util.List;

import jp.wasabeef.glide.transformations.internal.Utils;

public class ImagePreviewAdapter extends PagerAdapter {
    private Context context;
    private List<String> imageList;
    private int itemPosition;
    private PhotoView photoView;

    public ImagePreviewAdapter(Context context, List<String> imageList, int itemPosition) {
        this.context = context;
        this.imageList = imageList;
        this.itemPosition = itemPosition;
    }

    @Override
    public int getCount() {
        return imageList == null ? 0 : imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final PhotoView image = new PhotoView(context);
        // 启用图片缩放功能
        image.enable();
        Glide.with(context).load(imageList.get(position)).into(image);


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setEnabled(false);
                ((Activity) context).onBackPressed();
            }
        });
        container.addView(image);
        return image;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        photoView = (PhotoView) object;
        photoView.setTag(getNameByPosition(itemPosition, position));
        photoView.setTransitionName(getNameByPosition(itemPosition, position));
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    public PhotoView getPhotoView() {
        return photoView;
    }

    public String getNameByPosition(int itemPosition, int i) {
        String name = itemPosition + "_0";
        switch (i) {
            case 0:
                name = itemPosition + "_" + 0;
                break;
            case 1:
                name = itemPosition + "_" + 1;
                break;
            case 2:
                name = itemPosition + "_" + 2;
                break;
            case 3:
                name = itemPosition + "_" + 3;
                break;
            case 4:
                name = itemPosition + "_" + 4;
                break;
            case 5:
                name = itemPosition + "_" + 5;
                break;
            case 6:
                name = itemPosition + "_" + 6;
                break;
            case 7:
                name = itemPosition + "_" + 7;
                break;
            case 8:
                name = itemPosition + "_" + 8;
                break;

        }
        return name;
    }
}
