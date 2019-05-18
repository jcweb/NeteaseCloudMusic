package music.netease.com.neteasecloudmusic.config;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

public class GlideConfig implements GlideModule {
    public static final int DISK_CACHE_SIZE = 1024 * 1024 * 600;//最多可以缓存多少字节的数据
    public static final String DISK_CACHE_NAME = "/GlideDisk";
    public static String appRootPath = "";
    public static String sdRootPath = Environment.getExternalStorageDirectory().getPath() + DISK_CACHE_NAME;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
//1.设置Glide内存缓存大小
        int maxMemory = (int) Runtime.getRuntime().maxMemory();//获取系统分配给应用的总内存大小
        int memoryCacheSize = maxMemory / 8;//设置图片内存缓存占用八分之一
        //设置内存缓存大小
        builder.setMemoryCache(new LruResourceCache(memoryCacheSize));
        Glide.get(context).setMemoryCategory(MemoryCategory.HIGH);
        appRootPath = context.getCacheDir().getPath() + "/GlideDisk";
        // 2.设置Glide磁盘缓存大小
        File cacheDir = context.getExternalCacheDir();//指定的是数据的缓存地址
        int diskSize = DISK_CACHE_SIZE;
        //设置磁盘缓存大小
        if (cacheDir != null) {
        builder.setDiskCache(new DiskLruCacheFactory(sdRootPath, diskSize));
        }
        //builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, DISK_CACHE_NAME, diskSize));

        //3.设置图片解码格式
        // builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        builder.setDecodeFormat(DecodeFormat.PREFER_RGB_565);

        //4.设置BitmapPool缓存内存大小
        builder.setBitmapPool(new LruBitmapPool(memoryCacheSize));
    }

    private String getStorageDirectory() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ?
                sdRootPath : appRootPath;
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
//        glide.register(GlideUrl.class, InputStream.class, new HttpUrlGlideUrlLoader.Factory());
    }
}
