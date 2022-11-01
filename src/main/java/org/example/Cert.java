package org.example;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Cert {
    public static String[] getKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512);
        KeyPair keypair = keyGen.genKeyPair();

        byte[] publicKey = keypair.getPublic().getEncoded();
        StringBuilder retPublicKeyString = new StringBuilder();
        for (byte b : publicKey) {
            retPublicKeyString.append(Integer.toHexString(0x0100 + (b & 0x00FF)).substring(1));
        }

        byte[] privateKey = keypair.getPrivate().getEncoded();
        StringBuilder retPrivateKeyString = new StringBuilder();
        for (byte b : privateKey) {
            retPrivateKeyString.append(Integer.toHexString(0x0100 + (b & 0x00FF)).substring(1));
        }

        return new String[]{ retPublicKeyString.toString(), retPrivateKeyString.toString() };
    }
}
