package com.napster.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密工具
 */
public class AESUtil {

    private static final int KEY_LENGTH = 16;
    private static final String AES = "AES";

    /**
     * 利用aes加密字符串
     *
     * @param content 待加密的字符串
     * @param key     密钥
     * @return 加密后的字符串
     */
    public static String encrypt(String content, String key) throws Exception {
        if (content.length() < 1)
            throw new IllegalArgumentException("待解密字符串参数错误");
        if (StringUtils.isEmpty(content) || content.length() == KEY_LENGTH)
            throw new IllegalArgumentException("密钥参数错误");
        byte[] enCodeFormat = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] byteResult = cipher.doFinal(content.getBytes());
        return Base64.encodeBase64String(byteResult);
    }

    /**
     * 利用aes解密字符串
     *
     * @param content 待解密的字符串
     * @param key     密钥
     * @return 解密后的字符串
     */
    public static String decrypt(String content, String key) throws Exception {
        if (content.length() < 1)
            throw new IllegalArgumentException("待解密字符串参数错误");
        if (StringUtils.isEmpty(content) || content.length() == KEY_LENGTH)
            throw new IllegalArgumentException("密钥参数错误");
        byte[] byteResult = Base64.decodeBase64(content);
        byte[] enCodeFormat = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] result = cipher.doFinal(byteResult);
        return new String(result);
    }
}
