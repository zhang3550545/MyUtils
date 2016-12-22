package com.yiba.test.myutils;

import android.content.Context;

/**
 * Created by Widsom Zhang on 2016/12/22.
 */

public class ScreenUtils {

    public static int getScreenWidthPx(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeightPx(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int getScreenWidthDp(Context context) {
        int width = getScreenWidthPx(context);
        float d = getDensity(context);
        width = (int) (width / d);
        return width;
    }

    public static int getScreenHeightDp(Context context) {
        int height = getScreenHeightPx(context);
        float d = getDensity(context);
        height = (int) (height / d);
        return height;
    }

    public static int dp2px(Context context, int dp) {
        return (int) (getDensity(context) * dp);
    }

    public static int px2dp(Context context, int px) {
        float d = getDensity(context);
        return (int) (px / d);
    }
}
