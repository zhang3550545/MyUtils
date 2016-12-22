package com.yiba.test.myutils;

import android.content.Context;


/**
 * Created by Widsom Zhang on 2016/12/22.
 */

public class PackageUtils {
    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static int getVersionCode(Context context) {
        return BuildConfig.VERSION_CODE;
    }

    public static String getVersionName(Context context) {
        return BuildConfig.VERSION_NAME;
    }
}
