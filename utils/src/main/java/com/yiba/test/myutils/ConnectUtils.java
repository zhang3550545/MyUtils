package com.yiba.test.myutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.net.NetworkInfo.State;

/**
 * Created by Widsom Zhang on 2016/12/21.
 */

public class ConnectUtils {

    private ConnectUtils() throws IllegalAccessException {
        throw new IllegalAccessException("");
    }

    private static ConnectivityManager getManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public static boolean isAvailableNetWork(Context context) {
        ConnectivityManager manager = getManager(context);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null && info.isAvailable();
    }

    public static boolean isConnectedNetWork(Context context) {
        ConnectivityManager manager = getManager(context);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    /**
     * @return Type:
     * -1   表示连接类型不存在
     * 0    表示移动网络
     * 1    表示WiFi网络
     */
    public static int getNetWorkType(Context context) {
        int type = -1;
        ConnectivityManager manager = getManager(context);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) {
            switch (info.getType()) {
                case ConnectivityManager.TYPE_MOBILE:
                    type = 0;
                    break;
                case ConnectivityManager.TYPE_WIFI:
                    type = 1;
                    break;
            }
        }
        return type;
    }

    public static String getNetWorkState(Context context) {
        ConnectivityManager manager = getManager(context);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) {
            if (info.getState().equals(State.CONNECTED)) {
                return "CONNECTED";
            } else if (info.getState().equals(State.CONNECTING)) {
                return "CONNECTING";
            } else if (info.getState().equals(State.DISCONNECTED)) {
                return "DISCONNECTED";
            } else if (info.getState().equals(State.DISCONNECTING)) {
                return "DISCONNECTING";
            } else if (info.getState().equals(State.SUSPENDED)) {
                return "SUSPENDED";
            } else if (info.getState().equals(State.UNKNOWN)) {
                return "UNKNOWN";
            }
        }
        return "UNKNOWN";
    }
}
