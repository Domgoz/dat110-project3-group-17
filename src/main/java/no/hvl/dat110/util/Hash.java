package no.hvl.dat110.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static BigInteger hashOf(String entity) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(entity.getBytes());
            byte[] digest = md.digest();
            return new BigInteger(1, digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }

    public static BigInteger addressSize() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            int addressSizeBits = md.getDigestLength() * 8;
            return BigInteger.valueOf(2).pow(addressSizeBits);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }

    public static int bitSize() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return md.getDigestLength() * 8;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }

    public static String toHex(byte[] digest) {
        StringBuilder strbuilder = new StringBuilder();
        for (byte b : digest) {
            strbuilder.append(String.format("%02x", b & 0xff));
        }
        return strbuilder.toString();
    }
}