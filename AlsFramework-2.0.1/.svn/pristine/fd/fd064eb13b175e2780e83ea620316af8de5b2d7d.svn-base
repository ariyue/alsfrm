package com.als.abc.module.classloader;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 2 有了key之后就可以对class进行加密了：
 * @author Vincent
 *
 */
public class Crypt {

    public static void main(String[] args) throws Exception {

        SecureRandom sr = new SecureRandom();
        FileInputStream fi = new FileInputStream(new File("d:/key.txt"));
        byte rawKeyData[] = new byte[fi.available()];
        fi.read(rawKeyData);
        fi.close();
        DESKeySpec dks = new DESKeySpec(rawKeyData);
        SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key, sr);
        FileInputStream fi2 = new FileInputStream(new File("d:/HelloWorld.class"));
        byte data[] = new byte[fi2.available()];
        fi2.read(data);
        fi2.close();
        byte encryptedData[] = cipher.doFinal(data);
        FileOutputStream fo = new FileOutputStream(new File("d:/HelloWorld.class"));
        fo.write(encryptedData);
        fo.close();
        System.out.println("加密完成");
    }
}

