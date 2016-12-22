package com.yiba.test.myutils;

import android.text.TextUtils;
import android.util.Base64;

import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Widsom Zhang on 2016/12/1.
 */

public class EncryptUtils {

    private static final String CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
    private static final String AES = "AES";
    private static final String SHA1PRNG = "SHA1PRNG";
    private static final String KEY = "yiba_wifi";

    private static String getKey() {
        return MD5Util.MD5(KEY);
    }

    private static byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance(AES);
        SecureRandom sr = null;
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            sr = SecureRandom.getInstance(SHA1PRNG, "Crypto");
        } else {
            sr = SecureRandom.getInstance(SHA1PRNG);
        }
        sr.setSeed(seed);
        kgen.init(128, sr);
        SecretKey skey = kgen.generateKey();
        return skey.getEncoded();
    }

    /*
     * 加密
     */
    public static String encrypt(String cleartext) {
        if (TextUtils.isEmpty(cleartext)) {
            return cleartext;
        }
        try {
            byte[] result = encrypt(cleartext.getBytes());
            return Base64.encodeToString(result, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /*
    * 加密
    */
    private static byte[] encrypt(byte[] clear) throws Exception {
        byte[] raw = getRawKey(getKey().getBytes());
        SecretKeySpec skeySpec = new SecretKeySpec(raw, AES);
        Cipher cipher = Cipher.getInstance(CBC_PKCS5_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(clear);
    }

    /*
     * 解密
     */
    public static String decrypt(String encrypted) {
        if (TextUtils.isEmpty(encrypted)) {
            return encrypted;
        }
        try {
            byte[] enc = Base64.decode(encrypted, 0);
            byte[] result = decrypt(enc);
            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /*
     * 解密
     */
    private static byte[] decrypt(byte[] encrypted) throws Exception {
        byte[] raw = getRawKey(getKey().getBytes());
        SecretKeySpec skeySpec = new SecretKeySpec(raw, AES);
        Cipher cipher = Cipher.getInstance(CBC_PKCS5_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(encrypted);
    }
}
