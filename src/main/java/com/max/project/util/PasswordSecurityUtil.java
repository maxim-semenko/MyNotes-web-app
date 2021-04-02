package com.max.project.util;

import lombok.extern.log4j.Log4j2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class that performs the function of hashing passwords.
 *
 * @author Maxim Semenko
 * @version 0.0.1
 */
@Log4j2
public class PasswordSecurityUtil {


    /**
     * Method hashing password.
     *
     * @param password {@link String} in text format
     * @return {@link String} in MD5 format
     */
    public static String doHashing(String password) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] resultByteArray = messageDigest.digest();

            for (byte b : resultByteArray) {
                sb.append(String.format("%02X", b));
            }
        } catch (NoSuchAlgorithmException e) {
            log.error("Can't hash password ", e);
        }
        return sb.toString();
    }

}
