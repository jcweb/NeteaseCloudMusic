package com.app.tools.util;

import java.text.DecimalFormat;

/*
 * 封装一个计算工具方法：
 * 如果过亿，保留1位小数，比如1.1亿
 * 如果过万不到亿，保留整数，比如2123万
 * 如果不过万，显示整数，比如1234
 * */
public class MathUtils {
    private static final int TEN_THOUSAND = 10000;
    private static final int HUNDRED_MILLION = 10000 * TEN_THOUSAND;
    private static DecimalFormat df = new DecimalFormat("0.0");

    public static String formNumberToStr(long num) {
        String result = "";
        if (num < TEN_THOUSAND) {
            result = String.valueOf(num);
        } else if (num > TEN_THOUSAND && num < HUNDRED_MILLION) {
            result = num / TEN_THOUSAND + "万";
        } else if (num > HUNDRED_MILLION) {
            result = df.format((float) num / HUNDRED_MILLION) + "亿";
        }
        return result;
    }
}
