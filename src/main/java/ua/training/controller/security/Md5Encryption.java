package ua.training.controller.security;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by andrii on 25.01.17.
 */
public class Md5Encryption {
    public static String encrypt(String st) {
        return DigestUtils.md5Hex(st);
    }
}
