package com.app.tools.util;

import java.text.SimpleDateFormat;

public class TimeSpecialUtils {
    /*通过当前时间和目标时间(毫秒)作对比
    小于一分钟显示刚刚
    大于一分钟不到一小时显示xx分钟前
    大于一小时小于一天显示xx小时前
    大于一天显示类似2月3号*/
    private static final int ONE_MINUTES = 60 * 1000;
    private static final int ONE_HOUR = 60 * 60 * 1000;
    private static final long ONE_DAY = 60 * 60 * 24 * 1000;

    public static String getTimeContent(long lasttime) {
        String content = " ";
        long section = System.currentTimeMillis() - lasttime;
        if (section < ONE_MINUTES) {
            content = "刚刚";
        } else if (section > ONE_MINUTES && section < ONE_HOUR) {
            content = section / ONE_MINUTES + "分钟前";
        } else if (section >= ONE_HOUR && section < ONE_DAY) {
            content = section / ONE_HOUR + "小时前";
        } else {
            content = getStringDate(lasttime);
        }
        return content;
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        String dateString = formatter.format(time);
        return dateString;
    }
}
