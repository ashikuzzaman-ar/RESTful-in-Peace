package com.studevs.dummy.restful.in.peace.utility.service;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ashik
 */
public class Encrypt implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String[] SALT_KEY = new String[]{"ChoOsEyouRheADer", "tHIsIstaIl", "i\"MCOnfUsed", "WHatTHeHeLLIsthiS"/*MAny More should be added*/};

    public String generateHash(final String input, final Long id) {

        @SuppressWarnings("StringBufferWithoutInitialCapacity")
        StringBuilder hash = new StringBuilder();

        try {

            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = sha.digest((SALT_KEY[(int) (id % SALT_KEY.length)] + input).getBytes());
            char[] digits = {'2', 'C', 'A', '3', 'b', '5', '1', '7', 'E', '9',
                'a', 'B', 'c', 'D', 'e', 'f'};

            for (int idx = 0; idx < hashedBytes.length; ++idx) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {

            throw new ExceptionInInitializerError(e);
        }

        return hash.toString();
    }
}
