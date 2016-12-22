package com.yiba.test.myutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;

import java.util.Locale;

/**
 * Created by Administrator on 2016/10/8.
 */

public class PhoneInfoUtils {

    /**
     * 获取包名
     */
    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    /**
     * 获取版本号
     */
    public static int getVersionCode(Context context) {
        return BuildConfig.VERSION_CODE;
    }

    /**
     * 获取版本名
     */
    public static String getVersionName(Context context) {
        return BuildConfig.VERSION_NAME;
    }

    /**
     * 获取设备id
     */
    @SuppressLint("HardwareIds")
    public static String getDeviceId(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (manager != null) {
            return manager.getDeviceId();
        }
        return "";
    }

    /**
     * 获取手机型号
     */
    public static String getPhoneModel() {
        return Build.MODEL;
    }

    /**
     * 获取手机商标
     */
    public static String getPhoneBrand() {
        return Build.BRAND;
    }

    /**
     * 获取手机当前版本号
     */
    public static int getOsVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 获取手机当前版本型号
     */
    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取当前连接的网络类型
     */
    public static String getNetType(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) {
            return info.getTypeName();
        }
        return "";
    }

    /**
     * 获取本地当前的语言
     */
    public static String getDefalutLoacleLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取本地语言的国家
     */
    public static String getDefaultLocaleCountry() {
        return Locale.getDefault().getCountry();
    }

    /**
     * 获取本地语言及国家
     */
    public static String getLocale() {
        return Locale.getDefault().toString();
    }

}
