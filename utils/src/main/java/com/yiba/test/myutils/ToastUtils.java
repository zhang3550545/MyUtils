package com.yiba.test.myutils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Widsom Zhang on 2016/12/22.
 */

public class ToastUtils {

    private static Toast toast;

    public static void showShort(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(Context context, @StringRes int message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void showLong(Context context, @StringRes int message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void showSingle(Context context, String message) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(message);
        toast.show();
    }

    public static void showSingle(Context context, @StringRes int message) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(message);
        toast.show();
    }

    public static void showCenter(Context context, String message) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(message);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showCenter(Context context, @StringRes int message) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(message);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showCustom(Context context, View view) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setView(view);
        toast.show();
    }
}
