package com.yiba.test.myutils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Widsom Zhang on 2016/12/22.
 */

public class SPUtils {

    private static final String FILE_NAME = "sp";

    /**
     * 保存SP
     */
    public static void put(Context context, String key, Object value) {
        put(context, FILE_NAME, key, value);
    }

    public static void put(Context context, String name, String key, Object value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (value instanceof String) {
            edit.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            edit.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            edit.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            edit.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            edit.putFloat(key, (Float) value);
        } else {
            edit.putString(key, value.toString());
        }
        edit.apply();
    }

    /**
     * 获取SP
     */
    public static Object get(Context context, String key, Object defulatValue) {
        return get(context, FILE_NAME, key, defulatValue);
    }

    public synchronized static Object get(Context context, String name, String key, Object defulatValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        if (defulatValue instanceof String) {
            return sharedPreferences.getString(key, (String) defulatValue);
        } else if (defulatValue instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defulatValue);
        } else if (defulatValue instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) defulatValue);
        } else if (defulatValue instanceof Long) {
            return sharedPreferences.getLong(key, (Long) defulatValue);
        } else if (defulatValue instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) defulatValue);
        }
        return null;
    }

    /**
     * 清除SP
     */
    public static void clear(Context context) {
        clear(context, FILE_NAME);
    }

    public static void clear(Context context, String name) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.apply();
    }

    /**
     * 移除指定的SP
     */
    public static void remove(Context context, String key) {
        remove(context, FILE_NAME, key);
    }

    public static void remove(Context context, String name, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(key);
        edit.apply();
    }

    /**
     * 查询是否包含key的SP
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

    public static boolean contains(Context context, String name, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

}
