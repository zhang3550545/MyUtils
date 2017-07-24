package com.yiba.test.myutils;

import android.content.Context;
import android.os.Looper;
import android.os.Process;

import java.util.Locale;

/**
 * Created by Widsom Zhang on 2016/12/22.
 */

public class CommonUtils {
    /**
     * 是否是主线程
     */
    public static boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    /**
     * 获取Pid
     */
    public static int getPID(Context context) {
        return Process.myPid();
    }

    /**
     * 获取UID
     */
    public static int getUID() {
        return Process.myUid();
    }

    /**
     * 获取TID
     */
    public static int getTID() {
        return Process.myTid();
    }
}
