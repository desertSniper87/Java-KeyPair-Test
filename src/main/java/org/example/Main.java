package org.example;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] keypair = Cert.getKeyPair();

        System.out.println("Public Key:");
        System.out.println(keypair[0]);

        System.out.println("Private Key:");
        System.out.println(keypair[1]);

    }
}